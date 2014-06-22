/**
 * Made by: TGrunt
 * Copyright (c) Jun 13, 2014
 */
package strat;

import org.parabot.environment.api.utils.Filter;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.Npcs;
import org.rev377.min.api.methods.Players;
import org.rev377.min.api.wrappers.Npc;
import org.rev377.min.api.wrappers.Player;

public class Attack implements Strategy {

    public static final int MONSTER_ID[] = { 1265, 1153, 84, 6221, 6278, 2455,
	    15462, 1615, 4418 };

    /*
     * Can handle multiple npc ID
     */

    @Override
    public boolean activate() {
	Player p = Players.getMyPlayer();
	return !Methods.isLowHealth(Players.getMyPlayer())
		&& (!p.isInCombat() || (p.getInteractingCharacter() != null && p
			.getInteractingCharacter().getHealth() <= 0));
    }

    @Override
    public void execute() {
	Npc target = getNextNPC();
	if (target != null && !target.isInCombat()) {
	    target.interact(1);
	    int i = 0;
	    while (!Players.getMyPlayer().isInCombat() && i++ < 10)
		Time.sleep(200, 500);

	}

    }

    private Npc getNextNPC() {
	Npc[] npc = Npcs.getNearest(new Filter<Npc>() {

	    public boolean accept(Npc npc) {
		for (int i : MONSTER_ID)
		    if (i == npc.getDef().getId() && !npc.isInCombat())
			return true;
		return false;
	    }
	});
	return npc.length > 0 ? npc[0] : null;

    }
}

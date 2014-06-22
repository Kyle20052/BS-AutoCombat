package strat;

import org.rev377.min.api.methods.Menu;
import org.rev377.min.api.wrappers.Player;

/**
 * Made by: TGrunt Copyright (c) Jun 13, 2014
 */

public class Methods {

    public static boolean isLowHealth(Player p) {
	if (p.getHealth() < p.getMaxHealth() / 3)
	    return true;
	return false;
    }
    public static void interactInventory(int id, int slot) {
	Menu.sendAction(961, id - 1, slot, 4521985);
    }
}

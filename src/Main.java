/**
 * Made by: TGrunt
 * Copyright (c) Jun 18, 2014
 */
import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

@ScriptManifest(author = "TGrunt", category = Category.COMBAT, description = "Fights anything - anywhere", name = "AutoCombat", servers = { "BattleScape Parabot & SingleCore 0.1 11" }, version = 1)
public class Main extends Script {

    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    @Override
    public boolean onExecute() {
	strategies.add(new strat.Eat());
	strategies.add(new strat.Drink());
	strategies.add(new strat.ReadScroll());
	strategies.add(new strat.Loot());
	strategies.add(new strat.Attack());
	provide(strategies);
	return true;
    }
}

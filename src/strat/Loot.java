package strat;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.GroundItems;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.wrappers.GroundItem;

public class Loot implements Strategy {

    private static final int[] LOOT_ID = { 998, 995, 2775, 2774, 2773, 2366,
	    11732, 204, 210, 200, 208, 201, 21627, 216, 218, 3050, 206, 212,
	    986, 214, 3052, 2486, 4151, 4150 };

    public boolean activate() {
	for (GroundItem l : GroundItems.getNearest(LOOT_ID)) {
	    return l != null;
	}
	return false;
    }

    public void execute() {
	for (GroundItem L : GroundItems.getNearest(LOOT_ID)) {
	    final GroundItem l = L;
	    if (l != null && !Inventory.isFull() && l.distanceTo() < 10) {
		l.interact(0);
		Time.sleep(new SleepCondition() {
		    @Override
		    public boolean isValid() {
			return l == null;
		    }
		}, 1000);
	    }

	}
    }

}

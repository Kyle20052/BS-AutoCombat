/**
 * Made by: TGrunt
 * Copyright (c) Jun 18, 2014
 */
package strat;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.methods.Menu;
import org.rev377.min.api.wrappers.Item;

public class ReadScroll implements Strategy {

    private static final int SCROLL_ID[] = { 2775, 2774 };
    private static int[] i;

    @Override
    public boolean activate() {
	i = Inventory.getInventoryItems();
	for (int id : i)
	    for (int scrollid : SCROLL_ID)
		if (id == scrollid)
		    return true;
	return false;
    }

    @Override
    public void execute() {
	for (Item it : Inventory.getItems())
	    for (int scrollid : SCROLL_ID)
		if (it.getId() == scrollid) {
		    Menu.sendAction(961, it.getId() - 1, it.getSlot(), 4521985);
		    Time.sleep(500, 900);
		}

    }

}

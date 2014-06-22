/**
 * Made by: TGrunt
 * Copyright (c) Jun 18, 2014
 */
package strat;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.wrappers.Item;

public class Drink implements Strategy {

    private final int POTION_ID[] = { 3031, 3029, 3027, 3025 };
    private long lastTime;

    @Override
    public boolean activate() {
	return System.currentTimeMillis() - lastTime > 55456;// cant seem to get
							     // interfaces
							     // so......
    }

    @Override
    public void execute() {
	Item pot = getNext();
	if (pot != null) {
	    Methods.interactInventory(pot.getId(), pot.getSlot());
	    lastTime = System.currentTimeMillis();
	}

    }

    private Item getNext() {
	for (int id : POTION_ID)
	    for (Item i : Inventory.getItems())
		if (i.getId() == id)
		    return i;
	return null;
    }

}
/**
 * Made by: TGrunt
 * Copyright (c) Jun 18, 2014
 */
package strat;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.wrappers.Item;

public class Drink implements Strategy {

    private static final int POTION_ID[] = { 3031, 3029, 3027, 3025 };

    private static long lastTime = 0;

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

/*
 * 
 * ID: 3031 Stack: 1 Slot: 0 ID: 3029 Stack: 1 Slot: 1 ID: 3027 Stack: 1 Slot: 2
 * ID: 3025 Stack: 1 Slot: 3
 */
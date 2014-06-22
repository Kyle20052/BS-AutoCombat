/**
 * Made by: TGrunt
 * Copyright (c) Jun 18, 2014
 */
package strat;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.methods.Players;
import org.rev377.min.api.wrappers.Item;

public class Eat implements Strategy {

    private static final int FOOD_ID[] = { 386 };
    private long lastTime = 0;

    @Override
    public boolean activate() {
	return Methods.isLowHealth(Players.getMyPlayer())
		&& Inventory.getCount(FOOD_ID) > 0
		&& System.currentTimeMillis() - lastTime > 5000;
    }

    @Override
    public void execute() {
	Item food = getNext();
	if (food != null) {
	    Methods.interactInventory(food.getId(), food.getSlot());
	    lastTime = System.currentTimeMillis();// to make sure there is a
						  // 5000ms delay between each
						  // execute
	}

    }

    public Item getNext() {
	for (int id : FOOD_ID)
	    for (Item i : Inventory.getItems())
		if (i.getId() == id)
		    return i;
	return null;

    }

}

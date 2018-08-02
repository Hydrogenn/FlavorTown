package me.hydrogenn.flavortown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;

public class FlavorTownListener implements Listener {

	//this won't readily convert into cauldrons but /shrug
	@EventHandler
	public static void craftingBenchInteraction(InventoryClickEvent e) {
		
		if (!isCookingRecipe(e)) return;
		
		CraftingInventory inventory = (CraftingInventory) e.getInventory();
		
		FoodCombo food = new FoodCombo(inventory.getMatrix());
		
		inventory.setResult(food.cook());
		
	}

	private static boolean isCookingRecipe(InventoryClickEvent e) {
		boolean isCraftingBench = e.getInventory() instanceof CraftingInventory; //is interacting with the crafting bench
		boolean isOnlyFood = true; //all ingredients are food items
		boolean isValidRecipe = false; //is a valid recipe in the base game
		return isCraftingBench && isOnlyFood && !isValidRecipe;
	}
	
}

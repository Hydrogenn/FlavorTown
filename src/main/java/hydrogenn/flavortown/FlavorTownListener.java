package main.java.hydrogenn.flavortown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class FlavorTownListener implements Listener {

	//this won't readily convert into cauldrons but /shrug
	@EventHandler
	public static void craftingBenchInteraction(InventoryClickEvent e) {
		
		if (!isCookingRecipe(e)) return;
		
		CraftingInventory inventory = (CraftingInventory) e.getClickedInventory();
		
		FoodRecipe food = new FoodRecipe(inventory.getMatrix());
		
		inventory.setResult(food.cook());
		
	}

	private static boolean isCookingRecipe(InventoryClickEvent e) {
		boolean isCraftingBench = e.getClickedInventory() instanceof CraftingInventory; //is interacting with the crafting bench
		boolean isOnlyFood = true; //all ingredients are food items
		boolean isValidRecipe = false; //is a valid recipe in the base game
		return isCraftingBench && isOnlyFood && !isValidRecipe;
	}
	
}

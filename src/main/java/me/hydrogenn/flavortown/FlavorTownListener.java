package me.hydrogenn.flavortown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class FlavorTownListener implements Listener {

	//this won't readily convert into cauldrons but /shrug
	@EventHandler
	public static void craftingBenchInteraction(PrepareItemCraftEvent e) {
		
		if (!isCookingRecipe(e)) return;
		
		CraftingInventory inventory = e.getInventory();
		
		FoodCombo food = new FoodCombo(inventory.getMatrix());
		
		inventory.setResult(food.cook());
		
	}

	private static boolean isCookingRecipe(PrepareItemCraftEvent e) {
		boolean isOnlyFood = isAllFoods(e.getInventory().getMatrix());
		boolean isValidRecipe = false; //is a valid recipe in the base game
		return isOnlyFood && !isValidRecipe;
	}

	private static boolean isAllFoods(ItemStack... items) {
		for (ItemStack item : items) {
			if (item == null) continue;
			if (FoodMaterial.get(item.getType()) == null) return false;
		}
		return true;
	}
	
}

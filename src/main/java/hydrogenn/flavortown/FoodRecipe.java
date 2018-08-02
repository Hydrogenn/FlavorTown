package main.java.hydrogenn.flavortown;

import org.bukkit.inventory.ItemStack;

public class FoodRecipe {

	public FoodRecipe(ItemStack... contents) {
		for (ItemStack item : contents) {
			item.getType();
		}
	}
	
	//TODO return an item this recipe can create
	public ItemStack cook() {
		return null;
	}
	
}

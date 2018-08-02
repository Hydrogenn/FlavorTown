package main.java.hydrogenn.flavortown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FoodCombo {

	List<FoodMaterial> recipe = new ArrayList<FoodMaterial>();
	
	public FoodCombo(ItemStack... contents) {
		for (ItemStack item : contents) {
			recipe.add(FoodMaterial.get(item.getType()));
		}
	}
	
	//TODO return an item this recipe can create
	public ItemStack cook() {
		
		ItemStack food = new ItemStack(Material.BREAD);
		
		int hunger = 0;
		
		for (FoodMaterial foodMaterial : recipe) {
			hunger += foodMaterial.getHunger();
		}
		
		ItemMeta foodMeta = food.getItemMeta();
		
		foodMeta.setDisplayName(name());
		
		List<String> lore = new ArrayList<String>();
		lore.add(Integer.toString(hunger) + " hunger restored, but not really.");
		
		foodMeta.setLore(lore);
		
		food.setItemMeta(foodMeta);
		
		return food;
		
	}
	
	private String name() {
		return "Food.";
	}
	
}

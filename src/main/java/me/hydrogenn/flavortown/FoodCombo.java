package me.hydrogenn.flavortown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.StringUtil;

public class FoodCombo {

	List<FoodMaterial> recipe = new ArrayList<FoodMaterial>();
	
	public FoodCombo(ItemStack... contents) {
		for (ItemStack item : contents) {
			if (item == null) continue;
			recipe.add(FoodMaterial.get(item.getType()));
		}
	}
	
	public ItemStack cook() {
		
		ItemStack food = new ItemStack(Material.BREAD, 1);
		
		int hunger = 0;
		double saturation = 0;
		Map<FoodGroup, Double> nutrition = new HashMap<FoodGroup, Double>();
		
		for (FoodMaterial foodMaterial : recipe) {
			hunger += foodMaterial.getHunger();
			saturation += foodMaterial.getSaturationValue();
			nutrition.put(foodMaterial.getFoodGroup(), nutrition.getOrDefault(foodMaterial.getFoodGroup(), 0.0) + foodMaterial.getNutritionContribution());
		}
		
		ItemMeta foodMeta = food.getItemMeta();
		
		foodMeta.setDisplayName(name());
		
		List<String> lore = new ArrayList<String>();
		lore.add(Integer.toString(hunger) + " hunger restored, but not really.");
		lore.add(Double.toString(saturation) + " saturation restored, but again... not really.");
		
		String nutritionBar = "";
		
		for (FoodGroup foodGroup : nutrition.keySet()) {
			nutritionBar += foodGroup.getColor() + StringUtils.repeat("■", nutrition.get(foodGroup).intValue());
		}
		
		lore.add(nutritionBar);
		
		foodMeta.setLore(lore);
		
		food.setItemMeta(foodMeta);
		
		return food;
		
	}
	
	private String name() {
		return ChatColor.GRAY + "Food.";
	}
	
}

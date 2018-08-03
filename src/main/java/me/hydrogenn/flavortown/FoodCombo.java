package me.hydrogenn.flavortown;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.stream.Collectors;

public class FoodCombo {
    private List<FoodMaterial> recipe;

    public FoodCombo(ItemStack... contents) {
        recipe = Arrays.stream(contents)
                .filter(item -> item != null && item.getType() != Material.AIR)
                .map(ItemStack::getType)
                .map(FoodMaterial::get)
                .collect(Collectors.toList());
    }

    public ItemStack getResult() {
        ItemStack food = new ItemStack(Material.BREAD, 1);

        int hunger = recipe.stream().mapToInt(FoodMaterial::getHunger).sum();
        double saturation = recipe.stream().mapToDouble(FoodMaterial::getSaturationValue).sum();
        Map<FoodGroup, Double> nutrition = new HashMap<>();

        recipe.forEach(material -> nutrition.put(material.getFoodGroup(), nutrition.getOrDefault(material.getFoodGroup(), 0.0) + material.getNutritionContribution()));

        ItemMeta foodMeta = food.getItemMeta();

        foodMeta.setDisplayName(getName());

        List<String> lore = new ArrayList<>();
        lore.add(hunger + " hunger restored, but not really.");
        lore.add(saturation + " saturation restored, but again... not really.");

        StringBuilder nutritionBar = new StringBuilder();

        nutrition.keySet().forEach(foodGroup -> nutritionBar.append(foodGroup.getColor()).append(StringUtils.repeat("\u25A0", nutrition.get(foodGroup).intValue())));

        lore.add(nutritionBar.toString());

        foodMeta.setLore(lore);
        food.setItemMeta(foodMeta);

        return food;
    }

    private String getName() {
        return ChatColor.GRAY + "Food.";
    }

}

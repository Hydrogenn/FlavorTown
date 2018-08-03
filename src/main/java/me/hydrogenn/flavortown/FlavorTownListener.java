package me.hydrogenn.flavortown;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;

import java.util.Arrays;

public class FlavorTownListener implements Listener {

    // this won't readily convert into cauldrons but /shrug
    @EventHandler
    public static void craftingBenchInteraction(PrepareItemCraftEvent e) {
        if (!isCookingRecipe(e)) return;

        CraftingInventory inventory = e.getInventory();

        FoodCombo food = new FoodCombo(inventory.getMatrix());

        inventory.setResult(food.getResult());
    }

    private static boolean isCookingRecipe(PrepareItemCraftEvent e) {
        boolean isOnlyFood = Arrays.stream(e.getInventory().getMatrix())
                .allMatch(item -> item == null || FoodMaterial.get(item.getType()) != null);
        // is a valid recipe in the base game
        // TODO: Have this actually check for valid recipes
        boolean isValidRecipe = false;

        return isOnlyFood && !isValidRecipe;
    }

}

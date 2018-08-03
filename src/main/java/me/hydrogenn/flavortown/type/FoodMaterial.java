package me.hydrogenn.flavortown.type;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Spigot does not have an interface for finding the food and saturation values for food items.
 * This fixes that by, uh, hardcoding those values somewhere.
 * If it ain't broke, right?
 *
 * @author Hydrogenn
 */
public enum FoodMaterial {

    RAW_BEEF(Material.BEEF, 3, Saturation.LOW, FoodGroup.PROTEIN),
    RAW_PORK(Material.PORKCHOP, 3, Saturation.LOW, FoodGroup.PROTEIN),
    RAW_MUTTON(Material.MUTTON, 2, Saturation.LOW, FoodGroup.PROTEIN),
    RAW_RABBIT(Material.RABBIT, 3, Saturation.LOW, FoodGroup.PROTEIN),
    RAW_CHICKEN(Material.CHICKEN, 2, Saturation.LOW, FoodGroup.PROTEIN),

    RAW_COD(Material.COD, 2, Saturation.LOW, FoodGroup.PROTEIN),
    RAW_SALMON(Material.SALMON, 2, Saturation.LOW, FoodGroup.PROTEIN),
    TROPICAL_FISH(Material.TROPICAL_FISH, 1, Saturation.POOR, FoodGroup.PROTEIN),

    APPLE(Material.APPLE, 4, Saturation.LOW, FoodGroup.FRUIT),
    MELON(Material.MELON_SLICE, 2, Saturation.LOW, FoodGroup.FRUIT),
    CHORUS_FRUIT(Material.CHORUS_FRUIT, 4, Saturation.LOW, FoodGroup.FRUIT),

    PUFFERFISH(Material.PUFFERFISH, 2, Saturation.POOR, FoodGroup.TOXIC),
    SPIDER_EYE(Material.SPIDER_EYE, 2, Saturation.GOOD, FoodGroup.TOXIC),
    ROTTEN_FLESH(Material.ROTTEN_FLESH, 4, Saturation.POOR, FoodGroup.TOXIC),
    POISONOUS_POTATO(Material.POISONOUS_POTATO, 2, Saturation.LOW, FoodGroup.TOXIC),

    GOLDEN_CARROT(Material.GOLDEN_CARROT, 3, Saturation.SUPERNATURAL, FoodGroup.VEGETABLE),
    GOLDEN_APPLE(Material.GOLDEN_APPLE, 4, Saturation.SUPERNATURAL, FoodGroup.FRUIT),
    NOTCH_APPLE(Material.ENCHANTED_GOLDEN_APPLE, 4, Saturation.SUPERNATURAL, FoodGroup.FRUIT),

    POTATO(Material.POTATO, 1, Saturation.LOW, FoodGroup.VEGETABLE),
    CARROT(Material.CARROT, 3, Saturation.NORMAL, FoodGroup.VEGETABLE),
    BEETROOT(Material.BEETROOT, 1, Saturation.NORMAL, FoodGroup.VEGETABLE),

    WHEAT(Material.WHEAT, 1, Saturation.POOR, FoodGroup.GRAIN),
    EGG(Material.EGG, 0, Saturation.POOR, FoodGroup.PROTEIN),
    COCOA_BEANS(Material.COCOA_BEANS, 1, Saturation.POOR, FoodGroup.PROTEIN),
    BROWN_MUSHROOM(Material.BROWN_MUSHROOM, 0, Saturation.POOR, FoodGroup.VEGETABLE),
    RED_MUSHROOM(Material.RED_MUSHROOM, -1, Saturation.POOR, FoodGroup.VEGETABLE),
    PUMPKIN(Material.PUMPKIN, 0, Saturation.POOR, FoodGroup.VEGETABLE),
    SUGAR(Material.SUGAR, 0, Saturation.POOR, FoodGroup.SUGAR),

    WATER(Material.WATER_BUCKET, 0, Saturation.NORMAL, FoodGroup.NONE, false, Material.BUCKET),
    MILK(Material.MILK_BUCKET, 1, Saturation.POOR, FoodGroup.DAIRY, false, Material.BUCKET),

    COOKED_BEEF(Material.COOKED_BEEF, 8, Saturation.GOOD, FoodGroup.PROTEIN, true),
    COOKED_PORK(Material.COOKED_PORKCHOP, 8, Saturation.GOOD, FoodGroup.PROTEIN, true),
    COOKED_MUTTON(Material.COOKED_MUTTON, 6, Saturation.GOOD, FoodGroup.PROTEIN, true),
    COOKED_CHICKEN(Material.COOKED_CHICKEN, 6, Saturation.GOOD, FoodGroup.PROTEIN, true),
    COOKED_RABBIT(Material.COOKED_RABBIT, 5, Saturation.GOOD, FoodGroup.PROTEIN, true),

    COOKED_SALMON(Material.COOKED_SALMON, 6, Saturation.GOOD, FoodGroup.PROTEIN, true),
    COOKED_COD(Material.COOKED_COD, 5, Saturation.NORMAL, FoodGroup.PROTEIN, true), //TODO verify that this has not changed

    MUSHROOM_STEW(Material.MUSHROOM_STEW, 6, Saturation.NORMAL, FoodGroup.VEGETABLE, true, Material.BOWL),
    RABBIT_STEW(Material.RABBIT_STEW, 10, Saturation.NORMAL, FoodGroup.VEGETABLE, true, Material.BOWL),
    BEETROOT_SOUP(Material.BEETROOT_SOUP, 6, Saturation.NORMAL, FoodGroup.VEGETABLE, true, Material.BOWL),

    BREAD(Material.BREAD, 5, Saturation.NORMAL, FoodGroup.GRAIN, true),
    DRIED_KELP(Material.DRIED_KELP, 1, Saturation.LOW, FoodGroup.VEGETABLE, true),

    COOKIE(Material.COOKIE, 2, Saturation.POOR, FoodGroup.SUGAR, true),
    PUMPKIN_PIE(Material.PUMPKIN_PIE, 8, Saturation.LOW, FoodGroup.SUGAR, true),
    CAKE(Material.CAKE, 14, Saturation.POOR, FoodGroup.SUGAR, true);

    private static final Map<Material, FoodMaterial> materialMap;

    //tbh I have no idea why this works, which may or may not be a problem in the future.
    static {
        materialMap = Arrays.stream(values()).collect(Collectors.toMap(FoodMaterial::getBaseMaterial, key -> key));
    }

    private final Material material;
    private final int hunger;
    private final Saturation saturation;
    private final FoodGroup foodGroup;
    private final boolean refried;
    private final Material baseMaterial;

    FoodMaterial(Material material, int hunger, Saturation saturation, FoodGroup foodGroup, boolean refried, Material baseMaterial) {
        this.material = material;
        this.hunger = hunger;
        this.saturation = saturation;
        this.foodGroup = foodGroup;
        this.refried = refried;
        this.baseMaterial = baseMaterial;
    }

    FoodMaterial(Material material, int hunger, Saturation saturation, FoodGroup foodGroup, boolean refried) {
        this(material, hunger, saturation, foodGroup, refried, null);
    }

    FoodMaterial(Material material, int hunger, Saturation saturation, FoodGroup foodGroup) {
        this(material, hunger, saturation, foodGroup, false);
    }

    public static FoodMaterial get(Material type) {
        return materialMap.get(type);
    }

    public Material getMaterial() {
        return material;
    }

    public int getHunger() {
        return hunger;
    }

    public Saturation getSaturation() {
        return saturation;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public boolean isRefried() {
        return refried;
    }

    public Material getBaseMaterial() {
        return baseMaterial;
    }

    public double getSaturationValue() {
        return getSaturation().getSaturationRatio() * (double) getHunger() * (refried ? 0.5 : 1.0);
    }

    public double getNutritionContribution() {
        return (getSaturationValue() + getHunger() + 1) / 2.0 / (refried ? 2.0 : 1.0);
    }

}

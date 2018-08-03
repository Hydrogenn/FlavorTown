package me.hydrogenn.flavortown;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import me.hydrogenn.flavortown.event.CraftingListener;
import me.hydrogenn.flavortown.type.NutritionSet;

public class FlavorTown extends JavaPlugin {
	
	private Map<UUID, NutritionSet> playerHungers = new HashMap<UUID, NutritionSet>();
	
    private static FlavorTown instance;

    public static FlavorTown getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        
        addListener();
        
        reload();
    }

    private void addListener() {
    	getServer().getPluginManager().registerEvents(new CraftingListener(), this);
	}

	public void reload() {
        saveDefaultConfig();
        reloadConfig();
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}

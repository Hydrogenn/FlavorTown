package main.java.hydrogenn.flavortown;

import org.bukkit.plugin.java.JavaPlugin;

import hydrogenn.customBrewery.BreweryListener;

public class FlavorTown extends JavaPlugin {
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
    	getServer().getPluginManager().registerEvents(new FlavorTownListener(), this);
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

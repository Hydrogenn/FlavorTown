package hydrogenn.flavortown;

import org.bukkit.plugin.java.JavaPlugin;

public class FlavorTown extends JavaPlugin {
    private static FlavorTown instance;

    public static FlavorTown getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        reload();
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

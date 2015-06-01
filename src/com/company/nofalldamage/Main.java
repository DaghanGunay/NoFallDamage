package com.company.nofalldamage;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    WorldGuardPlugin worldGuardPlugin;

    public void onEnable() {
        getLogger().info("NoFallDamage for contains \"noFall\" string in region name");
        worldGuardPlugin = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        new PlayerListener(this);
    }

}

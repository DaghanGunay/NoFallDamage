package com.legendpvp.nofalldamage;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    WorldGuardPlugin worldGuardPlugin;

    public void onEnable() {git
        getLogger().info("NoFallDamage for contains \"nofall\" string in region name");
        worldGuardPlugin = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        new PlayerListener(this);
    }

}

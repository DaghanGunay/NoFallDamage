package com.legendpvp.nofalldamage;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.sk89q.worldguard.bukkit.RegionContainer;

/**
 * Created by Daghan on 6/1/2015.
 */
public class PlayerListener implements Listener{
    public PlayerListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        Entity entity  = e.getEntity();
        WorldGuardPlugin WG = WGBukkit.getPlugin();
        if(entity instanceof Player){
            if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){

                Player player = (Player) entity;

                Location location = player.getLocation();

                RegionContainer WGContainer = WG.getRegionContainer();

                RegionManager rm = WGContainer.get(location.getWorld());

                ApplicableRegionSet ar = rm.getApplicableRegions(location);

                for(ProtectedRegion region : ar) {
                    if(region.getId().contains("nofall")){
                        e.setCancelled(true);
                    }
                }

            }
        }

    }

}

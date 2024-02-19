package de.lightplugins.skyblock.events.defaults;

import de.lightplugins.skyblock.master.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DamageIndicator {

    public void createDamageIndicator(LivingEntity enemy, double damage, boolean isCritical) {
        Location enemyLocation = enemy.getLocation();
        Vector direction = enemy.getEyeLocation().getDirection();
        Vector randomOffset =
                new Vector(Math.random() - 0.5, enemyLocation.getY() + 1, Math.random() - 0.5).normalize().multiply(1.25); // Random offset for the enemy location
        Location damageIndicatorLocation = enemyLocation.clone().add(direction).add(randomOffset);

        String randomUUID = UUID.randomUUID().toString();
        List<String> lines = new ArrayList<>();

        if(isCritical) {
            lines.add("§e" + damage + " §6❤");
        } else {
            lines.add("§c" + damage + " §4❤");
        }

        Hologram hologram = DHAPI.createHologram(randomUUID, damageIndicatorLocation, lines);
        Bukkit.getScheduler().runTaskLater(Main.getInstance, hologram::delete, 30);
    }
}

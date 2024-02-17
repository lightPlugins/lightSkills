package de.lightplugins.skills.events.defaults;

import de.lightplugins.skills.master.Main;
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

public class DamageIndicator implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player && event.getEntity() instanceof LivingEntity enemy) {
            double damage = event.getFinalDamage();


            Location enemyLocation = enemy.getLocation();
            Vector direction = enemy.getEyeLocation().getDirection();
            Vector randomOffset =
                    new Vector(Math.random() - 0.5, enemyLocation.getY() + 1, Math.random() - 0.5).normalize().multiply(1.25); // Random offset for the enemy location
            Location damageIndicatorLocation = enemyLocation.clone().add(direction).add(randomOffset);

            String randomUUID = UUID.randomUUID().toString();

            List<String> lines = new ArrayList<>();

            if(player.getFallDistance() > 0) {
                lines.add("§e" + damage + " §6❤");
            } else {
                lines.add("§c" + damage + " §4❤");
            }

            Hologram hologram = DHAPI.createHologram(randomUUID, damageIndicatorLocation, lines);

            Bukkit.getScheduler().runTaskLater(Main.getInstance, hologram::delete, 40); // Delete the hologram after 2 seconds
        }
    }
}

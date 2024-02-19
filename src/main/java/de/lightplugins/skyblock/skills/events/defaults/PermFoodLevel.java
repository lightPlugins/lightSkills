package de.lightplugins.skyblock.skills.events.defaults;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PermFoodLevel implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if(event.getEntity() instanceof Player player) {

            player.setFoodLevel(20);
            event.setCancelled(true);
        }
    }
}

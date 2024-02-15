package de.lightplugins.skills.events.defaults;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class DisableDurability implements Listener {

    @EventHandler
    public void disableDurability(PlayerItemDamageEvent event) {
        event.setCancelled(true);
    }
}

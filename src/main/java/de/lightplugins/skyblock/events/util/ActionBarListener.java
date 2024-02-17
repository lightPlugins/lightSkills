package de.lightplugins.skyblock.events.util;

import de.lightplugins.skyblock.skills.manager.SkillData;
import de.lightplugins.skyblock.master.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ActionBarListener implements Listener {


    /**
     * Initializes the action bar for the player upon joining the game.
     *
     * @param event the PlayerJoinEvent
     */
    @EventHandler
    public void initActionBar(PlayerJoinEvent event) {
        // Get the player who joined
        Player player = event.getPlayer();

        // Add the player's UUID to the list of initialized action bars if not already present
        if(!Main.getInstance.actionBarInit.contains(player.getUniqueId())) {
            Main.getInstance.actionBarInit.add(player.getUniqueId());
        }
    }

    /**
     * Removes the player's action bar on quit event
     * @param event The player quit event
     */
    @EventHandler
    public void removeActionBar(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Main.getInstance.actionBarInit.remove(player.getUniqueId());
    }
}

package de.lightplugins.skills.events;

import de.lightplugins.skills.master.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ActionBarListener implements Listener {


    @EventHandler
    public void initActionBar(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        if(!Main.getInstance.actionBarInit.contains(player.getUniqueId())) {
            Main.getInstance.actionBarInit.add(player.getUniqueId());
        }

        player.setHealthScale(20);
        player.setHealthScaled(true);
    }
    @EventHandler
    public void removeActionBar(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Main.getInstance.actionBarInit.remove(player.getUniqueId());
    }
}

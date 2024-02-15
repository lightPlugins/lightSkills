package de.lightplugins.skills.actionbar;

import de.lightplugins.skills.master.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.Objects;

public class ActionBarSender {

    public void startActionBarTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {

                Main.getInstance.actionBarInit.forEach(singlePlayer -> {

                    Player player = Bukkit.getPlayer(singlePlayer);

                    int armorValue = 0;

                    if(player == null) {
                        return;
                    }

                    int maxHealth = (int) Objects.requireNonNull(player.getAttribute(
                            Attribute.GENERIC_MAX_HEALTH)).getBaseValue();
                    int currentHealth = (int) player.getHealth();

                    armorValue += Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_ARMOR)).getBaseValue();

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            new TextComponent("§c" + currentHealth + "§4/§c" + maxHealth + " §4❤" + "    §a" + armorValue + " §2★"));

                });

            }
        }.runTaskTimerAsynchronously(Main.getInstance, 0, 10);
    }
}

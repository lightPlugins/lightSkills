package de.lightplugins.skyblock.skills.actionbar;

import de.lightplugins.skyblock.master.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.UUID;

public class ActionBarSender {

    public void startActionBarTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {

                Main.getInstance.actionBarInit.forEach(singlePlayer -> {

                    Player player = Bukkit.getPlayer(singlePlayer);
                    if(player == null){
                        return;
                    }
                    UUID uuid = player.getUniqueId();

                    int armorValue = 0;
                    int regen = Main.skillData.getSkillData(uuid).getHealthRegen();

                    int maxHealth = (int) Objects.requireNonNull(player.getAttribute(
                            Attribute.GENERIC_MAX_HEALTH)).getBaseValue();
                    int currentHealth = (int) player.getHealth();

                    armorValue = Main.skillData.getSkillData(player.getUniqueId()).getDefense();

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            new TextComponent("§c" + currentHealth + "§4/§c" + maxHealth + " §4❤" +
                                    "    §a" + armorValue + " §2★"+
                                    "    §e" + regen + " §6★"));

                });

            }
        }.runTaskTimerAsynchronously(Main.getInstance, 0, 10);
    }
}

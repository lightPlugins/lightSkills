package de.lightplugins.skyblock.skills.events;


import de.lightplugins.skyblock.master.Main;
import de.lightplugins.skyblock.skills.contract.SkillConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class WriteDefaultSkillData implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        int health = 100;
        int defense = 100;
        int speed = 100;
        int strength = 5;
        int intelligence = 0;
        int criticalChance = 0;
        int criticalDamage = 0;
        int luck = 0;
        int miningFortune = 0;
        int farmingFortune = 0;
        int foragingFortune = 0;
        int healthRegen = 1;

        SkillConstructor skillConstructor = new SkillConstructor(
                health,
                defense,
                speed,
                strength,
                intelligence,
                criticalChance,
                criticalDamage,
                luck,
                miningFortune,
                farmingFortune,
                foragingFortune,
                healthRegen);

        if(!Main.getInstance.playerManager.hasSkillData(uuid)) {
            Main.getInstance.playerManager.updateSkillData(uuid, skillConstructor);
            player.sendMessage("Du bist neu und deine Startwerte wurden in den Cache geschrieben");
            return;
        }
        player.sendMessage("Du existierst bereits. Deine aktuellen Skillpunkte werden in den Cache geschrieben");
    }
}

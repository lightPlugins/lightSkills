package de.lightplugins.skyblock.skills.events.defaults;


import de.lightplugins.skyblock.master.Main;
import de.lightplugins.skyblock.skills.contract.SkillConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WriteDefaultSkillData implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        player.setHealthScale(20);
        player.setHealthScaled(true);
        player.setFoodLevel(20);

        SkillConstructor skillConstructor = getSkillConstructor();

        /*
        SkillConstructor updateDefense = Main.playerManager.getSkillData(uuid);
        int currentDefense = updateDefense.getDefense();
        updateDefense.setDefense(currentDefense + 50);
        Main.playerManager.updateSkillData(uuid, updateDefense);
         */
        if(!Main.skillData.hasSkillData(uuid)) {
            Main.skillData.updateSkillData(uuid, skillConstructor);
            player.sendMessage("Du bist neu und deine Startwerte wurden in den Cache geschrieben");
            return;
        }
        player.sendMessage("Du existierst bereits. Deine aktuellen Skillpunkte werden in den Cache geschrieben");
    }

    @NotNull
    private static SkillConstructor getSkillConstructor() {
        int health = 60;
        int defense = 1000;
        int speed = 500;
        int strength = 5;
        int intelligence = 0;
        int criticalChance = 25; // 25% chance
        int criticalDamage = 5; // 5% extra damage
        int luck = 0;
        int miningFortune = 0;
        int farmingFortune = 0;
        int foragingFortune = 0;
        int healthRegen = 10;

        return new SkillConstructor(
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
    }
}

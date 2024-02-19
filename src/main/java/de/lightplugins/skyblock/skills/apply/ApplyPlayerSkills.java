package de.lightplugins.skyblock.skills.apply;

import de.lightplugins.skyblock.master.Main;
import de.lightplugins.skyblock.skills.contract.SkillConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;


public class ApplyPlayerSkills implements Listener {

    @EventHandler
    public void applyHealthRegen(EntityRegainHealthEvent event) {

        if (event.getEntity() instanceof Player player) {

            UUID uuid = player.getUniqueId();
            SkillConstructor skillConstructor = Main.skillData.getSkillData(uuid);
            double regenAmount = skillConstructor.getHealthRegen();
            player.setSaturation(2000);
            event.setAmount(regenAmount);
        }
    }

    @EventHandler
    public void applyDefense(EntityDamageEvent event) {

        if(event.getEntity() instanceof Player player) {

            UUID uuid = player.getUniqueId();
            SkillConstructor skillConstructor = Main.skillData.getSkillData(uuid);
            double incomingDamage = event.getFinalDamage();

            if(incomingDamage <= 0) {
                return;
            }

            //  Divide by 100 -> defense = 100 / 10000 = 0.01% less damage
            //                   defense = 5000 / 10000 = 50% less damage
            //                   defense = 10000 / 10000 = 100 % less damage
            int defense = skillConstructor.getDefense() / 10000;
            event.setDamage(incomingDamage * (1 - (defense / 10000.0)));

        }
    }

    @EventHandler
    void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.isSwimming())
            player.setVelocity(player.getLocation().getDirection().multiply(0.4)); // you might want to increase this number
    }
}

package de.lightplugins.skyblock.skills.events.updates;

import de.lightplugins.skyblock.skills.events.custom.SkillDataChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CheckForDataChange implements Listener {

    @EventHandler
    public void onSkillDataChange(SkillDataChangeEvent event) {

        if(checkForDataChange(event.getOldHealth(), event.getNewHealth())) {

        }

        if(checkForDataChange(event.getOldDefense(), event.getNewDefense())) {

        }

        if(checkForDataChange(event.getOldSpeed(), event.getNewSpeed())) {

        }

        if(checkForDataChange(event.getOldStrength(), event.getNewStrength())) {

        }

        if(checkForDataChange(event.getOldIntelligence(), event.getNewIntelligence())) {

        }

        if(checkForDataChange(event.getOldCriticalChance(), event.getNewCriticalChance())) {

        }

        if(checkForDataChange(event.getOldCriticalDamage(), event.getNewCriticalDamage())) {

        }

        if(checkForDataChange(event.getOldLuck(), event.getNewLuck())) {

        }

        if(checkForDataChange(event.getOldMiningFortune(), event.getNewMiningFortune())) {

        }

        if(checkForDataChange(event.getOldFarmingFortune(), event.getNewFarmingFortune())) {

        }

        if(checkForDataChange(event.getOldForagingFortune(), event.getNewForagingFortune())) {

        }

        if(checkForDataChange(event.getOldHealthRegen(), event.getNewHealthRegen())) {

        }
    }

    public boolean checkForDataChange(int a, int b) {
        return a != b;
    }

}

package de.lightplugins.skyblock.skills.manager;

import de.lightplugins.skyblock.master.Main;
import de.lightplugins.skyblock.skills.contract.SkillConstructor;
import de.lightplugins.skyblock.skills.events.custom.SkillDataChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SkillData {

    public ConcurrentHashMap<UUID, SkillConstructor> playerSkillData = new ConcurrentHashMap<>();


    /**
     * Update the skill data for a player.
     *
     * @param uuid The UUID of the player
     * @param skillConstructor The skill data to update
     */
    public void updateSkillData(UUID uuid, SkillConstructor skillConstructor) {
        //  Call SkillDataChangeEvent before making any changes
        Bukkit.getPluginManager().callEvent(new SkillDataChangeEvent(getSkillData(uuid), skillConstructor, uuid));
        playerSkillData.put(uuid, skillConstructor);
        applyHealth(uuid, skillConstructor);
        applySpeed(uuid, skillConstructor);
    }

    /**
     * Retrieve skill data for the given player UUID
     * @param uuid the UUID of the player
     * @return the SkillConstructor object containing the player's skill data
     */
    public SkillConstructor getSkillData(UUID uuid) {
        return playerSkillData.get(uuid);
    }

    /**
     * Check if the skill data for the specified UUID exists.
     *
     * @param  uuid  the UUID to check for skill data
     * @return       true if the skill data exists, false otherwise
     */
    public boolean hasSkillData(UUID uuid) {
        return playerSkillData.containsKey(uuid);
    }

    /**
     * Deletes the skill data for the given UUID.
     *
     * @param  uuid  the UUID of the skill data to be deleted
     */
    public void deleteSkillData(UUID uuid) {
        playerSkillData.remove(uuid);
    }

    private void applyHealth(UUID uuid, SkillConstructor skillConstructor) {

        int health = skillConstructor.getHealth();

        Player player = Bukkit.getPlayer(uuid);
        if(player == null) {
            Main.util.sendDebugMessage("Player with UUID " + uuid + " not found in applyHealth()");
            return;
        }
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(health);

        player.setHealth(skillConstructor.getHealth());
        player.setHealthScale(20);
        player.setHealthScaled(true);
        Main.util.sendDebugMessage("Health of " + player.getName() + " set to " + health);

    }

    private void applySpeed(UUID uuid, SkillConstructor skillConstructor) {

        //  Divide by 1000 -> speed = 100 / 1000 = 0.1 speed value
        //                   speed = 500 / 1000 = 0.5 speed value
        //                   defense = 1000 / 1000 = 1.0 speed value <- max speed coming from bukkit
        float speed = skillConstructor.getSpeed();

        Player player = Bukkit.getPlayer(uuid);
        if(player == null) {
            return;
        }
        float scaledValue = 0.2f + (0.8f * (speed - 100) / 900.0f);
        player.setWalkSpeed(scaledValue);


        player.sendMessage("TEST: " + scaledValue);
    }
}

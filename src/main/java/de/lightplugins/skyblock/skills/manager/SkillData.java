package de.lightplugins.skyblock.skills.manager;

import de.lightplugins.skyblock.skills.contract.SkillConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillData {

    public Map<UUID, SkillConstructor> playerSkillData = new HashMap<>();


    /**
     * Update the skill data for a player.
     *
     * @param uuid The UUID of the player
     * @param skillContract The skill data to update
     */
    public void updateSkillData(UUID uuid, SkillConstructor skillContract) {
        playerSkillData.put(uuid, skillContract);
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
}

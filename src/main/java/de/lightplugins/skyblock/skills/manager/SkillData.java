package de.lightplugins.skyblock.skills.manager;

import de.lightplugins.skyblock.skills.contract.SkillConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillData {

    public Map<UUID, SkillConstructor> playerSkillData = new HashMap<>();


    public void updateSkillData(UUID uuid, SkillConstructor skillContract) {
        playerSkillData.put(uuid, skillContract);
    }

    public SkillConstructor getSkillData(UUID uuid) {
        return playerSkillData.get(uuid);
    }

    public boolean hasSkillData(UUID uuid) {
        return playerSkillData.containsKey(uuid);
    }

    public void deleteSkillData(UUID uuid) {
        playerSkillData.remove(uuid);
    }
}

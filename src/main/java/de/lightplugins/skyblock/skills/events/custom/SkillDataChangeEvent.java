package de.lightplugins.skyblock.skills.events.custom;


import de.lightplugins.skyblock.skills.contract.SkillConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SkillDataChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    SkillConstructor oldSkillConstructor;
    SkillConstructor newSkillConstructor;
    UUID uuid;

    public SkillDataChangeEvent(SkillConstructor oldSkillConstructor, SkillConstructor newSkillConstructor, UUID uuid) {
        this.oldSkillConstructor = oldSkillConstructor;
        this.newSkillConstructor = newSkillConstructor;
        this.uuid = uuid;
    }

    /**
     * Get the old health value.
     *
     * @return         	the old health value
     */
    public int getOldHealth() {
        return oldSkillConstructor.getHealth();
    }

    /**
     * Get the old defense value.
     *
     * @return         	the old defense value
     */
    public int getOldDefense() {
        return oldSkillConstructor.getDefense();
    }

    /**
     * Get the old speed.
     *
     * @return         	the old speed
     */
    public int getOldSpeed() {
        return oldSkillConstructor.getSpeed();
    }

    /**
     * A method to get the old strength.
     *
     * @return         	The old strength value
     */
    public int getOldStrength() {
        return oldSkillConstructor.getStrength();
    }

    /**
     * A description of the entire Java function.
     *
     * @return         	description of return value
     */
    public int getOldIntelligence() {
        return oldSkillConstructor.getIntelligence();
    }

    /**
     * Get the old critical chance.
     *
     * @return         	the old critical chance
     */
    public int getOldCriticalChance() {
        return oldSkillConstructor.getCriticalChance();
    }

    /**
     * Get the old critical damage value.
     *
     * @return         	the old critical damage value
     */
    public int getOldCriticalDamage() {
        return oldSkillConstructor.getCriticalDamage();
    }

    /**
     * Get the old luck value.
     *
     * @return         	the old luck value
     */
    public int getOldLuck() {
        return oldSkillConstructor.getLuck();
    }

    /**
     * Get the old mining fortune value.
     *
     * @return         	the old mining fortune value
     */
    public int getOldMiningFortune() {
        return oldSkillConstructor.getMiningFortune();
    }

    /**
     * Get the old farming fortune.
     *
     * @return the old farming fortune
     */
    public int getOldFarmingFortune() {
        return oldSkillConstructor.getFarmingFortune();
    }

    /**
     * Get the old foraging fortune value.
     *
     * @return  the old foraging fortune value
     */
    public int getOldForagingFortune() {
        return oldSkillConstructor.getForagingFortune();
    }

    /**
     * Get the old health regeneration value.
     *
     * @return         	the old health regeneration value
     */
    public int getOldHealthRegen() {
        return oldSkillConstructor.getHealthRegen();
    }

    /**
     * Retrieve the new health value.
     *
     * @return         the new health value
     */
    public int getNewHealth() {
        return newSkillConstructor.getHealth();
    }

    /**
     * Retrieves the new defense value.
     *
     * @return  the new defense value
     */
    public int getNewDefense() {
        return newSkillConstructor.getDefense();
    }

    /**
     * Get the new speed.
     *
     * @return         	the new speed
     */
    public int getNewSpeed() {
        return newSkillConstructor.getSpeed();
    }

    /**
     * A description of the entire Java function.
     *
     * @return         	description of return value
     */
    public int getNewStrength() {
        return newSkillConstructor.getStrength();
    }

    /**
     * Retrieves the new intelligence value.
     *
     * @return         	the new intelligence value
     */
    public int getNewIntelligence() {
        return newSkillConstructor.getIntelligence();
    }

    /**
     * Returns the new critical chance.
     *
     * @return  the new critical chance
     */
    public int getNewCriticalChance() {
        return newSkillConstructor.getCriticalChance();
    }

    /**
     * Get the new critical damage.
     *
     * @return the new critical damage
     */
    public int getNewCriticalDamage() {
        return newSkillConstructor.getCriticalDamage();
    }

    /**
     * Retrieves the value of the newLuck variable.
     *
     * @return         	the value of the newLuck variable
     */
    public int getNewLuck() {
        return newSkillConstructor.getLuck();
    }

    /**
     * Get the new mining fortune.
     *
     * @return         	the new mining fortune
     */
    public int getNewMiningFortune() {
        return newSkillConstructor.getMiningFortune();
    }

    /**
     * Get the new farming fortune.
     *
     * @return         	the new farming fortune
     */
    public int getNewFarmingFortune() {
        return newSkillConstructor.getFarmingFortune();
    }

    /**
     * A description of the entire Java function.
     *
     * @return         	description of return value
     */
    public int getNewForagingFortune() {
        return newSkillConstructor.getForagingFortune();
    }

    /**
     * Retrieves the new health regeneration value.
     *
     * @return         	the new health regeneration value
     */
    public int getNewHealthRegen() {
        return newSkillConstructor.getHealthRegen();
    }

    /**
     * Returns a unique identifier.
     * @return a UUID representing the unique identifier
     */
    public UUID getUniqueID() {
        return uuid;
    }


    /**
     * Get the old skill data.
     *
     * @return the old skill data
     */
    public SkillConstructor getOldSkillData() {
        return oldSkillConstructor;
    }

    /**
     * Returns the new skill data.
     *
     * @return the new skill data
     */
    public SkillConstructor getNewSkillData() {
        return newSkillConstructor;
    }

    /**
     * Get the list of event handlers for this event
     * @return the list of event handlers
     */
    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Get the list of registered handlers for this event.
     *
     * @return the list of registered handlers
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

package de.lightplugins.skyblock.skills.events.custom;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SkillHealthUpdate extends Event {

    private static final HandlerList handlers = new HandlerList();

    UUID uuid;
    int oldHealth;
    int newHealth;

    /**
     * Returns a unique identifier.
     * @return a UUID representing the unique identifier
     */
    public UUID getUniqueID() {
        return uuid;
    }

    /**
     * Get the old health value.
     *
     * @return the old health value
     */
    public int getOldHealth() {
        return oldHealth;
    }

    /**
     * Returns the new health value.
     *
     * @return the new health value
     */
    public int getNewHealth() {
        return newHealth;
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

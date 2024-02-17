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


    public UUID getUniqueID() {
        return uuid;
    }

    public int getOldHealth() {
        return oldHealth;
    }

    public int getNewHealth() {
        return newHealth;
    }


    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

package de.lightplugins.skills.manager;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlayerManager {

    private Player player;

    public PlayerManager(Player player) {
        this.player = player;
    }

    /**
     * Loads player data and sets health and attack speed.
     */
    public void loadPlayerData() {
        setHealthAndScale();
        setPermAttackSpeed();
    }

    /**
     * Sets the player's health and health scale.
     */
    private void setHealthAndScale() {
        // Set the player's maximum health to 100
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(100);
        // Set the player's health scale to 20
        player.setHealthScale(20);
        // Enable health scaling for the player
        player.setHealthScaled(true);
    }

    /**
     * Sets the player's attack speed to a specific value.
     */
    private void setPermAttackSpeed() {
        // Ensure the player's attack speed attribute is not null before setting its base value
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(100);
    }

    /**
     * Returns the maximum health of the player.
     * @return the maximum health of the player
     */
    public int getMaxHealth() {
        // Return the base value of the player's maximum health attribute
        return (int) Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue();
    }

    /**
     * Get the attack speed of the player character.
     * @return the attack speed of the player character
     */
    public int getPermAttackSpeed() {
        return (int) Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).getBaseValue();
    }
}

package de.lightplugins.skills.commands.skills;

import de.lightplugins.skills.util.SubCommand;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SkillsOpenCommand extends SubCommand {
    @Override
    public String getName() {
        return "open";
    }

    @Override
    public String getDescription() {
        return "Open the GUI for Skills";
    }

    @Override
    public String getSyntax() {
        return "/skills open";
    }

    @Override
    public boolean perform(Player player, String[] args) {

        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(100);
        player.setHealthScale(20);
        player.setHealthScaled(true);
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(100);
        player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0);

        return false;
    }
}

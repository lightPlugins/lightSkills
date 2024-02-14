package de.lightplugins.skills.commands.skills;

import de.lightplugins.skills.util.SubCommand;
import org.bukkit.entity.Player;

public class SkillsOpenCommand extends SubCommand {
    @Override
    public String getName() {
        return "open";
    }

    @Override
    public String getDescription() {
        return "Open the GUI for Jobs";
    }

    @Override
    public String getSyntax() {
        return "/jobs open";
    }

    @Override
    public boolean perform(Player player, String[] args) {





        return false;
    }
}

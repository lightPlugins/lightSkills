package de.lightplugins.skills.commands.skills;

import de.lightplugins.skills.inventories.SkillsMainMenu;
import de.lightplugins.skills.master.Main;
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
        Main.viewFrame.open(SkillsMainMenu.class, player);

        return false;
    }
}

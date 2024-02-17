package de.lightplugins.skyblock.commands.skills;

import de.lightplugins.skyblock.inventories.SkillsMainMenu;
import de.lightplugins.skyblock.master.Main;
import de.lightplugins.skyblock.util.SubCommand;
import org.bukkit.entity.Player;

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

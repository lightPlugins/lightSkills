package de.lightplugins.skills.commands.manager;

import de.lightplugins.skills.commands.skills.SkillsOpenCommand;
import de.lightplugins.skills.enums.MessagePath;
import de.lightplugins.skills.master.Main;
import de.lightplugins.skills.util.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class SkillsCommandManager implements CommandExecutor {

    private final ArrayList<SubCommand> subCommands = new ArrayList<>();
    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }

    public Main plugin;

    public SkillsCommandManager(Main plugin) {
        this.plugin = plugin;
        subCommands.add(new SkillsOpenCommand());
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] args) {

        if(sender instanceof Player player) {
            if (args.length > 0) {
                for(int i = 0; i < subCommands.size(); i++) {
                    if(args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                        try {
                            if(getSubCommands().get(i).perform(player, args)) {return true;}

                        } catch (ExecutionException | InterruptedException e) {
                            throw new RuntimeException("Something went wrong in executing " + Arrays.toString(args), e);
                        }
                    }
                }
            } else {

                Main.util.sendMessage(player, MessagePath.WrongCommand.getPath()
                        .replace("#command#", "/le help"));
            }
        }
        return false;
    }

}

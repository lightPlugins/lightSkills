package de.lightplugins.skills.master;

import de.lightplugins.skills.actionbar.ActionBarSender;
import de.lightplugins.skills.commands.manager.SkillsCommandManager;
import de.lightplugins.skills.events.defaults.DamageIndicator;
import de.lightplugins.skills.events.defaults.DisableDurability;
import de.lightplugins.skills.events.util.ActionBarListener;
import de.lightplugins.skills.util.ColorTranslation;
import de.lightplugins.skills.util.FileManager;
import de.lightplugins.skills.util.Util;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static Main getInstance;
    public static final String consolePrefix = "§r[light§cJobs§r] ";
    public static FileManager settings;
    public static FileManager messages;
    public static Economy econ = null;
    public static ColorTranslation colorTranslation;
    public static Util util;

    public ArrayList<UUID> actionBarInit = new ArrayList<UUID>();

    public void onLoad() {

        settings = new FileManager(this, "settings.yml");
        messages = new FileManager(this, "messages.yml");

        colorTranslation = new ColorTranslation();
        util = new Util();

    }

    public void onEnable() {
        getInstance = this;

        /*  Check if PlaceholderAPI is installed  */
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            Bukkit.getConsoleSender().sendMessage("\n\n    §4ERROR\n\n" +
                    "    §cCould not find §4Vault \n" +
                    "    §rLightJobs will §cnot run §rwithout Vault. Please download\n" +
                    "    the latest version of Vault \n" +
                    "    §chttps://www.spigotmc.org/resources/vault.34315// \n\n\n");
            onDisable();
            return;
        } else {
            if(!setupEconomy()) {
                Bukkit.getConsoleSender().sendMessage(consolePrefix +
                        "There is a problem while loading Vault. Please contact the plugin author.");
                onDisable();
                return;
            }
        }

        Objects.requireNonNull(this.getCommand("skills")).setExecutor(new SkillsCommandManager(this));

        ActionBarSender actionBarSender = new ActionBarSender();
        actionBarSender.startActionBarTimer();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ActionBarListener(), this);
        pm.registerEvents(new DisableDurability(), this);
        pm.registerEvents(new DamageIndicator(), this);

    }

    public void onDisable() {

    }
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = this.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

}
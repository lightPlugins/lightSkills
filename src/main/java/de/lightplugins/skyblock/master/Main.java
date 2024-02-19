package de.lightplugins.skyblock.master;

import de.lightplugins.skyblock.skills.actionbar.ActionBarSender;
import de.lightplugins.skyblock.commands.manager.SkillsCommandManager;
import de.lightplugins.skyblock.events.defaults.DamageIndicator;
import de.lightplugins.skyblock.events.defaults.DisableDurability;
import de.lightplugins.skyblock.skills.actionbar.ActionBarListener;
import de.lightplugins.skyblock.inventories.SkillsMainMenu;
import de.lightplugins.skyblock.skills.apply.ApplyPlayerSkills;
import de.lightplugins.skyblock.skills.events.defaults.PermFoodLevel;
import de.lightplugins.skyblock.skills.events.defaults.WriteDefaultSkillData;
import de.lightplugins.skyblock.skills.manager.SkillData;
import de.lightplugins.skyblock.util.ColorTranslation;
import de.lightplugins.skyblock.util.FileFinder;
import de.lightplugins.skyblock.util.FileManager;
import de.lightplugins.skyblock.util.Util;
import me.devnatan.inventoryframework.ViewFrame;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main extends JavaPlugin {

    public static Main getInstance;
    public static final String consolePrefix = "§r[light§cSkills§r] ";
    public static FileManager settings;
    public static FileManager messages;
    public static FileFinder collections;
    public static Economy econ = null;
    public static ColorTranslation colorTranslation;
    public static Util util;
    public static ViewFrame viewFrame;

    public static SkillData skillData = new SkillData();

    public CopyOnWriteArrayList<UUID> actionBarInit = new CopyOnWriteArrayList<>();


    public void onLoad() {

        settings = new FileManager(this, "settings.yml");
        messages = new FileManager(this, "messages.yml");
        collections = new FileFinder("plugins/lightSkills/collections/");

        //  Example files
        new FileManager(this, "/collections/farmer/wheat.yml");

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
        pm.registerEvents(new WriteDefaultSkillData(), this);
        pm.registerEvents(new PermFoodLevel(), this);
        pm.registerEvents(new ApplyPlayerSkills(), this);

        /*
         * Custom Events provided by lightSkyblock
         */

        viewFrame = ViewFrame.create(this).with(new SkillsMainMenu()).register();

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
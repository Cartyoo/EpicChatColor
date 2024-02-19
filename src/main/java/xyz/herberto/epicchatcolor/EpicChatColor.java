package xyz.herberto.epicchatcolor;

import co.aikar.commands.BukkitCommandManager;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.herberto.epicchatcolor.commands.ChatColorCommand;
import xyz.herberto.epicchatcolor.listeners.InventoryClickListener;
import xyz.herberto.epicchatcolor.listeners.JoinQuitListener;
import xyz.herberto.epicchatcolor.listeners.PlayerChatListener;
import xyz.herberto.epicchatcolor.placeholderapi.ChatColorExpansion;
import xyz.herberto.epicchatcolor.utils.ConfigFile;

import java.io.IOException;
import java.util.Arrays;

public final class EpicChatColor extends JavaPlugin {
    @Getter private static EpicChatColor instance;
    @Getter private static ConfigFile playerDataYML;

    @Override
    public void onEnable() {

        instance = this;

        this.saveDefaultConfig();
        this.saveConfig();

        if(this.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new ChatColorExpansion(this).register();
        }

        loadFiles();

        BukkitCommandManager manager = new BukkitCommandManager(this);

        Arrays.asList(
                new ChatColorCommand()
        ).forEach(manager::registerCommand);

        this.getServer().getPluginManager().registerEvents(new JoinQuitListener(), this);
        if(this.getConfig().getBoolean("chat-format-enabled")) {
            this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        }
        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);


    }

    public void loadFiles() {
        try {
            playerDataYML = new ConfigFile(this, "playerdata.yml");

            this.getLogger().info("&§======================================================");
            this.getLogger().info("&§All files have been loaded correctly!");
            this.getLogger().info("&§======================================================");
        } catch (IOException | InvalidConfigurationException e) {
            this.getLogger().info("&§=======================================================================================================");
            this.getLogger().info("&§There was an error while loading one or more of the files, please check for any configuration mistakes: ");
            e.printStackTrace();
            this.getLogger().info("&§=======================================================================================================");
        }
    }

}

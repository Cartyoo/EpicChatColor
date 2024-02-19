package xyz.herberto.epicchatcolor.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.herberto.epicchatcolor.EpicChatColor;
import xyz.herberto.epicchatcolor.playerdata.PlayerData;
import xyz.herberto.epicchatcolor.utils.CC;
import xyz.herberto.epicchatcolor.utils.LuckPermUtils;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        PlayerData data = new PlayerData(player);

        if (Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {

            if (player.hasPermission("epicchatcolor.use-colored-chat")) {
                event.setFormat(CC.translate(PlaceholderAPI.setPlaceholders(player, EpicChatColor.getInstance().getConfig().getString("colored-chat-format").replaceAll("%player%", player.getName()).replaceAll("%chatcolor%", String.valueOf(ChatColor.valueOf(data.getChatColorString()))).replaceAll("%modifier%", String.valueOf(ChatColor.valueOf(data.getModifierString())))).replaceAll("%message%", event.getMessage()).replaceAll("%prefix%", LuckPermUtils.getPrefix(player))));
            } else {
                event.setFormat(CC.translate(PlaceholderAPI.setPlaceholders(player, EpicChatColor.getInstance().getConfig().getString("default-chat-format").replaceAll("%player%", player.getName())).replaceAll("%chatcolor%", String.valueOf(ChatColor.valueOf(data.getChatColorString()))).replaceAll("%modifier%", String.valueOf(ChatColor.valueOf(data.getModifierString())))).replaceAll("%message%", event.getMessage()).replaceAll("%prefix%", LuckPermUtils.getPrefix(player)));
            }

        } else {

            if (player.hasPermission("epicchatcolor.use-colored-chat")) {
                event.setFormat(CC.translate(EpicChatColor.getInstance().getConfig().getString("colored-chat-format").replaceAll("%player%", player.getName()).replaceAll("%chatcolor%", String.valueOf(ChatColor.valueOf(data.getChatColorString()))).replaceAll("%modifier%", String.valueOf(ChatColor.valueOf(data.getModifierString())))).replaceAll("%message%", event.getMessage()).replaceAll("%prefix%", LuckPermUtils.getPrefix(player)));
            } else {
                event.setFormat(CC.translate(EpicChatColor.getInstance().getConfig().getString("default-chat-format").replaceAll("%player%", player.getName())).replaceAll("%chatcolor%", String.valueOf(ChatColor.valueOf(data.getChatColorString()))).replaceAll("%modifier%", String.valueOf(ChatColor.valueOf(data.getModifierString()))).replaceAll("%message%", event.getMessage()).replaceAll("%prefix%", LuckPermUtils.getPrefix(player)));
            }

        }

    }
}
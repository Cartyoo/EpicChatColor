package xyz.herberto.epicchatcolor.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import xyz.herberto.epicchatcolor.EpicChatColor;
import xyz.herberto.epicchatcolor.playerdata.PlayerData;

public class ChatColorExpansion extends PlaceholderExpansion {

    private final EpicChatColor instance;

    public ChatColorExpansion(EpicChatColor instance) {
        this.instance = instance;
    }

    @Override
    public String getAuthor() {
        return "herberto";
    }

    @Override
    public String getIdentifier() {
        return "epicchatcolor";
    }

    @Override
    public String getVersion() {
        return "0.5.0-DEV";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        PlayerData data = new PlayerData(player.getPlayer());
        if(params.equalsIgnoreCase("chatcolor")) {
            return String.valueOf(ChatColor.valueOf(data.getChatColorString()));
        } else if(params.equalsIgnoreCase("modifier")) {
            return String.valueOf(ChatColor.valueOf(data.getModifierString()));
        } else if(params.equalsIgnoreCase("chatcolor_text")) {
            return data.getChatColorString();
        } else if(params.equalsIgnoreCase("modifier_text")) {
            return data.getModifierString();
        }

        return null;
    }

}

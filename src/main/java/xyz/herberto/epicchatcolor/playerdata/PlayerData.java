package xyz.herberto.epicchatcolor.playerdata;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.herberto.epicchatcolor.EpicChatColor;
import xyz.herberto.epicchatcolor.utils.CC;

import java.util.UUID;

public class PlayerData {
    @Getter private String chatColorString;
    @Getter private ChatColor chatColor;
    @Getter private ChatColor modifier;
    @Getter private String modifierString;
    @Getter private Player player;

    public PlayerData(Player player) {
        this.player = player;

        this.chatColorString = EpicChatColor.getPlayerDataYML().getString("data." + player.getUniqueId() + ".chatcolor");
        this.chatColor = ChatColor.valueOf(chatColorString);

        this.modifierString = EpicChatColor.getPlayerDataYML().getString("data." + player.getUniqueId() + ".modifier");
        this.modifier = ChatColor.valueOf(modifierString);
    }

    public PlayerData(UUID uuid) {
        this.player = Bukkit.getPlayer(uuid);
    }

    public void createPlayerData() {
        if(EpicChatColor.getPlayerDataYML().getConfigurationSection("data." + player.getUniqueId()) == null) {
            EpicChatColor.getPlayerDataYML().createSection("data." + player.getUniqueId());
            EpicChatColor.getPlayerDataYML().set("data." + player.getUniqueId() + ".chatcolor", ChatColor.GRAY.name());
            EpicChatColor.getPlayerDataYML().set("data." + player.getUniqueId() + ".modifier", ChatColor.RESET.name());
            EpicChatColor.getPlayerDataYML().save();
        }
    }

    public void setChatColor(ChatColor color) {
        EpicChatColor.getPlayerDataYML().set("data." + player.getUniqueId() + ".chatcolor", color.name());
        EpicChatColor.getPlayerDataYML().save();
        player.sendMessage(CC.translate(EpicChatColor.getInstance().getConfig().getString("messages.set-chatcolor").replace("%color%", color.name())));
    }

    public void setModifier(ChatColor modifier) {
        EpicChatColor.getPlayerDataYML().set("data." + player.getUniqueId() + ".modifier", modifier.name());
        EpicChatColor.getPlayerDataYML().save();
        player.sendMessage(CC.translate(EpicChatColor.getInstance().getConfig().getString("messages.set-modifier").replace("%modifier%", modifier.name())));
    }


}

package xyz.herberto.epicchatcolor.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.herberto.epicchatcolor.EpicChatColor;
import xyz.herberto.epicchatcolor.playerdata.PlayerData;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if(EpicChatColor.getPlayerDataYML().getConfigurationSection("data." + event.getPlayer().getUniqueId()) == null) {
            PlayerData data = new PlayerData(event.getPlayer().getUniqueId());
            data.createPlayerData();
        }

    }

}

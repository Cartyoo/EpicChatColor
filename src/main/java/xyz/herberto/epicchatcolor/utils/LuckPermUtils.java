package xyz.herberto.epicchatcolor.utils;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.group.GroupManager;
import org.bukkit.entity.Player;


import java.util.UUID;

public class LuckPermUtils {

    public static boolean isStaff(Player player) {
        return player.hasPermission("hcore.staff");
    }
    public static boolean isAdmin(Player player) {
        return player.hasPermission("hcore.admin");
    }


    public static String getDisplayName(Player player){
        return CC.translate(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix() + player.getName());
    }

    public static String getSuffix(Player player){
        return LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix();
    }

    public static String getPrefix(Player player){
        return LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix();
    }

    public static String getRankColorWithoutName(Player player){
        return LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix();
    }

    public static String getSuffix(UUID uuid){
        return LuckPermsProvider.get().getUserManager().getUser(uuid).getCachedData().getMetaData().getSuffix();
    }

    public static String getRankName(Player player){
        return LuckPermsProvider.get().getGroupManager().getGroup(getRank(player).getName()).getCachedData().getMetaData().getSuffix() + LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getPrimaryGroup();
    }

    public static Group getRank(Player player){
        return LuckPermsProvider.get().getGroupManager().getGroup(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getPrimaryGroup());
    }

    public static String getFancyName(Group group) {
        GroupManager groupManager = LuckPermsProvider.get().getGroupManager();
        String suffix = groupManager.getGroup(group.getName()).getCachedData().getMetaData().getSuffix();
        String displayName = groupManager.getGroup(group.getName()).getDisplayName();

        return CC.translate((suffix == null ? "&7" : suffix) + (displayName == null ? "DisplayName" : displayName));
    }

    public static String getFancyRankColor(Group group){
        GroupManager groupManager = LuckPermsProvider.get().getGroupManager();
        String suffix = groupManager.getGroup(group.getName()).getCachedData().getMetaData().getSuffix();

        return CC.translate(suffix);
    }


}

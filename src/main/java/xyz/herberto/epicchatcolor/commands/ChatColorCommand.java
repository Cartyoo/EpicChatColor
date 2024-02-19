package xyz.herberto.epicchatcolor.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.annotation.Syntax;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.herberto.epicchatcolor.EpicChatColor;
import xyz.herberto.epicchatcolor.playerdata.PlayerData;
import xyz.herberto.epicchatcolor.utils.CC;

public class ChatColorCommand extends BaseCommand {

    @CommandAlias("chatcolor")
    @CommandPermission("epicchatcolor.command.chatcolor")
    @Syntax("[color] [player]")

    public static void chatColor(Player player, @Optional ChatColor color, @Optional OnlinePlayer target) {
        if(target == null) {

            if(color != null) {
                if (player.hasPermission("epicchatcolor.color." + color.name())) {
                    PlayerData data = new PlayerData(player);
                    data.setChatColor(color);
                    //player.sendMessage(CC.translate(EpicChatColor.getInstance().getConfig().getString("messages.set-chatcolor").replaceAll("%player%", "your").replace("%color%", color.name())));
                } else {
                    player.sendMessage(CC.translate(EpicChatColor.getInstance().getConfig().getString("messages.does-not-own-color").replaceAll("%color%", color.name())));
                }
            } else {
                Inventory c = Bukkit.createInventory(null, 9*4, CC.translate(EpicChatColor.getInstance().getConfig().getString("chatcolor-gui-name")));

                ItemStack placeholderItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta placeholderMeta = placeholderItem.getItemMeta();
                placeholderMeta.setDisplayName(" ");
                placeholderItem.setItemMeta(placeholderMeta);


                for (int i = 0; i < c.getSize(); i++) {
                    c.setItem(i, placeholderItem);
                }

                ItemStack aquaChatColor = new ItemStack(Material.LIGHT_BLUE_DYE);
                ItemMeta aquaMeta = aquaChatColor.getItemMeta();
                aquaMeta.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "AQUA");
                aquaChatColor.setItemMeta(aquaMeta);
                c.setItem(10, aquaChatColor);


                ItemStack blackChatColor = new ItemStack(Material.BLACK_DYE);
                ItemMeta blackMeta = blackChatColor.getItemMeta();
                blackMeta.setDisplayName("" + ChatColor.BLACK + ChatColor.BOLD + "BLACK");
                blackChatColor.setItemMeta(blackMeta);
                c.setItem(11, blackChatColor);

                ItemStack blueChatColor = new ItemStack(Material.BLUE_DYE);
                ItemMeta blueMeta = blueChatColor.getItemMeta();
                blueMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "BLUE");
                blueChatColor.setItemMeta(blueMeta);
                c.setItem(12, blueChatColor);

                ItemStack darkAquaChatColor = new ItemStack(Material.CYAN_DYE);
                ItemMeta darkAquaMeta = darkAquaChatColor.getItemMeta();
                darkAquaMeta.setDisplayName("" + ChatColor.DARK_AQUA + ChatColor.BOLD + "DARK AQUA");
                darkAquaChatColor.setItemMeta(darkAquaMeta);
                c.setItem(13, darkAquaChatColor);

                ItemStack darkBlueChatColor = new ItemStack(Material.BLUE_DYE);
                ItemMeta darkBlueMeta = darkBlueChatColor.getItemMeta();
                darkBlueMeta.setDisplayName("" + ChatColor.DARK_BLUE + ChatColor.BOLD + "DARK BLUE");
                darkBlueChatColor.setItemMeta(darkBlueMeta);
                c.setItem(14, darkBlueChatColor);

                ItemStack darkGrayChatColor = new ItemStack(Material.GRAY_DYE);
                ItemMeta darkGrayMeta = darkGrayChatColor.getItemMeta();
                darkGrayMeta.setDisplayName("" + ChatColor.DARK_GRAY + ChatColor.BOLD + "DARK GRAY");
                darkGrayChatColor.setItemMeta(darkGrayMeta);
                c.setItem(15, darkGrayChatColor);

                ItemStack darkGreenChatColor = new ItemStack(Material.GREEN_DYE);
                ItemMeta darkGreenMeta = darkGreenChatColor.getItemMeta();
                darkGreenMeta.setDisplayName("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "DARK GREEN");
                darkGreenChatColor.setItemMeta(darkGreenMeta);
                c.setItem(16, darkGreenChatColor);

                ItemStack darkPurpleChatColor = new ItemStack(Material.PURPLE_DYE);
                ItemMeta darkPurpleMeta = darkPurpleChatColor.getItemMeta();
                darkPurpleMeta.setDisplayName("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "DARK PURPLE");
                darkPurpleChatColor.setItemMeta(darkPurpleMeta);
                c.setItem(4, darkPurpleChatColor);


                ItemStack goldChatColor = new ItemStack(Material.ORANGE_DYE);
                ItemMeta goldMeta = goldChatColor.getItemMeta();
                goldMeta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "GOLD");
                goldChatColor.setItemMeta(goldMeta);
                c.setItem(19, goldChatColor);

                ItemStack grayChatColor = new ItemStack(Material.LIGHT_GRAY_DYE);
                ItemMeta grayMeta = grayChatColor.getItemMeta();
                grayMeta.setDisplayName("" + ChatColor.GRAY + ChatColor.BOLD + "GRAY");
                grayChatColor.setItemMeta(grayMeta);
                c.setItem(20, grayChatColor);

                ItemStack greenChatColor = new ItemStack(Material.LIME_DYE);
                ItemMeta greenMeta = greenChatColor.getItemMeta();
                greenMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "GREEN");
                greenChatColor.setItemMeta(greenMeta);
                c.setItem(21, greenChatColor);

                ItemStack lightPurpleChatColor = new ItemStack(Material.PINK_DYE);
                ItemMeta lightPurpleMeta = lightPurpleChatColor.getItemMeta();
                lightPurpleMeta.setDisplayName("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "LIGHT PURPLE");
                lightPurpleChatColor.setItemMeta(lightPurpleMeta);
                c.setItem(22, lightPurpleChatColor);

                ItemStack redChatColor = new ItemStack(Material.RED_DYE);
                ItemMeta redMeta = redChatColor.getItemMeta();
                redMeta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "RED");
                redChatColor.setItemMeta(redMeta);
                c.setItem(23, redChatColor);

                ItemStack darkRedChatColor = new ItemStack(Material.RED_DYE);
                ItemMeta darkRedMeta = darkRedChatColor.getItemMeta();
                darkRedMeta.setDisplayName("" + ChatColor.DARK_RED + ChatColor.BOLD + "DARK RED");
                darkRedChatColor.setItemMeta(darkRedMeta);
                c.setItem(24, darkRedChatColor);

                ItemStack whiteChatColor = new ItemStack(Material.WHITE_DYE);
                ItemMeta whiteMeta = whiteChatColor.getItemMeta();
                whiteMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.BOLD + "WHITE");
                whiteChatColor.setItemMeta(whiteMeta);
                c.setItem(31, whiteChatColor);

                ItemStack yellowChatColor = new ItemStack(Material.YELLOW_DYE);
                ItemMeta yellowMeta = yellowChatColor.getItemMeta();
                yellowMeta.setDisplayName("" + ChatColor.YELLOW + ChatColor.BOLD + "YELLOW");
                yellowChatColor.setItemMeta(yellowMeta);
                c.setItem(25, yellowChatColor);


                ItemStack modifiers = new ItemStack(Material.BARRIER);
                ItemMeta modifiersMeta = modifiers.getItemMeta();
                modifiersMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.BOLD + "MODIFIERS");
                modifiers.setItemMeta(modifiersMeta);
                c.setItem(35, modifiers);

                player.openInventory(c);

            }

        }
    }

}

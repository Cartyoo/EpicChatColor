package xyz.herberto.epicchatcolor.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.herberto.epicchatcolor.EpicChatColor;
import xyz.herberto.epicchatcolor.playerdata.PlayerData;
import xyz.herberto.epicchatcolor.utils.CC;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        int slot = event.getSlot();
        Player player = (Player) event.getWhoClicked();
        String itemName = event.getClickedInventory().getItem(slot).getItemMeta().getDisplayName();
        PlayerData data = new PlayerData(player);

        if(CC.translate(event.getView().getTitle()).equals(CC.translate(EpicChatColor.getInstance().getConfig().getString("chatcolor-gui-name")))) {

            event.setCancelled(true);

            if(slot == 4) {
                if(player.hasPermission("epicchatcolor.color.DARK_PURPLE")) {
                    data.setChatColor(ChatColor.DARK_PURPLE);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 10) {
                if(player.hasPermission("epicchatcolor.color.AQUA")) {
                    data.setChatColor(ChatColor.AQUA);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 11) {
                if(player.hasPermission("epicchatcolor.color.BLACK")) {
                    data.setChatColor(ChatColor.BLACK);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 12) {
                if(player.hasPermission("epicchatcolor.color.BLUE")) {
                    data.setChatColor(ChatColor.BLUE);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 13) {
                if(player.hasPermission("epicchatcolor.color.DARK_AQUA")) {
                    data.setChatColor(ChatColor.DARK_AQUA);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 14) {
                if(player.hasPermission("epicchatcolor.color.DARK_BLUE")) {
                    data.setChatColor(ChatColor.DARK_BLUE);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 15) {
                if(player.hasPermission("epicchatcolor.color.DARK_GRAY")) {
                    data.setChatColor(ChatColor.DARK_GRAY);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 16) {
                if(player.hasPermission("epicchatcolor.color.DARK_GREEN")) {
                    data.setChatColor(ChatColor.DARK_GREEN);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 19) {
                if(player.hasPermission("epicchatcolor.color.GOLD")) {
                    data.setChatColor(ChatColor.GOLD);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 20) {
                if(player.hasPermission("epicchatcolor.color.GRAY")) {
                    data.setChatColor(ChatColor.GRAY);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 21) {
                if(player.hasPermission("epicchatcolor.color.GREEN")) {
                    data.setChatColor(ChatColor.GREEN);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 22) {
                if(player.hasPermission("epicchatcolor.color.LIGHT_PURPLE")) {
                    data.setChatColor(ChatColor.LIGHT_PURPLE);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 23) {
                if(player.hasPermission("epicchatcolor.color.RED")) {
                    data.setChatColor(ChatColor.RED);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 24) {
                if(player.hasPermission("epicchatcolor.color.DARK_RED")) {
                    data.setChatColor(ChatColor.DARK_RED);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 25) {
                if(player.hasPermission("epicchatcolor.color.YELLOW")) {
                    data.setChatColor(ChatColor.YELLOW);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 31) {
                if(player.hasPermission("epicchatcolor.color.WHITE")) {
                    data.setChatColor(ChatColor.WHITE);
                } else {
                    noPermission(player, itemName);
                }
            } else if(slot == 35) {
                openModifiersGUI(player);
            }

        } else if(CC.translate(event.getView().getTitle()).equals(CC.translate(EpicChatColor.getInstance().getConfig().getString("modifiers-gui-name")))) {

            event.setCancelled(true);

            if(slot == 11) {
                if(player.hasPermission("epicchatcolor.modifier.BOLD")) {
                    data.setModifier(ChatColor.BOLD);
                } else {
                    noPermissionModifier(player, itemName);
                }
            } else if(slot == 12) {
                if(player.hasPermission("epicchatcolor.modifier.ITALIC")) {
                    data.setModifier(ChatColor.ITALIC);
                } else {
                    noPermissionModifier(player, itemName);
                }
            } else if(slot == 13) {
                if(player.hasPermission("epicchatcolor.modifier.STRIKETHROUGH")) {
                    data.setModifier(ChatColor.STRIKETHROUGH);
                } else {
                    noPermissionModifier(player, itemName);
                }
            } else if(slot == 14) {
                if(player.hasPermission("epicchatcolor.modifier.UNDERLINE")) {
                    data.setModifier(ChatColor.UNDERLINE);
                } else {
                    noPermissionModifier(player, itemName);
                }
            } else if(slot == 15) {
                if(player.hasPermission("epicchatcolor.modifier.MAGIC")) {
                    data.setModifier(ChatColor.MAGIC);
                } else {
                    noPermissionModifier(player, "&f&lMAGIC MODIFIER");
                }
            } else if(slot == 18 || slot == 26) {
                data.setModifier(ChatColor.RESET);
            }

        }
    }

    public void openModifiersGUI(Player player) {

        Inventory m = Bukkit.createInventory(null, 9*3, CC.translate(EpicChatColor.getInstance().getConfig().getString("modifiers-gui-name")));

        ItemStack placeholderItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholderMeta = placeholderItem.getItemMeta();
        placeholderMeta.setDisplayName(" ");
        placeholderItem.setItemMeta(placeholderMeta);

        for (int i = 0; i < m.getSize(); i++) {
            m.setItem(i, placeholderItem);
        }

        ItemStack boldModifier = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta boldMeta = boldModifier.getItemMeta();
        boldMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.BOLD + "BOLD MODIFIER");
        boldModifier.setItemMeta(boldMeta);
        m.setItem(11, boldModifier);

        ItemStack italicModifier = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta italicMeta = italicModifier.getItemMeta();
        italicMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.ITALIC + "ITALIC MODIFIER");
        italicModifier.setItemMeta(italicMeta);
        m.setItem(12, italicModifier);

        ItemStack strikethroughModifier = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta strikethroughMeta = strikethroughModifier.getItemMeta();
        strikethroughMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.STRIKETHROUGH + "STRIKETHROUGH MODIFIER");
        strikethroughModifier.setItemMeta(strikethroughMeta);
        m.setItem(13, strikethroughModifier);

        ItemStack underlineModifier = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta underlineMeta = underlineModifier.getItemMeta();
        underlineMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.UNDERLINE + "UNDERLINE MODIFIER");
        underlineModifier.setItemMeta(underlineMeta);
        m.setItem(14, underlineModifier);

        ItemStack magicModifier = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta magicMeta = magicModifier.getItemMeta();
        magicMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.MAGIC + "MAGIC MODIFIER");
        magicModifier.setItemMeta(magicMeta);
        m.setItem(15, magicModifier);

        ItemStack clear = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta clearMeta = clear.getItemMeta();
        clearMeta.setDisplayName("" + ChatColor.WHITE + ChatColor.MAGIC + "CLEAR MODIFIER");
        clear.setItemMeta(clearMeta);
        m.setItem(18, clear);
        m.setItem(26, clear);

        player.openInventory(m);

    }

    public void noPermission(Player player, String itemName) {
        player.sendMessage(CC.translate(EpicChatColor.getInstance().getConfig().getString("messages.does-not-own-color").replaceAll("%color%", itemName)));
    }

    public void noPermissionModifier(Player player, String itemName) {
        player.sendMessage(CC.translate(EpicChatColor.getInstance().getConfig().getString("messages.does-not-own-modifier").replaceAll("%modifier%", itemName)));
    }

}

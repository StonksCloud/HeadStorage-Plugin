package net.vounty.studios.interact;

import net.vounty.studios.HeadStorage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent inventoryCloseEvent) {
        try {
            Player player = (Player) inventoryCloseEvent.getPlayer();

            if (inventoryCloseEvent.getView().getTitle().equals("§8┃ §f§lHeadStorage")) {
                HeadStorage.getService().getAPI().getStorageInventory().getPlayersList().remove(player);
            }
        } catch (Exception ignored) {}
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {
        try {
            Player player = (Player) inventoryClickEvent.getWhoClicked();

            if (inventoryClickEvent.getView().getTitle().equals("§8┃ §f§lHeadStorage")) {
                inventoryClickEvent.setCancelled(true);
                ItemStack itemStack = inventoryClickEvent.getCurrentItem();
                if (itemStack != null && itemStack.getItemMeta() != null) {

                    switch (itemStack.getItemMeta().getDisplayName()) {
                        case "§f§l←":
                            if (HeadStorage.getService().getAPI().getStorageInventory().isOnFirstPage(player)) {
                                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7You are already on the §f§lfirst page§7.");
                                return;
                            }
                            HeadStorage.getService().getAPI().getStorageInventory().getPlayersPage().put(player, HeadStorage.getService().getAPI().getStorageInventory().getPlayersPage().get(player) - 1);
                            HeadStorage.getService().getAPI().getStorageInventory().updateItems(player, inventoryClickEvent.getClickedInventory());
                            break;
                        case "§f§l→":
                            if (!HeadStorage.getService().getAPI().getStorageInventory().hasNextPage(player)) {
                                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7You are already on the §f§llast page§7.");
                                return;
                            }
                            HeadStorage.getService().getAPI().getStorageInventory().getPlayersPage().put(player, HeadStorage.getService().getAPI().getStorageInventory().getPlayersPage().get(player) + 1);
                            HeadStorage.getService().getAPI().getStorageInventory().updateItems(player, inventoryClickEvent.getClickedInventory());
                            break;
                        default:
                            if (itemStack.getType().equals(Material.PLAYER_HEAD)) {
                                ItemStack cloneItemStack = itemStack.clone();
                                ItemMeta itemMeta = cloneItemStack.getItemMeta();
                                itemMeta.setLore(null);
                                itemMeta.setDisplayName(itemMeta.getDisplayName().replace("§8┃ §f", ""));
                                cloneItemStack.setItemMeta(itemMeta);
                                player.getInventory().addItem(cloneItemStack);
                            }
                            break;
                    }

                }
            }

        } catch (Exception ignored) {}
    }

}

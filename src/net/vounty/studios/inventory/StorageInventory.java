package net.vounty.studios.inventory;

import net.vounty.studios.HeadStorage;
import net.vounty.studios.config.HeadStorageConfig;
import net.vounty.studios.creator.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class StorageInventory {

    private final Map<Player, Integer> playersPage = new LinkedHashMap<>();
    private final Map<Player, List<HeadStorageConfig.HeadEntry>> playersList = new LinkedHashMap<>();

    public void open(Player player) {
        this.getPlayersPage().putIfAbsent(player, 1);
        this.getPlayersPage().put(player, 1);
        Inventory inventory = Bukkit.createInventory(player, 6*9, "§8┃ §f§lHeadStorage");

        inventory.setItem(45, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(46, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(47, new ItemCreator(Material.BOOK, 1).setDisplayName("§8⋆ §fPage").setLore("§8┃ §7" + this.getPlayersPage().get(player)).create());
        inventory.setItem(48, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(49, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(50, new ItemCreator(Material.PLAYER_HEAD, 1).setDisplayName("§f§l←").setSkullData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ2OWUwNmU1ZGFkZmQ4NGU1ZjNkMWMyMTA2M2YyNTUzYjJmYTk0NWVlMWQ0ZDcxNTJmZGM1NDI1YmMxMmE5In19fQ==", false).create());
        inventory.setItem(51, new ItemCreator(Material.PLAYER_HEAD, 1).setDisplayName("§f§l→").setSkullData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19", false).create());
        inventory.setItem(52, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(53, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());

        this.updateItems(player, inventory);

        player.openInventory(inventory);
    }

    public void open(Player player, List<HeadStorageConfig.HeadEntry> headEntries) {
        this.getPlayersPage().putIfAbsent(player, 1);
        this.getPlayersPage().put(player, 1);
        Inventory inventory = Bukkit.createInventory(player, 6*9, "§8┃ §f§lHeadStorage");

        inventory.setItem(45, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(46, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(47, new ItemCreator(Material.BOOK, 1).setDisplayName("§8⋆ §fPage").setLore("§8┃ §7" + this.getPlayersPage().get(player)).create());
        inventory.setItem(48, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(49, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(50, new ItemCreator(Material.PLAYER_HEAD, 1).setDisplayName("§f§l←").setSkullData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ2OWUwNmU1ZGFkZmQ4NGU1ZjNkMWMyMTA2M2YyNTUzYjJmYTk0NWVlMWQ0ZDcxNTJmZGM1NDI1YmMxMmE5In19fQ==", false).create());
        inventory.setItem(51, new ItemCreator(Material.PLAYER_HEAD, 1).setDisplayName("§f§l→").setSkullData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19", false).create());
        inventory.setItem(52, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());
        inventory.setItem(53, new ItemCreator(Material.BLACK_STAINED_GLASS_PANE, 1).setDisplayName(" ").create());

        this.updateItems(player, inventory, headEntries);

        player.openInventory(inventory);
    }

    public void updateItems(Player player, Inventory inventory, List<HeadStorageConfig.HeadEntry> headEntries) {
        for (int count = 0; count < 45; count++) inventory.setItem(count, new ItemStack(Material.AIR));
        inventory.setItem(48, new ItemCreator(Material.BOOK, 1).setDisplayName("§8⋆ §fPage").setLore("§8┃ §7" + this.getPlayersPage().get(player)).create());
        headEntries.forEach(head -> {
            inventory.addItem(new ItemCreator(Material.PLAYER_HEAD, 1).setDisplayName("§8┃ §f" + head.getName()).setLore(buildLoreForHead(head)).setSkullData(head.getTexture(), false).create());
        });
    }

    public void updateItems(Player player, Inventory inventory) {
        for (int count = 0; count < 45; count++) inventory.setItem(count, new ItemStack(Material.AIR));
        inventory.setItem(48, new ItemCreator(Material.BOOK, 1).setDisplayName("§8⋆ §fPage").setLore("§8┃ §7" + this.getPlayersPage().get(player)).create());
        List<HeadStorageConfig.HeadEntry> headEntries;
        if (this.getPlayersPage().get(player) == 1) {
            headEntries = getArray(player, 0, 45);
        } else headEntries = getArray(player);

        headEntries.forEach(head -> {
            inventory.addItem(new ItemCreator(Material.PLAYER_HEAD, 1).setDisplayName("§8┃ §f" + head.getName()).setLore(buildLoreForHead(head)).setSkullData(head.getTexture(), false).create());
        });
    }

    public List<String> buildLoreForHead(HeadStorageConfig.HeadEntry headEntry) {
        List<String> array = new LinkedList<>();
        array.add("§8§m------------------------");
        array.add("§fID§8: §7" + headEntry.getId());
        array.add("§fTags§8:");
        for (String tag : headEntry.getTags()) array.add("  §7" + tag);
        array.add("");
        array.add(" §7Click here, to get this item.");
        return array;
    }

    public List<HeadStorageConfig.HeadEntry> getArray(Player player) {
        return this.getArray(player, (this.getPlayersPage().get(player) - 1) * 45, this.getPlayersPage().get(player) * 45);
    }

    public boolean isOnFirstPage(Player player) {
        return this.getPlayersPage().get(player).equals(1);
    }

    public boolean hasNextPage(Player player) {
        int oldPlayersPage = this.getPlayersPage().get(player);
        this.getPlayersPage().put(player, oldPlayersPage + 1);
        List<HeadStorageConfig.HeadEntry> array = this.getArray(player);
        this.getPlayersPage().put(player, oldPlayersPage);
        return array.size() > 0;
    }

    public List<HeadStorageConfig.HeadEntry> getArray(Player player, Integer from, Integer to) {
        List<HeadStorageConfig.HeadEntry> array = new LinkedList<>();
        try {
            for (int count = from; count < to; count++) {
                HeadStorageConfig.HeadEntry headEntry = this.getPlayersList().containsKey(player) ? this.getPlayersList().get(player).get(count) : HeadStorage.getService().getAPI().getHeadStorageConfig().getHeads().get(count);
                if (headEntry != null) array.add(headEntry);
            }
        } catch (Exception ignored) {}
        return array;
    }

    public Map<Player, Integer> getPlayersPage() {
        return playersPage;
    }

    public Map<Player, List<HeadStorageConfig.HeadEntry>> getPlayersList() {
        return playersList;
    }

}

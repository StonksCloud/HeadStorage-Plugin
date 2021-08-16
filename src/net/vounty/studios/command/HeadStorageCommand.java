package net.vounty.studios.command;

import net.vounty.studios.HeadStorage;
import net.vounty.studios.config.HeadStorageConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class HeadStorageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] arguments) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§cYou must be a player.");
            return true;
        }
        Player player = (Player) commandSender;
        if (!player.hasPermission("vounty.headstorage.use") || !player.isOp()) {
            player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§cI'm sorry, but you don't have access to this command.");
            return true;
        }

        switch (arguments.length) {
            case 0:
                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Use §f§l/§fHeadStorage§7.");
                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Use §f§l/§fHeadStorage reload§7.");
                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Use §f§l/§fHeadStorage gui§7.");
                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Use §f§l/§fHeadStorage find §8(§7-n, -t, -i§8) §8(§7Value§8)§7.");
                break;
            case 1:
                switch (arguments[0].toLowerCase(Locale.ROOT)) {
                    case "reload":
                        HeadStorage.getService().getAPI().reload();
                        player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Plugin §fHeadStorage §7has been reloaded.");
                        break;
                    case "gui":
                        HeadStorage.getService().getAPI().getStorageInventory().open(player);
                        break;
                    default:
                        player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Use §f§l/§fHeadStorage §7for more help.");
                        break;
                }
                break;
            case 3:
                if (arguments[0].toLowerCase(Locale.ROOT).equals("find")) {
                    switch (arguments[1].toLowerCase(Locale.ROOT)) {
                        case "-n":
                        case "-name":
                            Optional<List<HeadStorageConfig.HeadEntry>> optionalHeadEntries = HeadStorage.getService().getAPI().getHeadManager().getHeadEntries(arguments[2]);
                            if (optionalHeadEntries.isPresent()) {
                                HeadStorage.getService().getAPI().getStorageInventory().getPlayersList().put(player, optionalHeadEntries.get());
                                HeadStorage.getService().getAPI().getStorageInventory().open(player, optionalHeadEntries.get());
                            } else player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Can't find skull with §fName §8'§f§l" + arguments[2] + "§8'§7.");
                            break;
                        case "-t":
                        case "-tag":
                            Optional<List<HeadStorageConfig.HeadEntry>> optionalHeadEntries2 = HeadStorage.getService().getAPI().getHeadManager().getHeadEntries(Collections.singletonList(arguments[2]));
                            if (optionalHeadEntries2.isPresent()) {
                                HeadStorage.getService().getAPI().getStorageInventory().getPlayersList().put(player, optionalHeadEntries2.get());
                                HeadStorage.getService().getAPI().getStorageInventory().open(player, optionalHeadEntries2.get());
                            } else player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Can't find skull with §fTag §8'§f§l" + arguments[2] + "§8'§7.");
                            break;
                        case "-i":
                        case "-id":
                            try {
                                int id = Integer.parseInt(arguments[2]);
                                Optional<List<HeadStorageConfig.HeadEntry>> optionalHeadEntries3 = HeadStorage.getService().getAPI().getHeadManager().getHeadEntries(id);
                                if (optionalHeadEntries3.isPresent()) {
                                    HeadStorage.getService().getAPI().getStorageInventory().getPlayersList().put(player, optionalHeadEntries3.get());
                                    HeadStorage.getService().getAPI().getStorageInventory().open(player, optionalHeadEntries3.get());
                                } else player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Can't find skull with §fID §8'§f§l" + id + "§8'§7.");
                            } catch (NumberFormatException ignored) {
                                player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7That's not a number.");
                            }
                            break;
                    }
                    break;
                } else player.sendMessage(HeadStorage.getService().getAPI().getPrefix() + "§7Use §f§l/§fHeadStorage §7for more help.");
        }
        return false;
    }

}

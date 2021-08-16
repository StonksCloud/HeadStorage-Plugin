package net.vounty.studios;

import net.vounty.studios.api.HeadStorageAPI;
import net.vounty.studios.command.HeadStorageCommand;
import net.vounty.studios.interact.InteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HeadStorage extends JavaPlugin {

    private static HeadStorage service;
    private final HeadStorageAPI api = new HeadStorageAPI();

    @Override
    public void onEnable() {
        this.setService(this);
        this.getAPI().reload();
        this.getServer().getPluginManager().registerEvents(new InteractListener(), this);
        getCommand("headstorage").setExecutor(new HeadStorageCommand());
    }

    @Override
    public void onDisable() {
        this.setService(null);
    }

    public static HeadStorage getService() {
        return service;
    }

    public void setService(HeadStorage service) {
        HeadStorage.service = service;
    }

    public HeadStorageAPI getAPI() {
        return api;
    }

}

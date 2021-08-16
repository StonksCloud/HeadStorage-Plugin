package net.vounty.studios.api;

import net.vounty.studios.config.HeadStorageConfig;
import net.vounty.studios.inventory.StorageInventory;
import net.vounty.studios.manager.ConfigManager;
import net.vounty.studios.manager.HeadManager;

public class HeadStorageAPI {

    private String prefix = "§8┃ §fHeadStorage §8⋆ ";
    private HeadStorageConfig headStorageConfig;

    private final StorageInventory storageInventory = new StorageInventory();

    private final ConfigManager configManager = new ConfigManager();
    private final HeadManager headManager = new HeadManager();

    public void reload() {
        this.setHeadStorageConfig(this.getConfigManager().readConfigFromWeb("https://studios.vounty.net/heads/HeadStorage.json", HeadStorageConfig.class));
    }

    public StorageInventory getStorageInventory() {
        return storageInventory;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public HeadManager getHeadManager() {
        return headManager;
    }

    public HeadStorageConfig getHeadStorageConfig() {
        return headStorageConfig;
    }

    public void setHeadStorageConfig(HeadStorageConfig headStorageConfig) {
        this.headStorageConfig = headStorageConfig;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}

package net.vounty.studios.manager;

import net.vounty.studios.HeadStorage;
import net.vounty.studios.config.HeadStorageConfig;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class HeadManager {

    public Optional<HeadStorageConfig.HeadEntry> getHeadEntry(String name) {
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            if (head.getName().equals(name) || head.getName().startsWith(name) || head.getName().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT)) || head.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) return Optional.of(head);
        }
        return Optional.empty();
    }

    public Optional<List<HeadStorageConfig.HeadEntry>> getHeadEntries(String name) {
        List<HeadStorageConfig.HeadEntry> array = new LinkedList<>();
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            if (head.getName().equals(name) || head.getName().startsWith(name) || head.getName().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT)) || head.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) if (!array.contains(head)) array.add(head);
        }
        return array.size() > 0 ? Optional.of(array) : Optional.empty();
    }

    public Optional<HeadStorageConfig.HeadEntry> getHeadEntry(Integer id) {
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            if (head.getId().equals(id)) return Optional.of(head);
        }
        return Optional.empty();
    }

    public Optional<List<HeadStorageConfig.HeadEntry>> getHeadEntries(Integer id) {
        List<HeadStorageConfig.HeadEntry> array = new LinkedList<>();
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            if (head.getId().equals(id)) array.add(head);
        }
        return array.size() > 0 ? Optional.of(array) : Optional.empty();
    }

    public Optional<HeadStorageConfig.HeadEntry> getHeadEntry(String... tags) {
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            for (String searchTag : tags) {
                for (String existTag : head.getTags()) if (searchTag.equals(existTag) || existTag.startsWith(searchTag) || searchTag.toLowerCase(Locale.ROOT).equals(existTag.toLowerCase(Locale.ROOT)) || existTag.toLowerCase(Locale.ROOT).startsWith(searchTag.toLowerCase(Locale.ROOT))) return Optional.of(head);
            }
        }
        return Optional.empty();
    }

    public Optional<List<HeadStorageConfig.HeadEntry>> getHeadEntries(String... tags) {
        List<HeadStorageConfig.HeadEntry> array = new LinkedList<>();
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            for (String searchTag : tags) {
                for (String existTag : head.getTags()) if (searchTag.equals(existTag) || existTag.startsWith(searchTag) || searchTag.toLowerCase(Locale.ROOT).equals(existTag.toLowerCase(Locale.ROOT)) || existTag.toLowerCase(Locale.ROOT).startsWith(searchTag.toLowerCase(Locale.ROOT))) if (!array.contains(head)) array.add(head);
            }
        }
        return array.size() > 0 ? Optional.of(array) : Optional.empty();
    }

    public Optional<HeadStorageConfig.HeadEntry> getHeadEntry(List<String> tags) {
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            for (String searchTag : tags) {
                for (String existTag : head.getTags()) if (searchTag.equals(existTag) || existTag.startsWith(searchTag) || searchTag.toLowerCase(Locale.ROOT).equals(existTag.toLowerCase(Locale.ROOT)) || existTag.toLowerCase(Locale.ROOT).startsWith(searchTag.toLowerCase(Locale.ROOT))) return Optional.of(head);
            }
        }
        return Optional.empty();
    }

    public Optional<List<HeadStorageConfig.HeadEntry>> getHeadEntries(List<String> tags) {
        List<HeadStorageConfig.HeadEntry> array = new LinkedList<>();
        HeadStorageConfig headStorageConfig = HeadStorage.getService().getAPI().getHeadStorageConfig();
        for (HeadStorageConfig.HeadEntry head : headStorageConfig.getHeads()) {
            for (String searchTag : tags) {
                for (String existTag : head.getTags()) if (searchTag.equals(existTag) || existTag.startsWith(searchTag) || searchTag.toLowerCase(Locale.ROOT).equals(existTag.toLowerCase(Locale.ROOT)) || existTag.toLowerCase(Locale.ROOT).startsWith(searchTag.toLowerCase(Locale.ROOT))) if (!array.contains(head)) array.add(head);
            }
        }
        return array.size() > 0 ? Optional.of(array) : Optional.empty();
    }

}

package net.vounty.studios.config;

import java.util.List;

public class HeadStorageConfig {

    private final List<CommandEntry> commands;
    private final List<HeadEntry> heads;

    public HeadStorageConfig(List<CommandEntry> commands, List<HeadEntry> heads) {
        this.commands = commands;
        this.heads = heads;
    }

    public List<CommandEntry> getCommands() {
        return commands;
    }

    public List<HeadEntry> getHeads() {
        return heads;
    }

    public static class CommandEntry {

        private final String name, command;

        public CommandEntry(String name, String command) {
            this.name = name;
            this.command = command;
        }

        public String getName() {
            return name;
        }

        public String getCommand() {
            return command;
        }

    }

    public static class HeadEntry {

        private final Integer id;
        private final String name, texture;
        private final List<String> tags;

        public HeadEntry(Integer id, String name, String texture, List<String> tags) {
            this.id = id;
            this.name = name;
            this.texture = texture;
            this.tags = tags;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getTexture() {
            return texture;
        }

        public List<String> getTags() {
            return tags;
        }

    }

}

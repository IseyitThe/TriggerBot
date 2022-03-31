package me.seyit.sprint;

import me.seyit.sprint.config.Configuration;
import me.seyit.sprint.config.ConfigurationOptions;
import me.seyit.sprint.util.KeyBindings;
import net.fabricmc.api.ClientModInitializer;

public class Sprintmod implements ClientModInitializer {
    public KeyBindings keyBindings = new KeyBindings();
    public ConfigurationOptions configurationOptions;
    public Sprint Sprint;

    private static Sprintmod instance = null;

    public static Sprintmod getInstance() {
        return instance;
    }

    @Override
    public void onInitializeClient() {
        if (instance != null) {
            throw new RuntimeException("Sprintmod has already been initialized!");
        }
        instance = this;

        configurationOptions = new ConfigurationOptions();
        Sprint = new Sprint();
    }
}

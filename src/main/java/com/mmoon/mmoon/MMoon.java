package com.mmoon.mmoon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MMoon extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new Handler(), this);

        getLogger().info("Plugin MMoon's on");

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin MMoon's off");

    }

}

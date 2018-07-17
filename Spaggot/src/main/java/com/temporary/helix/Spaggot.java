package com.temporary.helix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * This file is part of Helix
 * Creation date: 7/15/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class Spaggot extends JavaPlugin {

    @Override
    public void onEnable() {
        File file = new File(getDataFolder() + "modules/");

        if (!file.exists()) file.mkdirs();
    }

    @Override
    public void onDisable() {
        //
    }
}

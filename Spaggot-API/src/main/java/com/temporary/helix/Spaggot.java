package com.temporary.helix;

import com.temporary.helix.module.ModuleLoader;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This file is part of Helix
 * Creation date: 7/15/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class Spaggot {

    private ModuleLoader loader = null;

    public void onEnable() {
        loader = new ModuleLoader(this);
    }

    public void onDisable() {
        loader = null;
    }
}

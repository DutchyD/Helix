package com.temporary.helix.module;

import java.util.jar.Manifest;

/**
 * This file is part of Helix
 * Creation date: 7/16/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class ModuleContext {

    private final String path;
    private final String[] args;

    public ModuleContext(String path, String... args) {
        this.path = path;
        this.args = args;
    }

    public String getPath() {
        return path;
    }

    public String[] getArgs() {
        return args;
    }
}

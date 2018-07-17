package com.temporary.helix.module;

import com.temporary.helix.Spaggot;

/**
 * This file is part of Helix
 * Creation date: 7/15/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public abstract class SpaggotModule {

    private final Spaggot spaggot;
    private final ModuleContext context;

    private boolean isLoaded = false;
    private boolean isEnabled = false;

    public SpaggotModule(Spaggot spaggot, ModuleContext context) {
        this.spaggot = spaggot;
        this.context = context;
    }

     void load(String... args) {
        if (this.isLoaded) return;

        this.onLoad(args);

        this.isLoaded = true;
    }

    void enable(String... args) {
        if (this.isEnabled) return;

        this.onEnable(args);

        this.isEnabled = true;
    }

    void disable(String... args) {
        if (!this.isEnabled) return;

        this.onDisable(args);

        this.isEnabled = false;
    }


    public abstract void onLoad(String... args);
    public abstract void onEnable(String... args);
    public abstract void onDisable(String... args);

    public Spaggot getSpaggot() {
        return spaggot;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    protected ModuleContext getContext() {
        return context;
    }

}

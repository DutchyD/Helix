package com.temporary.helix.test;

import com.temporary.helix.Spaggot;
import com.temporary.helix.module.ModuleContext;
import com.temporary.helix.module.ModuleSettings;
import com.temporary.helix.module.SpaggotModule;

/**
 * This file is part of Helix
 * Creation date: 7/15/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

@ModuleSettings(spaggotVersion = "0.0.1", id = "TestModule")
public class SpaggotTestModule extends SpaggotModule {

    public SpaggotTestModule(Spaggot spaggot, ModuleContext context) {
        super(spaggot, context);
    }

    @Override
    public void onLoad(String... args) {
        System.out.println("I've been loaded! Hooray! Here's my arguments: ");
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    @Override
    public void onEnable(String... args) {

    }

    @Override
    public void onDisable(String... args) {

    }
}

package com.temporary.helix.test;

import com.temporary.helix.Spaggot;
import com.temporary.helix.exception.ModuleException;
import com.temporary.helix.module.ModuleLoader;

/**
 * This file is part of Helix
 * Creation date: 7/17/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class SpaggotTest {

    public static void main(String... args) {
        ModuleLoader loader = new ModuleLoader(new Spaggot());
        try {
            loader.load("E:/Development/Active/Helix/SpaggotTestModule/target/SpaggotTestModule-1.0-SNAPSHOT.jar", args);
        } catch (ModuleException e) {
            System.out.println("IT FUCKING BROKE FUCK MY LIFE JESUS DOESN'T EXIST THIS IS IT RAGNAROK IS UPON US. RIP TO ALL YOUR FAMILIES CYA LATER.");
            e.printStackTrace();
        }
    }

}

package com.temporary.helix;

import com.temporary.helix.module.ModuleSettings;
import com.temporary.helix.module.SpaggotModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * This file is part of Helix
 * Creation date: 7/15/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class TestSpaggot {

    public static void main(String... args) {

        String jarPath = args[0];

        File file = new File(jarPath);

        String main = null;

        try {

            JarFile jar = new JarFile(file);
            Manifest mnfs = jar.getManifest();
            Attributes attrs = mnfs.getMainAttributes();

            main = attrs.getValue("Spaggot-Main");

            System.out.println("Spaggot-Main value: " + main);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (main.equals("null") || main.isEmpty()) System.exit(1);

        try {
            URL url = new URL("file:" + jarPath);
            URLClassLoader loader = new URLClassLoader(new URL[]{url});
            Class<?> cl = Class.forName(main, true, loader);

            System.out.println("Has cool annotation: " + cl.isAnnotationPresent(ModuleSettings.class));
            System.out.println("isCool Cool annotation value: " + cl.getAnnotation(ModuleSettings.class).id());

            Object clazz = cl.getDeclaredConstructor().newInstance();

            SpaggotModule module = (SpaggotModule) clazz;
            module.onLoad("WOW", "Interesting", "Yes, indeed!");

            for (Class<?> i : cl.getInterfaces()) {
                System.out.println(i.getName());
            }

            loader.close();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

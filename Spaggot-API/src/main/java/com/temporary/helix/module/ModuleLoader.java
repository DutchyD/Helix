package com.temporary.helix.module;

import com.temporary.helix.Spaggot;
import com.temporary.helix.exception.ModuleException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * This file is part of Helix
 * Creation date: 7/16/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class ModuleLoader {

    private final Spaggot spaggot;
    private HashMap<String, SpaggotModule> modules = new HashMap<>();

    public ModuleLoader(Spaggot spaggot) {
        this.spaggot = spaggot;
    }

    public void load(String path, String... args) throws ModuleException {

        File file = new File(path);
        String main;

        try {

            JarFile jar = new JarFile(file);
            Manifest mnfs = jar.getManifest();
            Attributes attrs = mnfs.getMainAttributes();

            main = attrs.getValue("Spaggot-Main");

            System.out.println("Spaggot-Main value: " + main); //TODO: Log
        } catch (IOException e) {
            throw new ModuleException(e.getMessage());
        }

        if (main.equals("null") || main.isEmpty())
            throw new ModuleException("Invalid module manifest. Spaggot-Main contains incorrect class name");

        try {

            URL url = new URL("file:" + path);
            URLClassLoader loader = new URLClassLoader(new URL[]{url});
            Class<?> cl = Class.forName(main, true, loader);


            if (!cl.isAnnotationPresent(ModuleSettings.class))
                throw new ModuleException("Main class requires ModuleSettings annotation. Please provide.");

            ModuleSettings settings = cl.getAnnotation(ModuleSettings.class);

            String id = settings.id();

            if (id.equals("null") || id.isEmpty())
                throw new ModuleException("Invalid ID specified. Cannot be empty or null");

            if (modules.containsKey(id))
                throw new ModuleException("Module already loaded");

            ModuleContext context = new ModuleContext(path, args);

            Object clazz = cl.getDeclaredConstructor(Spaggot.class, ModuleContext.class).newInstance(spaggot, context);

            SpaggotModule module = (SpaggotModule) clazz;
            module.onLoad(args);

            loader.close();

            modules.put(id, module);
        } catch (IOException | InstantiationException | InvocationTargetException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException e) {
            throw new ModuleException(e.getMessage());
        }
    }

    public void unload(String id) throws ModuleException {

        if (!modules.containsKey(id)) throw new ModuleException("Invalid module ID specified");

        modules.remove(id);
    }

    public void reload(String id) throws ModuleException {

        if (!modules.containsKey(id)) throw new ModuleException("Invalid module ID specified");

        SpaggotModule module = modules.get(id);
        ModuleContext context = module.getContext();

        unload(id);
        load(context.getPath(), context.getArgs());
    }

    private SpaggotModule getModule(String id) {
        return modules.get(id);
    }

    public void displayModulesByID() {
        modules.keySet().forEach(System.out::println);
    }
}

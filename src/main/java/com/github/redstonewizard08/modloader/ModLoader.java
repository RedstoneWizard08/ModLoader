package com.github.redstonewizard08.modloader;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import net.fabricmc.api.ModInitializer;

public class ModLoader {
    private static final Logger LOGGER = LogManager.getLogger("ModLoader");

    public static void main(String[] args) {
        ModLoader.run();
    }

    private static void run() {
        LOGGER.always().withLocation()
            .log("Searching for mods...");

        List<Class<? extends ModInitializer>> classes = new ArrayList<>();

        ScanResult result = new ClassGraph().rejectPackages("net.fabricmc").enableClassInfo().scan();
        for(ClassInfo ci : result.getClassesImplementing(ModInitializer.class)) {
            classes.add(ci.loadClass().asSubclass(ModInitializer.class));
        }

        LOGGER.always().withLocation()
            .log("Found {} mods.", classes.size());

        for(Class<? extends ModInitializer> clazz : classes) {
            try {
                LOGGER.always().withLocation()
                    .log("Found mod: " + clazz.getSimpleName());
                clazz.getDeclaredConstructor().newInstance().onInitialize();
            } catch(Exception e) {
                LOGGER.always().withLocation()
                    .log("Failed to load mod: " + clazz.getSimpleName());
                e.printStackTrace();
            }
        }

        LOGGER.always().withLocation()
            .log("Done!");
    }
}

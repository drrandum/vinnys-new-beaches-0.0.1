package net.vinny.newbeaches;

import net.fabricmc.api.ModInitializer;

import net.vinny.newbeaches.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewBeaches implements ModInitializer {
    public static final String MOD_ID = "newbeaches";
    public static final Logger LOGGER = LoggerFactory.getLogger("newbeaches");

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}
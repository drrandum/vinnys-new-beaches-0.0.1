package net.vinny.newbeaches;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.vinny.newbeaches.block.ModBlocks;
import net.vinny.newbeaches.block.ModFlammableBlockRegistry;
import net.vinny.newbeaches.item.ModItemGroup;
import net.vinny.newbeaches.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewBeaches implements ModInitializer {
    public static final String MOD_ID = "newbeaches";
    public static final Logger LOGGER = LoggerFactory.getLogger("newbeaches");

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModFlammableBlockRegistry.registerFlammableBlocks();
        StrippableBlockRegistry.register(ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_WOOD);
    }
}
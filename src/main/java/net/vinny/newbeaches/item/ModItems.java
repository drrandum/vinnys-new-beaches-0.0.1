package net.vinny.newbeaches.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vinny.newbeaches.NewBeaches;

public class ModItems {

    public static final Item COCONUT = registerItem("coconut",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NewBeaches.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NewBeaches.LOGGER.info("Registering Mod Items for " + NewBeaches.MOD_ID);
    }
}

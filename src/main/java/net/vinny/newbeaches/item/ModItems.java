package net.vinny.newbeaches.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vinny.newbeaches.NewBeaches;

public class ModItems {
    public static final Item COCONUT = registerItem("coconut",
            new Item(new FabricItemSettings()));
    public static final Item COCONUT_FLESH = registerItem("coconut_flesh",
            new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(6).saturationModifier(6f).build())));
    public static final Item COCONUT_MILK_BOTTLE = registerItem("coconut_milk_bottle",
            new CoconutMilkBottle(new FabricItemSettings()));
    public static final Item VINNY_ITEM = registerItem("vinny_item",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NewBeaches.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.NEW_BEACHES, COCONUT);
        addToItemGroup(ModItemGroup.NEW_BEACHES, COCONUT_FLESH);
        addToItemGroup(ModItemGroup.NEW_BEACHES, COCONUT_MILK_BOTTLE);
        addToItemGroup(ModItemGroup.NEW_BEACHES, VINNY_ITEM);

        addToItemGroup(ItemGroups.FOOD_AND_DRINK, COCONUT);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, COCONUT_FLESH);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, COCONUT_MILK_BOTTLE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        NewBeaches.LOGGER.info("Registering Mod Items for " + NewBeaches.MOD_ID);
        addItemsToItemGroup();
    }
}
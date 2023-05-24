package net.vinny.newbeaches.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vinny.newbeaches.NewBeaches;

public class ModItemGroup {
    public static ItemGroup NEW_BEACHES;

    public static void registerItemGroups() {
        NEW_BEACHES = FabricItemGroup.builder(new Identifier(NewBeaches.MOD_ID, "coconut"))
                .displayName(Text.literal("New Beaches"))
                .icon(() -> new ItemStack(ModItems.COCONUT)).build();
    }
}

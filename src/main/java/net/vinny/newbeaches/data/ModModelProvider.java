package net.vinny.newbeaches.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.vinny.newbeaches.block.ModBlocks;
import net.vinny.newbeaches.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VINNY_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.PALM_LOG)
                .log(ModBlocks.PALM_LOG)
                .wood(ModBlocks.PALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALM_LOG)
                .log(ModBlocks.STRIPPED_PALM_LOG)
                .wood(ModBlocks.STRIPPED_PALM_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALM_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALM_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.PALM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VINNY_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT_MILK_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT_FLESH, Models.GENERATED);
    }
}

package net.vinny.newbeaches.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.vinny.newbeaches.block.ModBlocks;
import net.vinny.newbeaches.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VINNY_ITEM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VINNY_BLOCK);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COCONUT_MILK_BOTTLE)
                .input(ModItems.COCONUT_FLESH)
                .input(Items.POTION)
                .offerTo(exporter);
    }
}

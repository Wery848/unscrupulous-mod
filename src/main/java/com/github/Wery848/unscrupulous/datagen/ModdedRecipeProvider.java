package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModdedRecipeProvider extends RecipeProvider {
    protected ModdedRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.UNREFINED_SENSUS), RecipeCategory.MISC, ModItems.REFINED_SENSUS, 0.1f, 800).unlockedBy("has_unrefined_spiritus", this.has(ModItems.UNREFINED_SENSUS)).save(this.output, "spiritus_refining");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.SENSUS_ORE), RecipeCategory.MISC, ModItems.REFINED_SENSUS, 0.1f, 800).unlockedBy("has_spiritus_ore", this.has(ModBlocks.SENSUS_ORE)).save(this.output, "spiritus_ore_refining");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.DEEPSLATE_SENSUS_ORE), RecipeCategory.MISC, ModItems.REFINED_SENSUS, 0.1f, 800).unlockedBy("has_deepslate_spiritus_ore", this.has(ModBlocks.DEEPSLATE_SENSUS_ORE)).save(this.output, "deepslate_spiritus_ore_refining");

    }

    // The runner to add to the data generator
    public static class Runner extends RecipeProvider.Runner {
        // Get the parameters from GatherDataEvent.
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModdedRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "unscrupulous_recipe_provider_runner";
        }
    }
}

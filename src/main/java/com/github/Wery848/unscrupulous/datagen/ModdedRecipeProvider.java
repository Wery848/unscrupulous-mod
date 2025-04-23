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
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.SOUL_STONE), RecipeCategory.MISC, ModItems.REFINED_SOUL_STONE, 0.1f, 800).unlockedBy("has_soul_stone", this.has(ModItems.SOUL_STONE)).save(this.output, "soul_stone_refining");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.SOUL_STONE_ORE), RecipeCategory.MISC, ModItems.REFINED_SOUL_STONE, 0.1f, 800).unlockedBy("has_soul_stone_ore", this.has(ModBlocks.SOUL_STONE_ORE)).save(this.output, "soul_stone_ore_refining");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.DEEPSLATE_SOUL_STONE_ORE), RecipeCategory.MISC, ModItems.REFINED_SOUL_STONE, 0.1f, 800).unlockedBy("has_deepslate_soul_stone_ore", this.has(ModBlocks.DEEPSLATE_SOUL_STONE_ORE)).save(this.output, "deepslate_soul_stone_ore_refining");

        shapeless(RecipeCategory.MISC, ModItems.SOUL_IN_A_BOTTLE)
                .requires(Items.SOUL_SAND)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_soul_sand", this.has(Items.SOUL_SAND)).save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.SOUL_IN_A_BOTTLE)
                .requires(Items.SOUL_SOIL)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_soul_soil", this.has(Items.SOUL_SOIL)).save(this.output, "unscrupulous:soul_in_a_bottle_from_soul_soil");
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

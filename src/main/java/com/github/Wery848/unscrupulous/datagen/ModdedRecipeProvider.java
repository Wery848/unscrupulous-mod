package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

public class ModdedRecipeProvider extends RecipeProvider implements IConditionBuilder {
    protected ModdedRecipeProvider(HolderLookup.Provider lookup, RecipeOutput output) {
        super(lookup, output);
    }

    @Override
    protected void buildRecipes() {

    }
}

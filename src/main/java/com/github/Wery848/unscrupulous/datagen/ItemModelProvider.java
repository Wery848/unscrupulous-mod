package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UnscrupulousMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // For all Items
        basicItem(ModItems.SOUL_STONE.get());
    }
}

package io.github.Wery848.unscrupulous.datagen;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {
    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, UnscrupulousMod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Figure out stuff first...
    }
}

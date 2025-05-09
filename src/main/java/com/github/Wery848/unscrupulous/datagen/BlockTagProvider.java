package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, UnscrupulousMod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SENSUS_ORE.get())
                .add(ModBlocks.DEEPSLATE_SENSUS_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SENSUS_ORE.get())
                .add(ModBlocks.DEEPSLATE_SENSUS_ORE.get());

        tag(BlockTags.FIRE)
                .add(ModBlocks.SENSUS_FIRE.get());
    }
}

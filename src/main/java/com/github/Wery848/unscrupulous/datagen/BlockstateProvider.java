package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockstateProvider extends BlockStateProvider {
    public BlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UnscrupulousMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Do for all Blocks in BLOCKS Deferred register
        blockWithItem(ModBlocks.SOUL_STONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SOUL_STONE_ORE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

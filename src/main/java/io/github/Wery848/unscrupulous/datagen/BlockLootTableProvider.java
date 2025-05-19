package io.github.Wery848.unscrupulous.datagen;

import io.github.Wery848.unscrupulous.block.ModBlocks;
import io.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {

    protected BlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // MUST HAVE DATAGEN FOR ALL BLOCKS PRESENT IN BLOCKS DEFERRED REGISTER

        //dropSelf(ModBlocks.SOUL_STONE_ORE.get());

        add(ModBlocks.SENSUS_ORE.get(),
                block -> createOreDrop(ModBlocks.SENSUS_ORE.get(), ModItems.UNREFINED_SENSUS.get()));
        add(ModBlocks.DEEPSLATE_SENSUS_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SENSUS_ORE.get(), ModItems.UNREFINED_SENSUS.get()));
        add(ModBlocks.SENSUS_FIRE.get(),
                block -> createSingleItemTable(ModItems.SENSUS));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

package com.github.Wery848.unscrupulous.block;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    // DeferredRegister for Blocks
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UnscrupulousMod.MODID);

    // Registry Blocks
    public static final DeferredBlock<Block> SOUL_STONE_ORE = registerBlockAndItem("soul_stone_ore",
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
                    );

    public static final DeferredBlock<Block> DEEPSLATE_SOUL_STONE_ORE = registerBlockAndItem("deepslate_soul_stone_ore",
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(4.5f, 3.0f)
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
    );

    // Utility Methods
    // New and improved helper method
    private static DeferredBlock<Block> registerBlockAndItem(String name, BlockBehaviour.Properties props) {
        DeferredBlock<Block> ret = BLOCKS.registerBlock(
            name,
            Block::new,
            props
        );
        ModItems.ITEMS.registerSimpleBlockItem(ret);
        return ret;
    }

    // Registers the BLOCKS deferredregister
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

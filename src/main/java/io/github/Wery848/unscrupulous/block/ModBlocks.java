package io.github.Wery848.unscrupulous.block;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import io.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    // DeferredRegister for Blocks
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UnscrupulousMod.MODID);

    // Registry Blocks
    public static final DeferredBlock<Block> SENSUS_ORE = registerBlockAndItem("sensus_ore",
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
                    );

    public static final DeferredBlock<Block> DEEPSLATE_SENSUS_ORE = registerBlockAndItem("deepslate_sensus_ore",
            BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(4.5f, 3.0f)
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
    );

    public static final DeferredBlock<Block> SENSUS_FIRE = BLOCKS.registerBlock("sensus_fire", SensusFire::new,
            BlockBehaviour.Properties.of().noOcclusion()
                    .strength(-1.0F, 3600000.0F).mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().lightLevel((p_50755_) -> 10).sound(SoundType.WOOL).pushReaction(PushReaction.BLOCK).forceSolidOn());


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

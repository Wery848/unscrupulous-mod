package com.github.Wery848.unscrupulous;

import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.item.ModItems;
import com.github.Wery848.unscrupulous.item.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UnscrupulousCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnscrupulousMod.MODID);


    public static final Supplier<CreativeModeTab> CREATIVE_TAB =
            CREATIVE_MODE_TAB.register("unscrupulous_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOUL_APPLE.get()))
                            .title(Component.translatable("creativetab.unscrupulous.unscrupulous_things"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.SOUL_APPLE);
                                output.accept(ModBlocks.SOUL_STONE_ORE);
                                output.accept(ModBlocks.DEEPSLATE_SOUL_STONE_ORE);
                                output.accept(ModItems.SOUL_STONE);
                            })


                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}

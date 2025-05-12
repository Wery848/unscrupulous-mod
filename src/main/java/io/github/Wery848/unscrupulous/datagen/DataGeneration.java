package io.github.Wery848.unscrupulous.datagen;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = UnscrupulousMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherServerdata(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        var gen = event.getGenerator();
        var output = gen.getPackOutput();
        var lookup = event.getLookupProvider();

        // Register server-side providers
        event.addProvider(new ModdedRecipeProvider.Runner(output, lookup));
        event.addProvider(new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookup));
        event.createProvider(BlockTagProvider::new);



    }

    @SubscribeEvent
    public static void gatherClientdata(GatherDataEvent.Client event) {
        // Register client-side providers
        event.createProvider(ModModelProvider::new);
        event.createDatapackRegistryObjects(DatapackProvider.buildDatapackRegistries());
    }
}

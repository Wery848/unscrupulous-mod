package com.github.Wery848.unscrupulous.events;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.item.ModItems;
import com.github.Wery848.unscrupulous.item.ModPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = UnscrupulousMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    // Brewing Recipe for Soulfire Potion
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(ModPotions.SENSUS_SOLUTION, ModItems.BOTTLED_FLAME.get(), ModPotions.SENSUS_POTION);
        builder.addMix(Potions.WATER, ModItems.REFINED_SENSUS.get(), ModPotions.SENSUS_SOLUTION);
    }


}

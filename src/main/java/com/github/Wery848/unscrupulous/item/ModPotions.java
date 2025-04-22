package com.github.Wery848.unscrupulous.item;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, UnscrupulousMod.MODID);

    public static final Holder<Potion> SOUL_FIRE_POTION = POTIONS.register("soul_burn_fire_potion",
            () -> new Potion("soul_burn_fire_potion", new MobEffectInstance(ModEffects.SOUL_BURN_EFFECT, 1000, 0)));

    public static void register(IEventBus bus) {
        POTIONS.register(bus);
    }

}

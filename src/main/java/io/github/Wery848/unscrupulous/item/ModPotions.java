package io.github.Wery848.unscrupulous.item;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import io.github.Wery848.unscrupulous.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, UnscrupulousMod.MODID);

    public static final Holder<Potion> SENSUS_POTION = POTIONS.register("sensus_fire_potion",
            () -> new Potion("sensus_fire_potion", new MobEffectInstance(ModEffects.SENSUS_BURN_EFFECT, 200, 0)));
    public static final Holder<Potion> SENSUS_SOLUTION = POTIONS.register("sensus_solution",
            () -> new Potion("sensus_solution"));

    public static void register(IEventBus bus) {
        POTIONS.register(bus);
    }

}

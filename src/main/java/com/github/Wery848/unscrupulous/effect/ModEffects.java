package com.github.Wery848.unscrupulous.effect;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, UnscrupulousMod.MODID);

    public static Holder<MobEffect> SOUL_BURN_EFFECT = MOB_EFFECTS.register("soulburn",
            () -> new SoulBurnEffect(MobEffectCategory.HARMFUL, 0x000000).addAttributeModifier(Attributes.BURNING_TIME,
                    ResourceLocation.fromNamespaceAndPath(UnscrupulousMod.MODID, "soulburn"), 5.0f,
                    AttributeModifier.Operation.ADD_VALUE));

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}

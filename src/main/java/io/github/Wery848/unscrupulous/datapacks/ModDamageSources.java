package io.github.Wery848.unscrupulous.datapacks;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class ModDamageSources {
    public static final ResourceKey<DamageType> SENSUS_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(UnscrupulousMod.MODID, "sensus_damage"));

    public static DamageSource sensusDamage(Entity causer) {
        return new DamageSource(
                causer.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(SENSUS_DAMAGE));
    }
}


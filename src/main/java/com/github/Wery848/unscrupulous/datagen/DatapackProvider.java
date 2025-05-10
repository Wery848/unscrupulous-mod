package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.datapacks.ModDamageSources;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;

public class DatapackProvider {
    public static RegistrySetBuilder buildDatapackRegistries() {
        return new RegistrySetBuilder()
                .add(Registries.DAMAGE_TYPE, bootstrap -> {
                    bootstrap.register(ModDamageSources.SENSUS_DAMAGE, new DamageType(ModDamageSources.SENSUS_DAMAGE.location().getPath(),
                            DamageScaling.NEVER,
                            0.1f,
                            DamageEffects.BURNING,
                            DeathMessageType.DEFAULT));
                });
    }
}

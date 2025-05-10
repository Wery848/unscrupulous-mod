package com.github.Wery848.unscrupulous.effect;

import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.datapacks.ModDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class SensusEffect extends MobEffect {

    public SensusEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity livingEntity, int amplifier) {
        livingEntity.hurtServer(level, ModDamageSources.sensusDamage(livingEntity), 2);

        BlockPos blockpos = livingEntity.blockPosition();
        if(!livingEntity.isInLiquid() && !livingEntity.isInPowderSnow && !level.isClientSide()) {
            level.setBlockAndUpdate(blockpos, ModBlocks.SENSUS_FIRE.get().defaultBlockState());
            //System.out.println("Position fire placed: X = " + livingEntity.blockPosition().getX() + "; Y = " + livingEntity.blockPosition().getY() + "; Z = " + livingEntity.blockPosition().getZ());
        }
        return super.applyEffectTick(level, livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

package com.github.Wery848.unscrupulous.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Blocks;

public class SoulBurnEffect extends MobEffect {

    public SoulBurnEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity livingEntity, int amplifier) {
        livingEntity.removeEffect(MobEffects.FIRE_RESISTANCE);
        livingEntity.setRemainingFireTicks(20);
        if(!livingEntity.isInLiquid() && !livingEntity.isInPowderSnow) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(livingEntity.blockPosition(), Blocks.FIRE.defaultBlockState());
                System.out.println("Position fire placed: X = " + livingEntity.blockPosition().getX() + "; Y = " + livingEntity.blockPosition().getY() + "; Z = " + livingEntity.blockPosition().getZ());
            }
        }

        return super.applyEffectTick(level, livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

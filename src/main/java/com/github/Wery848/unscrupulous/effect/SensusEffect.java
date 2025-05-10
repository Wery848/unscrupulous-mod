package com.github.Wery848.unscrupulous.effect;

import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.datapacks.ModDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SensusEffect extends MobEffect {

    public SensusEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity livingEntity, int amplifier) {
        if(livingEntity instanceof Player) {
            livingEntity.hurtServer(level, ModDamageSources.sensusDamage(livingEntity), 1);

            BlockPos blockpos = livingEntity.blockPosition();
            if (!livingEntity.isInLiquid() && !livingEntity.isInPowderSnow && !level.isClientSide()) {
                level.setBlockAndUpdate(blockpos, ModBlocks.SENSUS_FIRE.get().defaultBlockState());
            }
        }
        else {
            livingEntity.removeEffect(ModEffects.SENSUS_BURN_EFFECT);
        }
        return super.applyEffectTick(level, livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

package io.github.Wery848.unscrupulous.effect;

import io.github.Wery848.unscrupulous.attached_data.SensusStat;
import io.github.Wery848.unscrupulous.block.ModBlocks;
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
            Player player = (Player) livingEntity;

            BlockPos blockpos = livingEntity.blockPosition();
            if (!level.isClientSide && SensusStat.playerHasSensus(player)) {
                if(level.setBlockAndUpdate(blockpos, ModBlocks.SENSUS_FIRE.get().defaultBlockState())) {
                    SensusStat.changePlayerSensus(player, -1);
                }
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

    private boolean canPlaceSensusFire(ServerLevel level, Player player) {
        return !level.isClientSide() && !player.isInLiquid() && !player.isInPowderSnow;
    }

}

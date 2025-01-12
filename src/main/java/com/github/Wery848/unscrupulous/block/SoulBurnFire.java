package com.github.Wery848.unscrupulous.block;

import com.github.Wery848.unscrupulous.effect.ModEffects;
import com.github.Wery848.unscrupulous.effect.SoulBurnEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SoulBurnFire extends BaseFireBlock {
    public static final MapCodec<SoulBurnFire> CODEC = simpleCodec(SoulBurnFire::new);

    public SoulBurnFire(Properties properties) {
        super(properties, 2.0f);
    }

    @Override
    protected MapCodec<SoulBurnFire> codec() {
        return CODEC;
    }

    @Override
    protected boolean canBurn(BlockState blockState) {
        return true;
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader levelRead, ScheduledTickAccess schedTick, BlockPos pos, Direction dir, BlockPos pos2, BlockState p_60543_, RandomSource p_374120_) {
        return this.canSurvive(state, levelRead, pos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addEffect(new MobEffectInstance(ModEffects.SOUL_BURN_EFFECT, 5));
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return level.getBlockState(blockpos).isFaceSturdy(level, blockpos, Direction.UP) || this.isValidFireLocation(level, pos);
    }

    private boolean isValidFireLocation(BlockGetter level, BlockPos pos) {
        for(Direction direction : Direction.values()) {
            if (level.getBlockState(pos).isFlammable(level, pos.relative(direction), direction.getOpposite())) {
                return true;
            }
        }

        return false;
    }

}

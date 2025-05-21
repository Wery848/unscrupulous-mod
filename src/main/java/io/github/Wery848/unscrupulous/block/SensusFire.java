package io.github.Wery848.unscrupulous.block;

import io.github.Wery848.unscrupulous.effect.ModEffects;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.redstone.Orientation;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;

public class SensusFire extends BaseFireBlock {
    public static final MapCodec<SensusFire> CODEC = simpleCodec(SensusFire::new);

    public SensusFire(Properties properties) {
        super(properties, 0.0f);
        this.registerDefaultState(
                this.defaultBlockState()
                        .setValue(NORTH, false)
                        .setValue(EAST, false)
                        .setValue(SOUTH, false)
                        .setValue(WEST, false)
                        .setValue(UP, false)
        );

    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return super.getFluidState(state);
    }

    @Override
    protected MapCodec<SensusFire> codec() {
        return CODEC;
    }

    @Override
    protected boolean canBurn(BlockState blockState) {
        return true;
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader levelRead, ScheduledTickAccess schedTick, BlockPos pos, Direction dir, BlockPos pos2, BlockState p_60543_, RandomSource p_374120_) {
        return this.canSurvive(state, levelRead, pos) ? this.defaultBlockState() : Blocks.BEDROCK.defaultBlockState();
    }

    @Override
    protected void neighborChanged(BlockState p_60509_, Level p_60510_, BlockPos p_60511_, Block p_60512_, @Nullable Orientation p_365159_, boolean p_60514_) {
        //super.neighborChanged(p_60509_, p_60510_, p_60511_, p_60512_, p_365159_, p_60514_);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if(level.getFluidState(pos).is(FluidTags.WATER) || level.getFluidState((pos)).is(FluidTags.LAVA)) {
            return;
        }

        //super.onPlace(state, level, pos, oldState, isMoving);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(new MobEffectInstance(ModEffects.SENSUS_BURN_EFFECT, 60)); // 20 = 1 sec
        }
        //super.entityInside(state, level, pos, entity);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        //BlockPos blockpos = pos.below();
        return true;//level.getBlockState(blockpos).isFaceSturdy(level, blockpos, Direction.UP) || this.isValidFireLocation(level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP);
    }
}

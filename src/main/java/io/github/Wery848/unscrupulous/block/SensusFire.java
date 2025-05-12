package io.github.Wery848.unscrupulous.block;

import io.github.Wery848.unscrupulous.effect.ModEffects;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
    protected MapCodec<SensusFire> codec() {
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
        if(entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(new MobEffectInstance(ModEffects.SENSUS_BURN_EFFECT, 10));
        }
        //super.entityInside(state, level, pos, entity);
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP);
    }
}

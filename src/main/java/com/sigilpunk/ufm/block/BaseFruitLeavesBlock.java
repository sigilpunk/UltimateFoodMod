package com.sigilpunk.ufm.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import com.sigilpunk.ufm.registry.ModSounds;

import java.util.function.Supplier;

public class BaseFruitLeavesBlock extends LeavesBlock implements BonemealableBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    private final Supplier<Item> fruitItem;

    // tuning knobs for future trees
    private final int maxAge;
    private final int fruitStartAge;
    private final int harvestResetAge;

    public BaseFruitLeavesBlock(BlockBehaviour.Properties props,
                                Supplier<Item> fruitItem) {
        this(props, fruitItem, 3, 2, 1);
    }

    public BaseFruitLeavesBlock(BlockBehaviour.Properties props,
                                Supplier<Item> fruitItem,
                                int maxAge,
                                int fruitStartAge,
                                int harvestResetAge) {
        super(props);
        this.fruitItem = fruitItem;
        this.maxAge = maxAge;
        this.fruitStartAge = fruitStartAge;
        this.harvestResetAge = harvestResetAge;

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(DISTANCE, 7)
                        .setValue(PERSISTENT, false)
                        .setValue(WATERLOGGED, false)
                        .setValue(AGE, 0)
        );
    }

    /* -------------------- STATE -------------------- */

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AGE);
    }

    /* -------------------- GROWTH -------------------- */

    protected boolean isOuterLeaf(BlockState state) {
        return state.getValue(DISTANCE) >= 3;
    }

    protected boolean isPartOfTree(ServerLevel level, BlockPos pos) {
        int radius = 4;

        for (BlockPos checkPos : BlockPos.betweenClosed(
                pos.offset(-radius, -radius, -radius),
                pos.offset(radius, radius, radius))) {

            BlockState state = level.getBlockState(checkPos);

            if (state.is(net.minecraft.tags.BlockTags.LOGS)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void randomTick(BlockState state,
                              ServerLevel level,
                              BlockPos pos,
                              RandomSource random) {

        super.randomTick(state, level, pos, random);

        int age = state.getValue(AGE);

//        if (!isOuterLeaf(state, level, pos)) return;
        if (!isPartOfTree(level, pos)) return;
        if(!isOuterLeaf(state)) return;

        if (age < maxAge && random.nextInt(8) == 0) {
            level.setBlock(pos, state.setValue(AGE, age + 1), 2);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    /* -------------------- HARVEST -------------------- */

    @Override
    protected InteractionResult useWithoutItem(BlockState state,
                                               Level level,
                                               BlockPos pos,
                                               Player player,
                                               BlockHitResult hit) {

        int age = state.getValue(AGE);

        if (age >= fruitStartAge) {

            if (!level.isClientSide) {

                int yield = calculateYield(age);

                popResource(level, pos, new ItemStack(fruitItem.get(), yield));

                level.setBlock(pos, state.setValue(AGE, harvestResetAge), 2);
            }
            SoundEvent sound = level.random.nextBoolean()
                    ? ModSounds.FRUIT_PICK_1.get()
                    : ModSounds.FRUIT_PICK_2.get();

            level.playSound(
                    null,
                    pos,
                    ModSounds.FRUIT_PICK_1.get(),
                    net.minecraft.sounds.SoundSource.BLOCKS,
                    1.0F,
                    1.0F
            );
            level.levelEvent(2011, pos, 0); // leaf break particles

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    protected int calculateYield(int age) {
        return 1 + (age - fruitStartAge);
    }

    /* -------------------- BONEMEAL -------------------- */

    @Override
    public boolean isValidBonemealTarget(LevelReader level,
                                         BlockPos pos,
                                         BlockState state) {
        return state.getValue(AGE) < maxAge;
    }

    @Override
    public boolean isBonemealSuccess(Level level,
                                     RandomSource random,
                                     BlockPos pos,
                                     BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level,
                                RandomSource random,
                                BlockPos pos,
                                BlockState state) {

        if(!isPartOfTree(level, pos)) return;

        int age = state.getValue(AGE);

        int growth = 1 + random.nextInt(2);

        int newAge = Math.min(maxAge, age + growth);

        level.setBlock(pos, state.setValue(AGE, newAge), 2);
    }
}
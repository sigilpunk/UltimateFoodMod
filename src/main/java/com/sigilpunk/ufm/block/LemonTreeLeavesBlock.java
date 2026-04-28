package com.sigilpunk.ufm.block;

import com.mojang.serialization.MapCodec;
import com.sigilpunk.ufm.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class LemonTreeLeavesBlock extends BaseFruitLeavesBlock {

    public static final MapCodec<LemonTreeLeavesBlock> CODEC =
            simpleCodec(LemonTreeLeavesBlock::new);

    public LemonTreeLeavesBlock(BlockBehaviour.Properties props) {
        super(props, ModItems.LEMON);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//        System.out.println("LEMON TICK @ " + pos);
//        level.levelEvent(2005, pos, 0);
        super.randomTick(state, level, pos, random);
    }

    @Override
    public MapCodec<LemonTreeLeavesBlock> codec() {
        return CODEC;
    }
}
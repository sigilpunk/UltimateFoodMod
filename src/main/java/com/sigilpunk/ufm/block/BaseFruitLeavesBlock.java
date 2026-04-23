package com.sigilpunk.ufm.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class BaseFruitLeavesBlock extends LeavesBlock {

    private final Supplier<Item> fruitItem;

    public BaseFruitLeavesBlock(BlockBehaviour.Properties props,
                                Supplier<Item> fruitItem) {
        super(props);
        this.fruitItem = fruitItem;
    }

    @Override
    protected void randomTick(net.minecraft.world.level.block.state.BlockState state,
                              ServerLevel level,
                              BlockPos pos,
                              RandomSource random) {
        super.randomTick(state, level, pos, random);

        if (random.nextInt(12) == 0) {
            popResource(level, pos, fruitItem.get().getDefaultInstance());
        }
    }
}
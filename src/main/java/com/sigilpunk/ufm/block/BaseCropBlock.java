package com.sigilpunk.ufm.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.function.Supplier;

public class BaseCropBlock extends CropBlock {
    private final Supplier<ItemLike> seedItem;
    private final int maxAge;

    public BaseCropBlock(BlockBehaviour.Properties props, Supplier<ItemLike> seedItem, int maxAge) {
        super(props);
        this.seedItem = seedItem;
        this.maxAge = maxAge;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seedItem.get();
    }

    @Override
    public int getMaxAge() {
        return this.maxAge;
    }
}
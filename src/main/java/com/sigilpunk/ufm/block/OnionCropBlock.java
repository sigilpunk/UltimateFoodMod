package com.sigilpunk.ufm.block;

import com.sigilpunk.ufm.registry.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OnionCropBlock extends CropBlock {

    public OnionCropBlock(BlockBehaviour.Properties props) {
        super(props);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.ONION.get();
    }

    @Override
    public int getMaxAge() {
        return 3;
    }
}
package com.sigilpunk.ufm.block;

import com.sigilpunk.ufm.registry.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class RedOnionCropBlock extends CropBlock {

    public RedOnionCropBlock(Properties props) {
        super(props);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RED_ONION.get();
    }

    @Override
    public int getMaxAge() {
        return 3;
    }
}
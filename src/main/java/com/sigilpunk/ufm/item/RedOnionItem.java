package com.sigilpunk.ufm.item;

import com.sigilpunk.ufm.registry.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;

public class RedOnionItem extends BlockItem {
    public RedOnionItem(Properties props) {
        super(ModBlocks.RED_ONION_CROP.get(), props.food(
                new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationModifier(0.3f)
                        .build()));
    }

    @Override
    public String getDescriptionId() {
        return "item.ufm.red_onion";
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Block clicked = context.getLevel()
                .getBlockState(context.getClickedPos()).getBlock();
        if (clicked instanceof FarmBlock) {
            return super.useOn(context);
        }
        return InteractionResult.PASS;
    }
}

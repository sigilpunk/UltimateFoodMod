package com.sigilpunk.ufm.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.food.FoodProperties;
import com.sigilpunk.ufm.registry.ModBlocks;

public class OnionItem extends BlockItem {
    public OnionItem(Item.Properties props) {
        super(ModBlocks.ONION_CROP.get(), props.food(
                new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationModifier(0.3f)
                        .build()));
    }

    @Override
    public String getDescriptionId() {
        return "item.ultimatefoodmod.onion";
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

package com.sigilpunk.ufm.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.food.FoodProperties;

public class LemonItem extends Item {

    public LemonItem(Properties props) {
        super(props.food(
                new FoodProperties.Builder()
                        .nutrition(1)
                        .saturationModifier(0.2f)
                        .build()
        ));
    }

    @Override
    public String getDescriptionId() {
        return "item.ufm.lemon";
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }
}
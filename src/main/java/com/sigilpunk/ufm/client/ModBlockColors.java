package com.sigilpunk.ufm.client;

import com.sigilpunk.ufm.registry.ModBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.level.FoliageColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBlockColors {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, level, pos, tintIndex) -> {
                    int vanilla = FoliageColor.getDefaultColor();


                    int r = (vanilla >> 16) & 0xFF;
                    int g = (vanilla >> 8) & 0xFF;
                    int b = vanilla & 0xFF;

                    r = Math.min(255, r + 80);
                    g = Math.min(255, g + 10);

                    return (r << 16) | (g << 8) | b;
                },
                ModBlocks.LEMON_TREE_LEAVES.get()
        );
    }
}
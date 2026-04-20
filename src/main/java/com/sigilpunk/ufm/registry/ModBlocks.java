package com.sigilpunk.ufm.registry;

import com.sigilpunk.ufm.UltimateFoodMod;
import com.sigilpunk.ufm.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UltimateFoodMod.MODID);

    public static final DeferredBlock<Block> MJ_BLOCK =
            BLOCKS.registerSimpleBlock("mjblock",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(1.5f, 6.0f));


    public static final DeferredBlock<OnionCropBlock> ONION_CROP =
            BLOCKS.registerBlock("onion_crop", OnionCropBlock::new,
                    BlockBehaviour.Properties.of()
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .replaceable()
                            .sound(SoundType.CROP));

    public static final DeferredBlock<OnionCropBlock> RED_ONION_CROP =
            BLOCKS.registerBlock("red_onion_crop", OnionCropBlock::new,
                    BlockBehaviour.Properties.of()
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .replaceable()
                            .sound(SoundType.CROP));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
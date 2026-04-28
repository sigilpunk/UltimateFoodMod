package com.sigilpunk.ufm.registry;

import com.sigilpunk.ufm.UltimateFoodMod;
import com.sigilpunk.ufm.block.*;
import com.sigilpunk.ufm.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UltimateFoodMod.MODID);

    public static BlockBehaviour.@NotNull Properties getCropProperties() {
        return BlockBehaviour.Properties.of()
                .noCollission()
                .randomTicks()
                .instabreak()
                .replaceable()
                .sound(SoundType.CROP);
    }

    public static final DeferredBlock<Block> MJ_BLOCK =
            BLOCKS.registerSimpleBlock("mjblock",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(1.5f, 6.0f));


    public static final DeferredBlock<BaseCropBlock> ONION_CROP =
            BLOCKS.registerBlock("onion_crop",
                    props -> new BaseCropBlock(props, ModItems.ONION::get, 3),
                    BlockBehaviour.Properties.of()
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .replaceable()
                            .sound(SoundType.CROP));

    public static final DeferredBlock<BaseCropBlock> RED_ONION_CROP =
            BLOCKS.registerBlock("red_onion_crop",
                    props -> new BaseCropBlock(props, ModItems.RED_ONION::get, 3),
                    BlockBehaviour.Properties.of()
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .replaceable()
                            .sound(SoundType.CROP));

    public static final DeferredBlock<Block> LEMONWOOD_LOG = BLOCKS.register("lemonwood_log",
            () -> new LemonwoodLogBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2f)));

    public static final DeferredBlock<Block> STRIPPED_LEMONWOOD_LOG = BLOCKS.register("stripped_lemonwood_log",
            () -> new LemonwoodLogBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2f)));

    public static final DeferredBlock<Block> LEMONWOOD_WOOD =
            BLOCKS.registerSimpleBlock("lemonwood_wood",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(2.0f)
                            .sound(SoundType.WOOD));

    public static final DeferredBlock<Block> LEMONWOOD_PLANK =
            BLOCKS.registerSimpleBlock("lemonwood_planks",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(2.0f)
                            .sound(SoundType.WOOD));

    public static final DeferredBlock<LemonTreeLeavesBlock> LEMON_TREE_LEAVES =
            BLOCKS.registerBlock("lemon_tree_leaves",
                    props -> new LemonTreeLeavesBlock(props),
                    BlockBehaviour.Properties.of()
                            .strength(0.2f)
                            .randomTicks()
                            .sound(SoundType.CHERRY_LEAVES)
                            .noOcclusion());

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
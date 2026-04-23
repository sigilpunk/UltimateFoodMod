package com.sigilpunk.ufm.registry;

import com.sigilpunk.ufm.item.*;
import com.sigilpunk.ufm.UltimateFoodMod;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(UltimateFoodMod.MODID);

    public static final DeferredItem<BlockItem> ONION =
            ITEMS.registerItem("onion", OnionItem::new);
    public static final DeferredItem<BlockItem> RED_ONION =
            ITEMS.registerItem("red_onion", RedOnionItem::new);

    public static final DeferredItem<BlockItem> MJ_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.MJ_BLOCK);

    public static final DeferredItem<Item> LEMON =
            ITEMS.registerSimpleItem("lemon");

    public static final DeferredItem<BlockItem> LEMONWOOD_LOG_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.LEMONWOOD_LOG);

    public static final DeferredItem<BlockItem> LEMONWOOD_STRIPPED_LOG_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.LEMONWOOD_STRIPPED_LOG);

    public static final DeferredItem<BlockItem> LEMONWOOD_WOOD_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.LEMONWOOD_WOOD);

    public static final DeferredItem<BlockItem> LEMONWOOD_PLANKS_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.LEMONWOOD_PLANK);

    public static final DeferredItem<BlockItem> LEMON_TREE_LEAVES_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.LEMON_TREE_LEAVES);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
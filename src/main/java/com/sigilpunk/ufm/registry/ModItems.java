package com.sigilpunk.ufm.registry;

import com.sigilpunk.ufm.item.OnionItem;
import com.sigilpunk.ufm.UltimateFoodMod;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(UltimateFoodMod.MODID);

    public static final DeferredItem<BlockItem> ONION =
            ITEMS.registerItem("onion", OnionItem::new);

    public static final DeferredItem<BlockItem> MJ_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.MJ_BLOCK);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
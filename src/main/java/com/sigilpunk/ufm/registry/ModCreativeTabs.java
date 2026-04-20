package com.sigilpunk.ufm.registry;

import com.sigilpunk.ufm.UltimateFoodMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UltimateFoodMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UFM_TAB_BLOCKS =
            CREATIVE_MODE_TABS.register("ufm_tab_blocks", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ufm.blocks"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.MJ_BLOCK_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.MJ_BLOCK_ITEM.get());
                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UFM_TAB_FOOD =
            CREATIVE_MODE_TABS.register("ufm_tab_food", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ufm.food"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.ONION.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ONION.get());
                        output.accept(ModItems.RED_ONION.get());
                    }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
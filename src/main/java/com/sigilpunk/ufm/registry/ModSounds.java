package com.sigilpunk.ufm.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, "ufm");

    public static final DeferredHolder<SoundEvent, SoundEvent> FRUIT_PICK_1 =
            SOUND_EVENTS.register("fruit_tree.pick_1",
                    () -> SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath("ufm", "fruit_tree/pick_1")
                    )
            );

    public static final DeferredHolder<SoundEvent, SoundEvent> FRUIT_PICK_2 =
            SOUND_EVENTS.register("fruit_tree.pick_2",
                    () -> SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath("ufm", "fruit_tree/pick_2")
                    )
            );
}
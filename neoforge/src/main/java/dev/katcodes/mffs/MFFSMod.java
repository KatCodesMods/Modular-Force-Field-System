// SPDX-FileCopyrightText: 2024 GaeaKat
//
// SPDX-License-Identifier: MIT

package dev.katcodes.mffs;


import dev.katcodes.mffs.common.blocks.ModBlocks;
import dev.katcodes.mffs.common.items.ModItems;
import dev.katcodes.mffs.common.utils.MFFSRegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.Collection;
import java.util.function.Supplier;

@Mod(Constants.MOD_ID)
public class MFFSMod {

    public MFFSMod(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();
        eventBus.register(this);


    }

    @SubscribeEvent
    public void register(RegisterEvent event) {
        event.register(
                BuiltInRegistries.BLOCK.key(),
                registry -> {
                    ModBlocks.bootStrap().forEach(block ->
                            {
                                registry.register(block.id(), block.Object());
                            }
                    );
                });
        event.register(
                BuiltInRegistries.ITEM.key(),
                registry -> {
                    ModItems.makeBlockItems();
                    ModItems.bootStrap().forEach(item ->
                            registry.register(item.id(),item.Object()));
                }
        );
    }
}
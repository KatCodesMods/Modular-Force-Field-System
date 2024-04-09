// SPDX-FileCopyrightText: 2024 GaeaKat
//
// SPDX-License-Identifier: MIT

package dev.katcodes.mffs;

import dev.katcodes.mffs.common.blocks.ModBlocks;
import dev.katcodes.mffs.common.items.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

@Mod(Constants.MOD_ID)
public class MFFSMod {
    
    public MFFSMod() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        FMLJavaModLoadingContext.get().getModEventBus().register(this);

    }

    @SubscribeEvent
    public void register(@NotNull RegisterEvent event) {
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
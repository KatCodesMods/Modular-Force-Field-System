// SPDX-FileCopyrightText: 2024 GaeaKat
//
// SPDX-License-Identifier: MIT

package dev.katcodes.mffs;

import dev.katcodes.mffs.common.blocks.ModBlocks;
import dev.katcodes.mffs.common.items.ModItems;
import dev.katcodes.mffs.common.utils.MFFSRegistryObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Collection;

public class MFFSMod implements ModInitializer {

    public static final ResourceKey<PlacedFeature> MONAZIT_ORE_PLACED_KEY=ResourceKey.create(Registries.PLACED_FEATURE,new ResourceLocation(Constants.MOD_ID,"monazit_ore"));
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        registryBootStrap();
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES,MONAZIT_ORE_PLACED_KEY);
    }

    private void registryBootStrap() {
        register(BuiltInRegistries.BLOCK, ModBlocks.bootStrap());
        ModItems.makeBlockItems();
        register(BuiltInRegistries.ITEM, ModItems.bootStrap());
    }
    public static <T> void register(Registry<T> registry, Collection<MFFSRegistryObject<T>> objects) {
        for (MFFSRegistryObject<T> object : objects) {
            Registry.register(registry, object.id(), object.Object());
        }
    }
}

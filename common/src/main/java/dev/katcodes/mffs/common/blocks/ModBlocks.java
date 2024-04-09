// SPDX-FileCopyrightText: 2024 GaeaKat
//
// SPDX-License-Identifier: MIT
package dev.katcodes.mffs.common.blocks;

import dev.katcodes.mffs.Constants;
import dev.katcodes.mffs.common.utils.MFFSRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModBlocks {
    private static final List<MFFSRegistryObject<Block>> BLOCKS = new ArrayList<>();

    public static Block createBlock(Block block, ResourceLocation id) {
        BLOCKS.add(new MFFSRegistryObject<>(block,id));
        return block;
    }
    public static Collection<MFFSRegistryObject<Block>> bootStrap() {
        return BLOCKS;
    }
    public static Block MONAZIT_ORE= createBlock(new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5F,6.0F)),new ResourceLocation(Constants.MOD_ID,"monazit_ore"));


}

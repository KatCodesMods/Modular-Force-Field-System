// SPDX-FileCopyrightText: 2024 GaeaKat
//
// SPDX-License-Identifier: MIT

package dev.katcodes.mffs.common.items;

import dev.katcodes.mffs.Constants;
import dev.katcodes.mffs.common.blocks.ModBlocks;
import dev.katcodes.mffs.common.utils.MFFSRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModItems {

    private static final List<MFFSRegistryObject<Item>> ITEMS = new ArrayList<>();


    /**
     * Monazit Item
     */
    @SuppressWarnings("unused")
    public static final Item MONAZIT=createItem(new Item((new Item.Properties())),new ResourceLocation(Constants.MOD_ID,"monazit"));

    public static Item createItem(Item item, ResourceLocation id) {
        ITEMS.add(new MFFSRegistryObject<>(item,id));
        return item;
    }

    public static void makeBlockItems() {
        for(MFFSRegistryObject<Block> blockMFFSRegistryObject: ModBlocks.bootStrap()) {
            Item.Properties properties= new Item.Properties();
            createItem(new BlockItem(blockMFFSRegistryObject.Object(),properties),blockMFFSRegistryObject.id());
        }
    }
    public static Collection<MFFSRegistryObject<Item>> bootStrap() {
        return ITEMS;
    }
}

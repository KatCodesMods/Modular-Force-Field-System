// SPDX-FileCopyrightText: 2024 GaeaKat
//
// SPDX-License-Identifier: MIT

package dev.katcodes.mffs.common.utils;

import net.minecraft.resources.ResourceLocation;

public record MFFSRegistryObject<T>(T Object, ResourceLocation id) {
}

package com.nyfaria.nyfsmultiloadertest;

import com.nyfaria.nyfsmultiloadertest.init.BlockInit;
import com.nyfaria.nyfsmultiloadertest.init.EntityInit;
import com.nyfaria.nyfsmultiloadertest.init.ItemInit;
import com.nyfaria.nyfsmultiloadertest.init.TagInit;
import com.nyfaria.nyfsmultiloadertest.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

public class CommonClass {

    public static void init() {
        ItemInit.loadClass();
        BlockInit.loadClass();
        EntityInit.loadClass();
        TagInit.loadClass();
    }
}
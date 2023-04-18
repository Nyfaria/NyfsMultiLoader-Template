package com.nyfaria.nyfsdeco.init;

import com.nyfaria.grinnersents.registration.RegistrationProvider;
import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsdeco.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);

    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }

    public static void loadClass() {
    }
}

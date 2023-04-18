package com.nyfaria.nyfsdeco.event;

import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.init.ItemInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Constants.MODID)
public class ClientModEvents {
    @SubscribeEvent
    public static void creativeTab(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            ItemInit.ITEMS.getEntries().stream()
                    .map(ro -> new ItemStack(ro.get()))
                    .forEach(event::accept);
        }
    }
}

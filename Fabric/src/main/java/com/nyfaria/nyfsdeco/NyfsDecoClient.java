package com.nyfaria.nyfsdeco;

import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsdeco.init.BlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;

public class NyfsDecoClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.BLOCKS_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> !(item instanceof CarpetBlock) && !(item instanceof StairBlock) && !(item instanceof SlabBlock) && !(item instanceof TrapDoorBlock) && !(item instanceof ButtonBlock) && !(item instanceof FenceBlock) && !(item instanceof FenceGateBlock) && !(item instanceof PressurePlateBlock) && !(item instanceof WallBlock))
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.SLABS_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof SlabBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.STAIRS_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof StairBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.CARPET_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof CarpetBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.WALLS_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof WallBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.BUTTONS_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof ButtonBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.FENCES_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof FenceBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.FENCE_GATES_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof FenceGateBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.PRESSURE_PLATES_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof PressurePlateBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
        ItemGroupEvents.modifyEntriesEvent(NyfsDeco.TRAPDOORS_TAB).register((tab) -> {
            tab.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof TrapDoorBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        });
    }
}

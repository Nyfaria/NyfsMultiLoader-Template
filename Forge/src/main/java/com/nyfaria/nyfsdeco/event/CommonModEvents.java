package com.nyfaria.nyfsdeco.event;

import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsdeco.CommonClass;
import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.init.BlockInit;
import com.nyfaria.nyfsdeco.init.EntityInit;
import com.nyfaria.nyfsdeco.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {


    @SubscribeEvent
    public static void attribs(EntityAttributeCreationEvent e) {
        EntityInit.attributeSuppliers.forEach(p -> e.put(p.entityTypeSupplier().get(), p.factory().get().build()));
    }

    @SubscribeEvent
    public static void registerTab(CreativeModeTabEvent.Register event){
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"blocks"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.blocks")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getBlock().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                            .filter(item -> !(item instanceof CarpetBlock) && !(item instanceof StairBlock) && !(item instanceof SlabBlock) && !(item instanceof PressurePlateBlock) && !(item instanceof ButtonBlock) && !(item instanceof TrapDoorBlock) && !(item instanceof FenceBlock) && !(item instanceof FenceGateBlock) && !(item instanceof WallBlock))
                            .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"slabs"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.slabs")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getSlab().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                            .filter(item -> item instanceof SlabBlock)
                            .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID, "stairs"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.stairs")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getStairs().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                            .filter(item -> item instanceof StairBlock)
                            .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"carpet"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.carpet")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getCarpet().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                            .filter(item -> item instanceof CarpetBlock)
                            .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"pressure_plates"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.pressure_plates")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getPressurePlate().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof PressurePlateBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"buttons"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.buttons")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getButton().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof ButtonBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"trapdoors"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.trapdoors")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getTrapdoor().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof TrapDoorBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"fences"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.fences")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getFence().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof FenceBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"gates"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.gates")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getFenceGate().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof FenceGateBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));
        event.registerCreativeModeTab(new ResourceLocation(Constants.MODID,"walls"), tab-> tab.title(Component.translatable("itemGroup.nyfsdeco.walls")).icon(()-> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getWall().get())).displayItems((featureFlagSet, output, flag)->{
            output.acceptAll(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .filter(item -> item instanceof WallBlock)
                    .map(item->item.asItem().getDefaultInstance())
                    .toList());
        }));




    }
}

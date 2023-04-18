package com.nyfaria.nyfsdeco;

import com.nyfaria.nyfsdeco.init.BlockInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.impl.client.itemgroup.FabricCreativeGuiComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class NyfsDeco implements ModInitializer {
    public static final CreativeModeTab BLOCKS_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "blocks"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getBlock().get()))
            .build();
    public static final CreativeModeTab SLABS_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "slabs"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getSlab().get()))
            .build();
    public static final CreativeModeTab STAIRS_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "stairs"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getStairs().get()))
            .build();
    public static final CreativeModeTab CARPET_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "carpet"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getCarpet().get()))
            .build();
    public static final CreativeModeTab WALLS_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "walls"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getWall().get()))
            .build();
    public static final CreativeModeTab FENCES_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "fences"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getFence().get()))
            .build();
    public static final CreativeModeTab FENCE_GATES_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "fence_gates"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getFenceGate().get()))
            .build();
    public static final CreativeModeTab BUTTONS_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "buttons"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getButton().get()))
            .build();
    public static final CreativeModeTab PRESSURE_PLATES_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "pressure_plates"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getPressurePlate().get()))
            .build();
    public static final CreativeModeTab TRAPDOORS_TAB = FabricItemGroup
            .builder(new ResourceLocation(Constants.MODID, "trapdoors"))
            .icon(() -> new ItemStack(BlockInit.RESPAWN_ANCHOR_TOP.getTrapdoor().get()))
            .build();

    @Override
    public void onInitialize() {
        CommonClass.init();
    }
}

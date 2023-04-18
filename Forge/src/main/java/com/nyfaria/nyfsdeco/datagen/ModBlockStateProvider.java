package com.nyfaria.nyfsdeco.datagen;

import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.block.BlockCollection;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // Stream.of(
        //
        //         )
        //         .map(Supplier::get)
        //         .forEach(this::simpleCubeBottomTopBlockState);
        //
        // Stream.of(
        //
        // ).map(Supplier::get)
        //         .forEach(this::simpleBlock);
        BlockCollection.COLLECTIONS
                .forEach(
                        collection -> {
                            if (collection.getSlab() != null) {
                                decoSlab((SlabBlock) collection.getSlab().get(), collection.getBlock() != null ? collection.getBlock().get() : collection.getParentBlock());
                            }
                            if (collection.getStairs() != null) {
                                decoStairsBlock((StairBlock) collection.getStairs().get());
                            }
                            if (collection.getCarpet() != null) {
                                decoCarpetBlock((CarpetBlock) collection.getCarpet().get());
                            }
                            if (collection.getBlock() != null) {
                                decoCubeAll(collection.getBlock().get());
                            }
                            if (collection.getPressurePlate() != null) {
                                decoPressurePlate((PressurePlateBlock) collection.getPressurePlate().get());
                            }
                            if (collection.getButton() != null){
                                decoButton((ButtonBlock) collection.getButton().get());
                            }
                            if(collection.getTrapdoor() != null){
                                decoTrapdoor((TrapDoorBlock) collection.getTrapdoor().get());
                            }
                            if(collection.getFence()!=null){
                                decoFence((FenceBlock) collection.getFence().get());
                            }
                            if(collection.getFenceGate()!=null){
                                decoFenceGate((FenceGateBlock) collection.getFenceGate().get());
                            }
                            if(collection.getWall()!=null){
                                decoWallBlock((WallBlock) collection.getWall().get());
                            }
                        }
                );

    }


    protected void decoCubeAll(Block block) {
        String name = getName(block);
        simpleBlock(block, models().cubeAll(name, mcLoc("block/" + name)).renderType(getRenderType(name)));
    }

    protected void decoSlab(SlabBlock block, Block fullBlock) {
        String name = getName(block).replace("_slab", "");
        slabBlock(block, modLoc("block/" + name), mcLoc("block/" + name), fullBlock);
    }

    public void decoStairsBlock(StairBlock block) {
        String name = getName(block).replace("_stairs", "");
        stairsBlockWithRenderType(block, mcLoc("block/" + name), getRenderType(name));
    }

    protected void decoCarpetBlock(CarpetBlock block) {
        String name = getName(block);
        simpleBlock(block, models().carpet(name, mcLoc("block/" + name.replace("_carpet", ""))).renderType(getRenderType(name)));
    }

    public void decoPressurePlate(PressurePlateBlock block) {
        String name = getName(block);
        pressurePlateBlockWithRenderType(block, mcLoc("block/" + name.replace("_pressure_plate", "")), getRenderType(name));
    }
    public void decoButton(ButtonBlock block) {
        String name = getName(block);
        buttonBlockWithRenderType(block, mcLoc("block/" + name.replace("_button", "")), getRenderType(name));
    }
    public void decoTrapdoor(TrapDoorBlock block) {
        String name = getName(block);
        trapdoorBlockWithRenderType( block, mcLoc("block/" + name.replace("_trapdoor", "")), true, getRenderType(name));
    }
    public void decoFence(FenceBlock block) {
        String name = getName(block);
        fenceBlockWithRenderType(block, mcLoc("block/" + name.replace("_fence", "")), getRenderType(name));
    }
    public void decoFenceGate(FenceGateBlock block) {
        String name = getName(block);
        fenceGateBlockWithRenderType(block, mcLoc("block/" + name.replace("_fence_gate", "")), getRenderType(name));
    }
    public void decoWallBlock(WallBlock block) {
        String name = getName(block);
        wallBlockWithRenderType(block, mcLoc("block/" + name.replace("_wall", "")),getRenderType(name));
    }
    public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture, Block parentBlock) {
        slabBlock(block, ForgeRegistries.BLOCKS.getKey(parentBlock), texture, texture, texture);
    }

    public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        slabBlock(block, models().slab(getName(block), side, bottom, top).renderType(getRenderType(getName(block))), models().slabTop(getName(block) + "_top", side, bottom, top).renderType(getRenderType(getName(block))), models().cubeAll(getName(block) + "_double", mcLoc("block/" + getName(block).replace("_slab", ""))).renderType(getRenderType(getName(block))));
    }

    public ModelFile.UncheckedModelFile getNonExistingFile(ResourceLocation path) {
        ModelFile.UncheckedModelFile ret = new ModelFile.UncheckedModelFile(extendWithFolder(path));
        return ret;
    }

    private ResourceLocation extendWithFolder(ResourceLocation rl) {
        if (rl.getPath().contains("/")) {
            return rl;
        }
        return new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath());
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }

    protected String getRenderType(String name) {
        return name.contains("stained") || name.contains("tinted") ? "translucent" : "cutout";
    }
    public void buttonBlockWithRenderType(ButtonBlock block, ResourceLocation texture, String renderType) {
        ModelFile button = models().button(getName(block), texture).renderType(renderType);
        ModelFile buttonPressed = models().buttonPressed(getName(block) + "_pressed", texture).renderType(renderType);
        buttonBlock(block, button, buttonPressed);
    }
    public void pressurePlateBlockWithRenderType(PressurePlateBlock block, ResourceLocation texture, String renderType) {
        ModelFile pressurePlate = models().pressurePlate(getName(block), texture).renderType(renderType);
        ModelFile pressurePlateDown = models().pressurePlateDown(getName(block) + "_down", texture).renderType(renderType);
        pressurePlateBlock(block, pressurePlate, pressurePlateDown);
    }
}

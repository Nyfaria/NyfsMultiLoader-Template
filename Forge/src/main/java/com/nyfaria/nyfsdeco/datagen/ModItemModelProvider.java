package com.nyfaria.nyfsdeco.datagen;

import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Stream.of()
        //         .map(Supplier::get)
        //         .forEach(this::simpleHandHeldModel);

        // Stream.of()
        //         .map(Supplier::get)
        //         .forEach(this::simpleGeneratedModel);

        BlockInit.BLOCKS.getEntries().stream()
                .map(Supplier::get)
                .forEach(
                        block -> {
                            if (block instanceof ButtonBlock) {
                                buttonInventory(getName(block), mcLoc("block/" + getName(block).replace("_button", "")));
                            } else if (block instanceof TrapDoorBlock) {
                                trapDoorBlock(block);
                            } else if(block instanceof FenceBlock){
                                fenceInventory(getName(block), mcLoc("block/" + getName(block).replace("_fence", "")));
                            } else if(block instanceof FenceGateBlock){
                                fenceGate(getName(block), mcLoc("block/" + getName(block).replace("_fence_gate", "")));
                            } else if(block instanceof WallBlock){
                                wallInventory(getName(block), mcLoc("block/" + getName(block).replace("_wall", "")));
                            }


                            else {
                                simpleBlockItemModel(block);
                            }
                        }
                );

    }

    protected ItemModelBuilder simpleBlockItemModel(Block block) {
        String name = getName(block);
        return withOutExistingParent(name, modLoc("block/" + name));
    }

    protected ItemModelBuilder trapDoorBlock(Block block) {
        String name = getName(block);
        return withOutExistingParent(name, modLoc("block/" + name + "_bottom"));
    }

    protected ItemModelBuilder simpleGeneratedModel(Item item) {
        return simpleModel(item, mcLoc("item/generated"));
    }

    protected ItemModelBuilder simpleHandHeldModel(Item item) {
        return simpleModel(item, mcLoc("item/handheld"));
    }

    protected ItemModelBuilder simpleModel(Item item, ResourceLocation parent) {
        String name = getName(item);
        return singleTexture(name, parent, "layer0", modLoc("item/" + name));
    }

    protected String getName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }

    public ItemModelBuilder withOutExistingParent(String name, ResourceLocation parent) {
        return getBuilder(name).parent(getNonExistingFile(parent));
    }

    public ModelFile.UncheckedModelFile getNonExistingFile(ResourceLocation path) {
        ModelFile.UncheckedModelFile ret = new ModelFile.UncheckedModelFile(extendWithFolder(path));
        ret.assertExistence();
        return ret;
    }

    private ResourceLocation extendWithFolder(ResourceLocation rl) {
        if (rl.getPath().contains("/")) {
            return rl;
        }
        return new ResourceLocation(rl.getNamespace(), folder + "/" + rl.getPath());
    }
}

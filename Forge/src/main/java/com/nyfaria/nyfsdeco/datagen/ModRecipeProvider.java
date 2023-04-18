package com.nyfaria.nyfsdeco.datagen;

import com.nyfaria.nyfsdeco.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.TrapDoorBlock;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeSaver) {
        BlockInit.blocks.entries().forEach(
                entry -> stonecutterResultFromBase(recipeSaver, RecipeCategory.DECORATIONS, entry.getValue().get(), entry.getKey(), getCount(entry.getValue().get()))
        );
    }

    public int getCount(Block block) {
        if (block instanceof SlabBlock || block instanceof FenceBlock || block instanceof FenceGateBlock) {
            return 2;
        } else if (block instanceof CarpetBlock || block instanceof TrapDoorBlock || block instanceof PressurePlateBlock) {
            return 3;
        } else {
            return 1;
        }
    }
}

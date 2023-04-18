package com.nyfaria.nyfsdeco.datagen;

import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsdeco.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        BlockInit.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(block -> block instanceof SlabBlock)
                .forEach(this::slab);
        BlockInit.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(block -> !(block instanceof SlabBlock))
                .forEach(this::dropSelf);

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.getBlockStream().filter(this::shouldGenerateLoot).toList();
    }
    protected void slab(Block block) {
        this.add(block, createSlabItemTable(block));
    }

    protected Stream<Block> getBlockStream() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get);
    }

    protected boolean shouldDropSelf(Block block) {
        return shouldGenerateLoot(block);
    }

    protected boolean shouldGenerateLoot(Block block) {
        return block.asItem() != Items.AIR && !(block instanceof DropExperienceBlock);
    }

}

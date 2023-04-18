package com.nyfaria.nyfsdeco.datagen;

import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.block.BlockCollection;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModTagProvider {

    public static class Items extends TagsProvider<Item>{

        public Items(PackOutput p_256596_, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256596_, Registries.ITEM, p_256513_, Constants.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

        }

        public void populateTag(TagKey<Item> tag, Supplier<Item>... items){
            for (Supplier<Item> item : items) {
                tag(tag).add(ForgeRegistries.ITEMS.getResourceKey(item.get()).get());
            }
        }
    }

    public static class Blocks extends TagsProvider<Block>{

        public Blocks(PackOutput pGenerator, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, Registries.BLOCK, p_256513_, Constants.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

            BlockCollection.COLLECTIONS.forEach(
                    collection ->{
                        populateTag(BlockTags.PRESSURE_PLATES, collection.getPressurePlate());
                        populateTag(BlockTags.STAIRS, collection.getStairs());
                        populateTag(BlockTags.SLABS, collection.getSlab());
                        populateTag(BlockTags.WOOL_CARPETS, collection.getCarpet());
                        populateTag(BlockTags.FENCES, collection.getFence());
                        populateTag(BlockTags.FENCE_GATES, collection.getFenceGate());
                        populateTag(BlockTags.WALLS, collection.getWall());
                    }
            );

        }
        public  <T extends Block>void populateTag(TagKey<Block> tag, Supplier<?>... items){
            if(items == null) return;
            for (Supplier<?> item : items) {
                if(item == null) continue;
                tag(tag).add(ForgeRegistries.BLOCKS.getResourceKey((Block)item.get()).get());
            }
        }
    }
}

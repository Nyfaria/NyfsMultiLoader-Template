package com.nyfaria.nyfsdeco.init;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.nyfaria.grinnersents.registration.RegistrationProvider;
import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.block.BlockCollection;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class BlockInit {
    public static Multimap<Block, RegistryObject<Block>> blocks = HashMultimap.create();
    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MODID);
    public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, Constants.MODID);

    public static final BlockCollection CRAFTING_TABLE_TOP = new BlockCollection(Blocks.CRAFTING_TABLE, "crafting_table_top");
    public static final BlockCollection FURNACE_TOP = new BlockCollection(Blocks.FURNACE, "furnace_top");
    public static final BlockCollection SMOKER_TOP = new BlockCollection(Blocks.SMOKER, "smoker_top");
    public static final BlockCollection SMOKER_BOTTOM = new BlockCollection(Blocks.SMOKER, "smoker_bottom");
    public static final BlockCollection BLAST_FURNACE_TOP = new BlockCollection(Blocks.BLAST_FURNACE, "blast_furnace_top");
    public static final BlockCollection LODESTONE_TOP = new BlockCollection(Blocks.LODESTONE, "lodestone_top");
    public static final BlockCollection LODESTONE_SIDE = new BlockCollection(Blocks.LODESTONE, "lodestone_side");
    //respawn anchor
    public static final BlockCollection RESPAWN_ANCHOR_TOP = new BlockCollection(Blocks.RESPAWN_ANCHOR, "respawn_anchor_top");
    public static final BlockCollection RESPAWN_ANCHOR_TOP_OFF = new BlockCollection(Blocks.RESPAWN_ANCHOR, "respawn_anchor_top_off");
    public static final BlockCollection DIAMOND_BLOCK = new BlockCollection(Blocks.DIAMOND_BLOCK, "diamond_block",false,true, true,true);
    public static final BlockCollection EMERALD_BLOCK = new BlockCollection(Blocks.EMERALD_BLOCK, "emerald_block",false,true, true,true);
    public static final BlockCollection GOLD_BLOCK = new BlockCollection(Blocks.GOLD_BLOCK, "gold_block",false,true, true,true);
    public static final BlockCollection IRON_BLOCK = new BlockCollection(Blocks.IRON_BLOCK, "iron_block",false,true, true,true);
    public static final BlockCollection LAPIS_BLOCK = new BlockCollection(Blocks.LAPIS_BLOCK, "lapis_block",false,true, true,true);
    public static final BlockCollection REDSTONE_BLOCK = new BlockCollection(Blocks.REDSTONE_BLOCK, "redstone_block",false,true, true,true);
    public static final BlockCollection COAL_BLOCK = new BlockCollection(Blocks.COAL_BLOCK, "coal_block",false,true, true,true);

    //all colors of shulker box in blockcollection
    public static final BlockCollection SHULKER_BOX = new BlockCollection(Blocks.SHULKER_BOX, "shulker_box");
    public static final BlockCollection WHITE_SHULKER_BOX = new BlockCollection(Blocks.WHITE_SHULKER_BOX, "white_shulker_box");
    public static final BlockCollection ORANGE_SHULKER_BOX = new BlockCollection(Blocks.ORANGE_SHULKER_BOX, "orange_shulker_box");
    public static final BlockCollection MAGENTA_SHULKER_BOX = new BlockCollection(Blocks.MAGENTA_SHULKER_BOX, "magenta_shulker_box");
    public static final BlockCollection LIGHT_BLUE_SHULKER_BOX = new BlockCollection(Blocks.LIGHT_BLUE_SHULKER_BOX, "light_blue_shulker_box");
    public static final BlockCollection YELLOW_SHULKER_BOX = new BlockCollection(Blocks.YELLOW_SHULKER_BOX, "yellow_shulker_box");
    public static final BlockCollection LIME_SHULKER_BOX = new BlockCollection(Blocks.LIME_SHULKER_BOX, "lime_shulker_box");
    public static final BlockCollection PINK_SHULKER_BOX = new BlockCollection(Blocks.PINK_SHULKER_BOX, "pink_shulker_box");
    public static final BlockCollection GRAY_SHULKER_BOX = new BlockCollection(Blocks.GRAY_SHULKER_BOX, "gray_shulker_box");
    public static final BlockCollection LIGHT_GRAY_SHULKER_BOX = new BlockCollection(Blocks.LIGHT_GRAY_SHULKER_BOX, "light_gray_shulker_box");
    public static final BlockCollection CYAN_SHULKER_BOX = new BlockCollection(Blocks.CYAN_SHULKER_BOX, "cyan_shulker_box");
    public static final BlockCollection PURPLE_SHULKER_BOX = new BlockCollection(Blocks.PURPLE_SHULKER_BOX, "purple_shulker_box");
    public static final BlockCollection BLUE_SHULKER_BOX = new BlockCollection(Blocks.BLUE_SHULKER_BOX, "blue_shulker_box");
    public static final BlockCollection BROWN_SHULKER_BOX = new BlockCollection(Blocks.BROWN_SHULKER_BOX, "brown_shulker_box");
    public static final BlockCollection GREEN_SHULKER_BOX = new BlockCollection(Blocks.GREEN_SHULKER_BOX, "green_shulker_box");
    public static final BlockCollection RED_SHULKER_BOX = new BlockCollection(Blocks.RED_SHULKER_BOX, "red_shulker_box");
    public static final BlockCollection BLACK_SHULKER_BOX = new BlockCollection(Blocks.BLACK_SHULKER_BOX, "black_shulker_box");

    //all colors of glazed terracotta in blockcollection
    public static final BlockCollection WHITE_GLAZED_TERRACOTTA = new BlockCollection(Blocks.WHITE_GLAZED_TERRACOTTA, "white_glazed_terracotta",false,true, true,true);
    public static final BlockCollection ORANGE_GLAZED_TERRACOTTA = new BlockCollection(Blocks.ORANGE_GLAZED_TERRACOTTA, "orange_glazed_terracotta",false,true, true,true);
    public static final BlockCollection MAGENTA_GLAZED_TERRACOTTA = new BlockCollection(Blocks.MAGENTA_GLAZED_TERRACOTTA, "magenta_glazed_terracotta",false,true, true,true);
    public static final BlockCollection LIGHT_BLUE_GLAZED_TERRACOTTA = new BlockCollection(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, "light_blue_glazed_terracotta",false,true, true,true);
    public static final BlockCollection YELLOW_GLAZED_TERRACOTTA = new BlockCollection(Blocks.YELLOW_GLAZED_TERRACOTTA, "yellow_glazed_terracotta",false,true, true,true);
    public static final BlockCollection LIME_GLAZED_TERRACOTTA = new BlockCollection(Blocks.LIME_GLAZED_TERRACOTTA, "lime_glazed_terracotta",false,true, true,true);
    public static final BlockCollection PINK_GLAZED_TERRACOTTA = new BlockCollection(Blocks.PINK_GLAZED_TERRACOTTA, "pink_glazed_terracotta",false,true, true,true);
    public static final BlockCollection GRAY_GLAZED_TERRACOTTA = new BlockCollection(Blocks.GRAY_GLAZED_TERRACOTTA, "gray_glazed_terracotta",false,true, true,true);
    public static final BlockCollection LIGHT_GRAY_GLAZED_TERRACOTTA = new BlockCollection(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, "light_gray_glazed_terracotta",false,true, true,true);
    public static final BlockCollection CYAN_GLAZED_TERRACOTTA = new BlockCollection(Blocks.CYAN_GLAZED_TERRACOTTA, "cyan_glazed_terracotta",false,true, true,true);
    public static final BlockCollection PURPLE_GLAZED_TERRACOTTA = new BlockCollection(Blocks.PURPLE_GLAZED_TERRACOTTA, "purple_glazed_terracotta",false,true, true,true);
    public static final BlockCollection BLUE_GLAZED_TERRACOTTA = new BlockCollection(Blocks.BLUE_GLAZED_TERRACOTTA, "blue_glazed_terracotta",false,true, true,true);
    public static final BlockCollection BROWN_GLAZED_TERRACOTTA = new BlockCollection(Blocks.BROWN_GLAZED_TERRACOTTA, "brown_glazed_terracotta",false,true, true,true);
    public static final BlockCollection GREEN_GLAZED_TERRACOTTA = new BlockCollection(Blocks.GREEN_GLAZED_TERRACOTTA, "green_glazed_terracotta",false,true, true,true);
    public static final BlockCollection RED_GLAZED_TERRACOTTA = new BlockCollection(Blocks.RED_GLAZED_TERRACOTTA, "red_glazed_terracotta",false,true, true,true);
    public static final BlockCollection BLACK_GLAZED_TERRACOTTA = new BlockCollection(Blocks.BLACK_GLAZED_TERRACOTTA, "black_glazed_terracotta",false,true, true,true);
    //all colors of concrete in blockcollection
    public static final BlockCollection WHITE_CONCRETE = new BlockCollection(Blocks.WHITE_CONCRETE, "white_concrete",false,true, true,true);
    public static final BlockCollection ORANGE_CONCRETE = new BlockCollection(Blocks.ORANGE_CONCRETE, "orange_concrete",false,true, true,true);
    public static final BlockCollection MAGENTA_CONCRETE = new BlockCollection(Blocks.MAGENTA_CONCRETE, "magenta_concrete",false,true, true,true);
    public static final BlockCollection LIGHT_BLUE_CONCRETE = new BlockCollection(Blocks.LIGHT_BLUE_CONCRETE, "light_blue_concrete",false,true, true,true);
    public static final BlockCollection YELLOW_CONCRETE = new BlockCollection(Blocks.YELLOW_CONCRETE, "yellow_concrete",false,true, true,true);
    public static final BlockCollection LIME_CONCRETE = new BlockCollection(Blocks.LIME_CONCRETE, "lime_concrete",false,true, true,true);
    public static final BlockCollection PINK_CONCRETE = new BlockCollection(Blocks.PINK_CONCRETE, "pink_concrete",false,true, true,true);
    public static final BlockCollection GRAY_CONCRETE = new BlockCollection(Blocks.GRAY_CONCRETE, "gray_concrete",false,true, true,true);
    public static final BlockCollection LIGHT_GRAY_CONCRETE = new BlockCollection(Blocks.LIGHT_GRAY_CONCRETE, "light_gray_concrete",false,true, true,true);
    public static final BlockCollection CYAN_CONCRETE = new BlockCollection(Blocks.CYAN_CONCRETE, "cyan_concrete",false,true, true,true);
    public static final BlockCollection PURPLE_CONCRETE = new BlockCollection(Blocks.PURPLE_CONCRETE, "purple_concrete",false,true, true,true);
    public static final BlockCollection BLUE_CONCRETE = new BlockCollection(Blocks.BLUE_CONCRETE, "blue_concrete",false,true, true,true);
    public static final BlockCollection BROWN_CONCRETE = new BlockCollection(Blocks.BROWN_CONCRETE, "brown_concrete",false,true, true,true);
    public static final BlockCollection GREEN_CONCRETE = new BlockCollection(Blocks.GREEN_CONCRETE, "green_concrete",false,true, true,true);
    public static final BlockCollection RED_CONCRETE = new BlockCollection(Blocks.RED_CONCRETE, "red_concrete",false,true, true,true);
    public static final BlockCollection BLACK_CONCRETE = new BlockCollection(Blocks.BLACK_CONCRETE, "black_concrete",false,true, true,true);
    //all colors of concrete powder in blockcollection
    public static final BlockCollection WHITE_CONCRETE_POWDER = new BlockCollection(Blocks.WHITE_CONCRETE_POWDER, "white_concrete_powder",false,true, true,true);
    public static final BlockCollection ORANGE_CONCRETE_POWDER = new BlockCollection(Blocks.ORANGE_CONCRETE_POWDER, "orange_concrete_powder",false,true, true,true);
    public static final BlockCollection MAGENTA_CONCRETE_POWDER = new BlockCollection(Blocks.MAGENTA_CONCRETE_POWDER, "magenta_concrete_powder",false,true, true,true);
    public static final BlockCollection LIGHT_BLUE_CONCRETE_POWDER = new BlockCollection(Blocks.LIGHT_BLUE_CONCRETE_POWDER, "light_blue_concrete_powder",false,true, true,true);
    public static final BlockCollection YELLOW_CONCRETE_POWDER = new BlockCollection(Blocks.YELLOW_CONCRETE_POWDER, "yellow_concrete_powder",false,true, true,true);
    public static final BlockCollection LIME_CONCRETE_POWDER = new BlockCollection(Blocks.LIME_CONCRETE_POWDER, "lime_concrete_powder",false,true, true,true);
    public static final BlockCollection PINK_CONCRETE_POWDER = new BlockCollection(Blocks.PINK_CONCRETE_POWDER, "pink_concrete_powder",false,true, true,true);
    public static final BlockCollection GRAY_CONCRETE_POWDER = new BlockCollection(Blocks.GRAY_CONCRETE_POWDER, "gray_concrete_powder",false,true, true,true);
    public static final BlockCollection LIGHT_GRAY_CONCRETE_POWDER = new BlockCollection(Blocks.LIGHT_GRAY_CONCRETE_POWDER, "light_gray_concrete_powder",false,true, true,true);
    public static final BlockCollection CYAN_CONCRETE_POWDER = new BlockCollection(Blocks.CYAN_CONCRETE_POWDER, "cyan_concrete_powder",false,true, true,true);
    public static final BlockCollection PURPLE_CONCRETE_POWDER = new BlockCollection(Blocks.PURPLE_CONCRETE_POWDER, "purple_concrete_powder",false,true, true,true);
    public static final BlockCollection BLUE_CONCRETE_POWDER = new BlockCollection(Blocks.BLUE_CONCRETE_POWDER, "blue_concrete_powder",false,true, true,true);
    public static final BlockCollection BROWN_CONCRETE_POWDER = new BlockCollection(Blocks.BROWN_CONCRETE_POWDER, "brown_concrete_powder",false,true, true,true);
    public static final BlockCollection GREEN_CONCRETE_POWDER = new BlockCollection(Blocks.GREEN_CONCRETE_POWDER, "green_concrete_powder",false,true, true,true);
    public static final BlockCollection RED_CONCRETE_POWDER = new BlockCollection(Blocks.RED_CONCRETE_POWDER, "red_concrete_powder",false,true, true,true);
    public static final BlockCollection BLACK_CONCRETE_POWDER = new BlockCollection(Blocks.BLACK_CONCRETE_POWDER, "black_concrete_powder",false,true, true,true);
    //all colors of terracotta in blockcollection
    public static final BlockCollection WHITE_TERRACOTTA = new BlockCollection(Blocks.WHITE_TERRACOTTA, "white_terracotta",false,true, true,true);
    public static final BlockCollection ORANGE_TERRACOTTA = new BlockCollection(Blocks.ORANGE_TERRACOTTA, "orange_terracotta",false,true, true,true);
    public static final BlockCollection MAGENTA_TERRACOTTA = new BlockCollection(Blocks.MAGENTA_TERRACOTTA, "magenta_terracotta",false,true, true,true);
    public static final BlockCollection LIGHT_BLUE_TERRACOTTA = new BlockCollection(Blocks.LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta",false,true, true,true);
    public static final BlockCollection YELLOW_TERRACOTTA = new BlockCollection(Blocks.YELLOW_TERRACOTTA, "yellow_terracotta",false,true, true,true);
    public static final BlockCollection LIME_TERRACOTTA = new BlockCollection(Blocks.LIME_TERRACOTTA, "lime_terracotta",false,true, true,true);
    public static final BlockCollection PINK_TERRACOTTA = new BlockCollection(Blocks.PINK_TERRACOTTA, "pink_terracotta",false,true, true,true);
    public static final BlockCollection GRAY_TERRACOTTA = new BlockCollection(Blocks.GRAY_TERRACOTTA, "gray_terracotta",false,true, true,true);
    public static final BlockCollection LIGHT_GRAY_TERRACOTTA = new BlockCollection(Blocks.LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta",false,true, true,true);
    public static final BlockCollection CYAN_TERRACOTTA = new BlockCollection(Blocks.CYAN_TERRACOTTA, "cyan_terracotta",false,true, true,true);
    public static final BlockCollection PURPLE_TERRACOTTA = new BlockCollection(Blocks.PURPLE_TERRACOTTA, "purple_terracotta",false,true, true,true);
    public static final BlockCollection BLUE_TERRACOTTA = new BlockCollection(Blocks.BLUE_TERRACOTTA, "blue_terracotta",false,true, true,true);
    public static final BlockCollection BROWN_TERRACOTTA = new BlockCollection(Blocks.BROWN_TERRACOTTA, "brown_terracotta",false,true, true,true);
    public static final BlockCollection GREEN_TERRACOTTA = new BlockCollection(Blocks.GREEN_TERRACOTTA, "green_terracotta",false,true, true,true);
    public static final BlockCollection RED_TERRACOTTA = new BlockCollection(Blocks.RED_TERRACOTTA, "red_terracotta",false,true, true,true);
    public static final BlockCollection BLACK_TERRACOTTA = new BlockCollection(Blocks.BLACK_TERRACOTTA, "black_terracotta",false,true, true,true);
    //all colors of glass in blockcollection
    public static final BlockCollection WHITE_STAINED_GLASS = new BlockCollection(Blocks.WHITE_STAINED_GLASS, "white_stained_glass",false,true, true,true);
    public static final BlockCollection ORANGE_STAINED_GLASS = new BlockCollection(Blocks.ORANGE_STAINED_GLASS, "orange_stained_glass",false,true, true,true);
    public static final BlockCollection MAGENTA_STAINED_GLASS = new BlockCollection(Blocks.MAGENTA_STAINED_GLASS, "magenta_stained_glass",false,true, true,true);
    public static final BlockCollection LIGHT_BLUE_STAINED_GLASS = new BlockCollection(Blocks.LIGHT_BLUE_STAINED_GLASS, "light_blue_stained_glass",false,true, true,true);
    public static final BlockCollection YELLOW_STAINED_GLASS = new BlockCollection(Blocks.YELLOW_STAINED_GLASS, "yellow_stained_glass",false,true, true,true);
    public static final BlockCollection LIME_STAINED_GLASS = new BlockCollection(Blocks.LIME_STAINED_GLASS, "lime_stained_glass",false,true, true,true);
    public static final BlockCollection PINK_STAINED_GLASS = new BlockCollection(Blocks.PINK_STAINED_GLASS, "pink_stained_glass",false,true, true,true);
    public static final BlockCollection GRAY_STAINED_GLASS = new BlockCollection(Blocks.GRAY_STAINED_GLASS, "gray_stained_glass",false,true, true,true);
    public static final BlockCollection LIGHT_GRAY_STAINED_GLASS = new BlockCollection(Blocks.LIGHT_GRAY_STAINED_GLASS, "light_gray_stained_glass",false,true, true,true);
    public static final BlockCollection CYAN_STAINED_GLASS = new BlockCollection(Blocks.CYAN_STAINED_GLASS, "cyan_stained_glass",false,true, true,true);
    public static final BlockCollection PURPLE_STAINED_GLASS = new BlockCollection(Blocks.PURPLE_STAINED_GLASS, "purple_stained_glass",false,true, true,true);
    public static final BlockCollection BLUE_STAINED_GLASS = new BlockCollection(Blocks.BLUE_STAINED_GLASS, "blue_stained_glass",false,true, true,true);
    public static final BlockCollection BROWN_STAINED_GLASS = new BlockCollection(Blocks.BROWN_STAINED_GLASS, "brown_stained_glass",false,true, true,true);
    public static final BlockCollection GREEN_STAINED_GLASS = new BlockCollection(Blocks.GREEN_STAINED_GLASS, "green_stained_glass",false,true, true,true);
    public static final BlockCollection RED_STAINED_GLASS = new BlockCollection(Blocks.RED_STAINED_GLASS, "red_stained_glass",false,true, true,true);
    public static final BlockCollection BLACK_STAINED_GLASS = new BlockCollection(Blocks.BLACK_STAINED_GLASS, "black_stained_glass",false,true, true,true);
    public static final BlockCollection GLASS = new BlockCollection(Blocks.GLASS, "glass",false,true, true,true);
    public static final BlockCollection TINTED_GLASS = new BlockCollection(Blocks.TINTED_GLASS, "tinted_glass",false,true, true,true);

    //wool
    public static final BlockCollection WHITE_WOOL = new BlockCollection(Blocks.WHITE_WOOL, "white_wool",false,true, true,false);
    public static final BlockCollection ORANGE_WOOL = new BlockCollection(Blocks.ORANGE_WOOL, "orange_wool",false,true, true,false);
    public static final BlockCollection MAGENTA_WOOL = new BlockCollection(Blocks.MAGENTA_WOOL, "magenta_wool",false,true, true,false);
    public static final BlockCollection LIGHT_BLUE_WOOL = new BlockCollection(Blocks.LIGHT_BLUE_WOOL, "light_blue_wool",false,true, true,false);
    public static final BlockCollection YELLOW_WOOL = new BlockCollection(Blocks.YELLOW_WOOL, "yellow_wool",false,true, true,false);
    public static final BlockCollection LIME_WOOL = new BlockCollection(Blocks.LIME_WOOL, "lime_wool",false,true, true,false);
    public static final BlockCollection PINK_WOOL = new BlockCollection(Blocks.PINK_WOOL, "pink_wool",false,true, true,false);
    public static final BlockCollection GRAY_WOOL = new BlockCollection(Blocks.GRAY_WOOL, "gray_wool",false,true, true,false);
    public static final BlockCollection LIGHT_GRAY_WOOL = new BlockCollection(Blocks.LIGHT_GRAY_WOOL, "light_gray_wool",false,true, true,false);
    public static final BlockCollection CYAN_WOOL = new BlockCollection(Blocks.CYAN_WOOL, "cyan_wool",false,true, true,false);
    public static final BlockCollection PURPLE_WOOL = new BlockCollection(Blocks.PURPLE_WOOL, "purple_wool",false,true, true,false);
    public static final BlockCollection BLUE_WOOL = new BlockCollection(Blocks.BLUE_WOOL, "blue_wool",false,true, true,false);
    public static final BlockCollection BROWN_WOOL = new BlockCollection(Blocks.BROWN_WOOL, "brown_wool",false,true, true,false);
    public static final BlockCollection GREEN_WOOL = new BlockCollection(Blocks.GREEN_WOOL, "green_wool",false,true, true,false);
    public static final BlockCollection RED_WOOL = new BlockCollection(Blocks.RED_WOOL, "red_wool",false,true, true,false);
    public static final BlockCollection BLACK_WOOL = new BlockCollection(Blocks.BLACK_WOOL, "black_wool",false,true, true,false);

    //log tops
    public static final BlockCollection OAK_LOG_TOP = new BlockCollection(Blocks.OAK_LOG, "oak_log_top",true,true, true,true);
    public static final BlockCollection SPRUCE_LOG_TOP = new BlockCollection(Blocks.SPRUCE_LOG, "spruce_log_top",true,true, true,true);
    public static final BlockCollection BIRCH_LOG_TOP = new BlockCollection(Blocks.BIRCH_LOG, "birch_log_top",true,true, true,true);
    public static final BlockCollection JUNGLE_LOG_TOP = new BlockCollection(Blocks.JUNGLE_LOG, "jungle_log_top",true,true, true,true);
    public static final BlockCollection ACACIA_LOG_TOP = new BlockCollection(Blocks.ACACIA_LOG, "acacia_log_top",true,true, true,true);
    public static final BlockCollection DARK_OAK_LOG_TOP = new BlockCollection(Blocks.DARK_OAK_LOG, "dark_oak_log_top",true,true, true,true);
    public static final BlockCollection MANGROVE_LOG_TOP = new BlockCollection(Blocks.MANGROVE_LOG, "mangrove_log_top",true,true, true,true);
    public static final BlockCollection CRIMSON_STEM_TOP = new BlockCollection(Blocks.CRIMSON_STEM, "crimson_stem_top",true,true, true,true);
    public static final BlockCollection WARPED_STEM_TOP = new BlockCollection(Blocks.WARPED_STEM, "warped_stem_top",true,true, true,true);
    //mushroooms
    public static final BlockCollection RED_MUSHROOM_BLOCK= new BlockCollection(Blocks.RED_MUSHROOM_BLOCK, "red_mushroom_block",false,true, true,true);
    public static final BlockCollection BROWN_MUSHROOM_BLOCK= new BlockCollection(Blocks.BROWN_MUSHROOM_BLOCK, "brown_mushroom_block",false,true, true,true);
    public static final BlockCollection MUSHROOM_STEM= new BlockCollection(Blocks.MUSHROOM_STEM, "mushroom_stem",false,true, true,true);







    public static RegistryObject<Block> registerBlockWithItem(Block parent, String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), ItemInit.getItemProperties()));
        blocks.put(parent, blockRegistryObject);
        return blockRegistryObject;
    }

    public static void loadClass() {
    }
}

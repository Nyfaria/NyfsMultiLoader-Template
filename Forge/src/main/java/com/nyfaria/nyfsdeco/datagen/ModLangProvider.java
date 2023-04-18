package com.nyfaria.nyfsdeco.datagen;

import com.google.common.collect.ImmutableMap;
import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsdeco.Constants;
import com.nyfaria.nyfsdeco.init.BlockInit;
import com.nyfaria.nyfsdeco.init.EntityInit;
import com.nyfaria.nyfsdeco.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ModLangProvider extends LanguageProvider {
    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", ""
    );

    public ModLangProvider(PackOutput gen) {
        super(gen, Constants.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ItemInit.ITEMS.getEntries().forEach(this::itemLang);
        EntityInit.ENTITIES.getEntries().forEach(this::entityLang);
        BlockInit.BLOCKS.getEntries().forEach(this::blockLang);
        add("itemGroup." + Constants.MODID + ".blocks", "Nyf's Deco Blocks");
        add("itemGroup." + Constants.MODID + ".slabs", "Nyf's Deco Slabs");
        add("itemGroup." + Constants.MODID + ".stairs", "Nyf's Deco Stairs");
        add("itemGroup." + Constants.MODID + ".carpet", "Nyf's Deco Carpets");
        add("itemGroup." + Constants.MODID + ".pressure_plates", "Nyf's Deco Pressure Plates");
        add("itemGroup." + Constants.MODID + ".buttons", "Nyf's Deco Buttons");
        add("itemGroup." + Constants.MODID + ".trapdoors", "Nyf's Deco Trapdoors");
        add("itemGroup." + Constants.MODID + ".fences", "Nyf's Deco Fences");
        add("itemGroup." + Constants.MODID + ".fence_gates", "Nyf's Deco Fence Gates");
        add("itemGroup." + Constants.MODID + ".walls", "Nyf's Deco Walls");

    }

    protected void itemLang(RegistryObject<Item> entry) {
        if (!(entry.get() instanceof BlockItem) || entry.get() instanceof ItemNameBlockItem) {
            addItem(entry, checkReplace(entry));
        }
    }

    protected void blockLang(RegistryObject<Block> entry) {
        addBlock(entry, checkReplace(entry));
    }

    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }

    protected String checkReplace(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .map(this::checkReplace)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(String string) {
        return REPLACE_LIST.containsKey(string) ? REPLACE_LIST.get(string) : StringUtils.capitalize(string);
    }
}

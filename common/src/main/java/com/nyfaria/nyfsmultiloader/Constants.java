package com.nyfaria.nyfsmultiloader;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MODID = "nyfsmultiloader";
	public static final String MOD_NAME = "Nyfs Multi Loader";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}
}
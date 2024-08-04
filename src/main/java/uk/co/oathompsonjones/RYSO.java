package uk.co.oathompsonjones;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RYSO implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "ryso";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final boolean HAS_TRINKETS = FabricLoader.getInstance().isModLoaded("trinkets");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        LOGGER.info("{} is initializing!", MOD_ID.toUpperCase());
		if (HAS_TRINKETS)
			LOGGER.info("Trinkets detected.");

		// Register all items and item groups
		RYSOItems.initialize();
		RYSOItemGroups.initialize();
	}
}
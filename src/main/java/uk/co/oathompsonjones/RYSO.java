package uk.co.oathompsonjones;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO (2.0): A few sock specific advancements, i.e. volatile socks for double upgrade, grandma's socks for trading
//  with the grandma villager, etc.
// TODO: Generate advancements dynamically
// TODO (1.1): Several built-in resource packs: plain, spotty, striped (default), heel and toe, glazed terracotta
// TODO (1.1): Ability to wash socks in a cauldron to remove status effects + advancement for washing socks

public class RYSO implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String  MOD_ID       = "ryso";
    public static final Logger  LOGGER       = LoggerFactory.getLogger(MOD_ID);
    public static final boolean HAS_TRINKETS = FabricLoader.getInstance().isModLoaded("trinkets");

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("{} is initializing!", MOD_ID.toUpperCase());
        if (HAS_TRINKETS)
            LOGGER.info("Trinkets detected.");

        // Register all status effects
        RYSOStatusEffects.initialize();

        // Register all items and item groups
        RYSOItems.initialize();

        // Register all blocks
        RYSOBlocks.initialize();

        // Register the villager
        // TODO (2.0): RYSOVillagers.initialize();

        // Initialize resource packs
        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(MOD_ID, "legacy"),
                    modContainer,
                    Text.literal("RYSO Legacy Socks"),
                    ResourcePackActivationType.NORMAL
            );
        });
    }
}
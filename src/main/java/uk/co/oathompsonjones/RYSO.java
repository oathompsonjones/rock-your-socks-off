package uk.co.oathompsonjones;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RYSO implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "ryso";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info(MOD_ID.toUpperCase() + " is initializing!");

		// Register all items and item groups
		RYSOItems.initialize();
		RYSOItemGroups.initialize();
	}

	public static List<ItemStack> getEquippedSocksTrinkets(LivingEntity entity) {
		List<ItemStack> out = new ArrayList<>();

		// Return an empty list if the trinket component isn't present.
		Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);
		if (optional.isEmpty())
			return out;

		// Check each trinket slot with socks.
		TrinketComponent trinketComponent = optional.get();
		for (Item item : RYSOItems.ITEMS) {
			for (Pair<SlotReference, ItemStack> pair : trinketComponent.getEquipped(item)) {
				// If the socks are in a shoes slot, add it to the output.
				if (pair.getLeft().inventory().getSlotType().getName().equals("shoes")) out.add(pair.getRight());
			}
		}

		return out;
	}
}
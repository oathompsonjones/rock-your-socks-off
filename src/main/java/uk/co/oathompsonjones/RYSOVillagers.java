package uk.co.oathompsonjones;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class RYSOVillagers {
    public static final RegistryKey<PointOfInterestType> SOCKS_POI_KEY = poiKey("socks_poi");
    public static final PointOfInterestType              SOCKS_POI     = registerPoi("socks_poi", Blocks.FURNACE);

    public static final VillagerProfession SOCKS_TRADER = registerProfession("socks_trader", SOCKS_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION,
                                 new Identifier(RYSO.MOD_ID, name),
                                 new VillagerProfession(name,
                                                        entry -> entry.matchesKey(type),
                                                        entry -> entry.matchesKey(type),
                                                        ImmutableSet.of(),
                                                        ImmutableSet.of(),
                                                        SoundEvents.ENTITY_VILLAGER_WORK_FLETCHER
                                 )
        );
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(RYSO.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(RYSO.MOD_ID, name));
    }

    public static void initialize() {
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 32),
                                                             new ItemStack(RYSOItems.SOCKS, 1),
                                                             6,
                                                             12,
                                                             0.075f
            ));
        });
    }
}

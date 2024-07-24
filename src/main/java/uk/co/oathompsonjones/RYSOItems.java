package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RYSOItems {
    public static final Item SOCKS = register(new SocksItem("socks"));
    public static final Item RAINBOW_SOCKS = register(new SocksItem("rainbow_socks"));
    public static final Item CHRISTMAS_SOCKS = register(new SocksItem("christmas_socks"));
    public static final Item LIGHT_GRAY_SOCKS = register(new SocksItem("light_gray_socks"));
    public static final Item GRAY_SOCKS = register(new SocksItem("gray_socks"));
    public static final Item BLACK_SOCKS = register(new SocksItem("black_socks"));
    public static final Item BROWN_SOCKS = register(new SocksItem("brown_socks"));
    public static final Item RED_SOCKS = register(new SocksItem("red_socks"));
    public static final Item ORANGE_SOCKS = register(new SocksItem("orange_socks"));
    public static final Item YELLOW_SOCKS = register(new SocksItem("yellow_socks"));
    public static final Item LIME_SOCKS = register(new SocksItem("lime_socks"));
    public static final Item GREEN_SOCKS = register(new SocksItem("green_socks"));
    public static final Item CYAN_SOCKS = register(new SocksItem("cyan_socks"));
    public static final Item LIGHT_BLUE_SOCKS = register(new SocksItem("light_blue_socks"));
    public static final Item BLUE_SOCKS = register(new SocksItem("blue_socks"));
    public static final Item PURPLE_SOCKS = register(new SocksItem("purple_socks"));
    public static final Item MAGENTA_SOCKS = register(new SocksItem("magenta_socks"));
    public static final Item PINK_SOCKS = register(new SocksItem("pink_socks"));

    public static SocksItem register(SocksItem item) {
        return register(item, item.id);
    }

    public static <T extends Item> T register(T item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(RYSO.MOD_ID, id), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(RAINBOW_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(CHRISTMAS_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(LIGHT_GRAY_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(GRAY_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(BLACK_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(BROWN_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(RED_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(ORANGE_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(YELLOW_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(LIME_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(GREEN_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(CYAN_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(LIGHT_BLUE_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(BLUE_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(PURPLE_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(MAGENTA_SOCKS));
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((itemGroup) -> itemGroup.add(PINK_SOCKS));
    }
}

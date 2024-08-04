package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class RYSOItems {
    public static final List<Item> ITEMS = new ArrayList<>(List.of(
            register(new SocksItem("socks")),
            register(new SocksItem("rainbow_socks")),
            register(new SocksItem("christmas_socks")),
            register(new SocksItem("light_gray_socks")),
            register(new SocksItem("gray_socks")),
            register(new SocksItem("black_socks")),
            register(new SocksItem("brown_socks")),
            register(new SocksItem("red_socks")),
            register(new SocksItem("orange_socks")),
            register(new SocksItem("yellow_socks")),
            register(new SocksItem("lime_socks")),
            register(new SocksItem("green_socks")),
            register(new SocksItem("cyan_socks")),
            register(new SocksItem("light_blue_socks")),
            register(new SocksItem("blue_socks")),
            register(new SocksItem("purple_socks")),
            register(new SocksItem("magenta_socks")),
            register(new SocksItem("pink_socks"))
    ));

    public static SocksItem register(SocksItem item) {
        return register(item, item.id);
    }

    public static <T extends Item> T register(T item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(RYSO.MOD_ID, id), item);
    }

    private static void registerSocksItemInGroup(Item item) {
        ItemGroupEvents.modifyEntriesEvent(RYSOItemGroups.SOCKS_KEY).register((group) -> group.add(item));
    }

    public static void initialize() {
        for (Item item : ITEMS)
            registerSocksItemInGroup(item);
    }
}

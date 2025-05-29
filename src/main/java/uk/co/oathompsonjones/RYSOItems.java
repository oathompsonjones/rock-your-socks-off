package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class RYSOItems {
    public static final Item SOCKS            = register(new SocksItem("socks"));
    public static final Item LIGHT_GRAY_SOCKS = register(new SocksItem("light_gray_socks",
                                                                       RYSOStatusEffects.POISONOUS
    ));
    public static final Item GRAY_SOCKS       = register(new SocksItem("gray_socks", RYSOStatusEffects.STEEL_SKIN));
    public static final Item BLACK_SOCKS      = register(new SocksItem("black_socks", RYSOStatusEffects.TRUE_SIGHT));
    public static final Item BROWN_SOCKS      = register(new SocksItem("brown_socks", RYSOStatusEffects.SLIPPERY));
    public static final Item RED_SOCKS        = register(new SocksItem("red_socks", StatusEffects.REGENERATION));
    public static final Item ORANGE_SOCKS     = register(new SocksItem("orange_socks",
                                                                       RYSOStatusEffects.PIGLINS_FAVOR
    ));
    public static final Item YELLOW_SOCKS     = register(new SocksItem("yellow_socks", StatusEffects.HASTE, 1));
    public static final Item LIME_SOCKS       = register(new SocksItem("lime_socks", RYSOStatusEffects.GREEN_THUMB));
    public static final Item GREEN_SOCKS      = register(new SocksItem("green_socks", RYSOStatusEffects.THICK_SKIN));
    public static final Item CYAN_SOCKS       = register(new SocksItem("cyan_socks",
                                                                       RYSOStatusEffects.GUARDIANS_FAVOR
    ));
    public static final Item LIGHT_BLUE_SOCKS = register(new SocksItem("light_blue_socks", StatusEffects.SLOW_FALLING));
    public static final Item BLUE_SOCKS       = register(new SocksItem("blue_socks", StatusEffects.DOLPHINS_GRACE));
    public static final Item PURPLE_SOCKS     = register(new SocksItem("purple_socks", RYSOStatusEffects.SURE_FOOTED));
    public static final Item MAGENTA_SOCKS    = register(new SocksItem("magenta_socks",
                                                                       RYSOStatusEffects.ENDERMANS_FAVOR
    ));
    public static final Item PINK_SOCKS       = register(new SocksItem("pink_socks", RYSOStatusEffects.CUTESY));
    public static final Item RAINBOW_SOCKS    = register(new SocksItem("rainbow_socks",
                                                                       StatusEffects.RESISTANCE,
                                                                       1,
                                                                       // Make rainbow socks fireproof as they contain netherite scraps
                                                                       new Item.Settings().fireproof()
    ));
    public static final Item CHRISTMAS_SOCKS  = register(new SocksItem("christmas_socks",
                                                                       RYSOStatusEffects.JOLLY_SPIRIT
    ));

    public static final List<Item> ITEMS = Arrays
            .stream(RYSOItems.class.getDeclaredFields())
            .filter(field -> field.getType() == Item.class)
            .map(field -> {
                try {
                    return (Item) field.get(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to access item field: " + field.getName(), e);
                }
            })
            .toList();

    public static final RegistryKey<ItemGroup> KEY   = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                                                                      Identifier.of(RYSO.MOD_ID, "item_group")
    );
    public static final ItemGroup              GROUP = FabricItemGroup
            .builder()
            .icon(() -> new ItemStack(SOCKS))
            .displayName(Text.of(RYSO.MOD_ID.toUpperCase()))
            .build();

    public static SocksItem register(SocksItem item) {
        return register(item, item.getId());
    }

    public static <T extends Item> T register(T item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(RYSO.MOD_ID, id), item);
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, KEY, GROUP);
        for (var item : ITEMS)
            ItemGroupEvents.modifyEntriesEvent(KEY).register((group) -> group.add(item));
    }
}

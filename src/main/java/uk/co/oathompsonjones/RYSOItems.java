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

import java.util.List;

public class RYSOItems {
    public static final RegistryKey<ItemGroup> KEY   = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                                                                      Identifier.of(RYSO.MOD_ID, "item_group")
    );
    public static final List<Item>             ITEMS = List.of(
            register(new SocksItem("socks")),
            register(new SocksItem("light_gray_socks", RYSOStatusEffects.POISONOUS)),
            register(new SocksItem("gray_socks", RYSOStatusEffects.STEEL_SKIN)),
            register(new SocksItem("black_socks", RYSOStatusEffects.TRUE_SIGHT)),
            register(new SocksItem("brown_socks", RYSOStatusEffects.SLIPPERY)),
            register(new SocksItem("red_socks", StatusEffects.REGENERATION)),
            register(new SocksItem("orange_socks", RYSOStatusEffects.PIGLINS_FAVOR)),
            register(new SocksItem("yellow_socks", StatusEffects.HASTE, 1)),
            register(new SocksItem("lime_socks", RYSOStatusEffects.GREEN_THUMB)),
            register(new SocksItem("green_socks", RYSOStatusEffects.THICK_SKIN)),
            register(new SocksItem("cyan_socks", RYSOStatusEffects.GUARDIANS_FAVOR)),
            register(new SocksItem("light_blue_socks", StatusEffects.SLOW_FALLING)),
            register(new SocksItem("blue_socks", StatusEffects.DOLPHINS_GRACE)),
            register(new SocksItem("purple_socks", RYSOStatusEffects.SURE_FOOTED)),
            register(new SocksItem("magenta_socks", RYSOStatusEffects.ENDERMANS_FAVOR)),
            register(new SocksItem("pink_socks", RYSOStatusEffects.CUTESY)),
            // Make rainbow socks fireproof as they contain netherite scraps
            register(new SocksItem("rainbow_socks", StatusEffects.RESISTANCE, 1, new Item.Settings().fireproof())),
            register(new SocksItem("christmas_socks", RYSOStatusEffects.JOLLY_SPIRIT))
    );
    public static final ItemGroup              GROUP = FabricItemGroup
            .builder()
            .icon(() -> new ItemStack(RYSOItems.ITEMS.get(0)))
            .displayName(Text.of(RYSO.MOD_ID.toUpperCase()))
            .build();

    public static SocksItem register(SocksItem item) {
        return register(item, item.id);
    }

    public static <T extends Item> T register(T item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(RYSO.MOD_ID, id), item);
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, KEY, GROUP);

        for (Item item : ITEMS)
            ItemGroupEvents.modifyEntriesEvent(KEY).register((group) -> group.add(item));
    }
}

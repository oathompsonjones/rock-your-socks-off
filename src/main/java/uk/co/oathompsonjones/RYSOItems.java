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
import net.minecraft.util.Rarity;

import java.util.Arrays;
import java.util.List;

public class RYSOItems {
    // Base socks
    public static final SocksItem SOCKS = register(new SocksItem("socks"));

    // Single upgrade socks
    public static final SocksItem LIGHT_GRAY_SOCKS = register(new SocksItem("light_gray_socks",
                                                                            RYSOStatusEffects.POISONOUS
    ));
    public static final SocksItem GRAY_SOCKS       = register(new SocksItem("gray_socks",
                                                                            RYSOStatusEffects.STEEL_SKIN
    ));
    public static final SocksItem BLACK_SOCKS      = register(new SocksItem("black_socks",
                                                                            RYSOStatusEffects.TRUE_SIGHT
    ));
    public static final SocksItem BROWN_SOCKS      = register(new SocksItem("brown_socks", RYSOStatusEffects.SLIPPERY));
    public static final SocksItem RED_SOCKS        = register(new SocksItem("red_socks", StatusEffects.REGENERATION));
    public static final SocksItem ORANGE_SOCKS     = register(new SocksItem("orange_socks",
                                                                            RYSOStatusEffects.PIGLINS_FAVOR
    ));
    public static final SocksItem YELLOW_SOCKS     = register(new SocksItem("yellow_socks", StatusEffects.HASTE, 1));
    public static final SocksItem LIME_SOCKS       = register(new SocksItem("lime_socks",
                                                                            RYSOStatusEffects.GREEN_THUMB
    ));
    public static final SocksItem GREEN_SOCKS      = register(new SocksItem("green_socks",
                                                                            RYSOStatusEffects.THICK_SKIN
    ));
    public static final SocksItem CYAN_SOCKS       = register(new SocksItem("cyan_socks",
                                                                            RYSOStatusEffects.GUARDIANS_FAVOR
    ));
    public static final SocksItem LIGHT_BLUE_SOCKS = register(new SocksItem("light_blue_socks",
                                                                            StatusEffects.SLOW_FALLING
    ));
    public static final SocksItem BLUE_SOCKS       = register(new SocksItem("blue_socks",
                                                                            StatusEffects.DOLPHINS_GRACE
    ));
    public static final SocksItem PURPLE_SOCKS     = register(new SocksItem("purple_socks",
                                                                            RYSOStatusEffects.SURE_FOOTED
    ));
    public static final SocksItem MAGENTA_SOCKS    = register(new SocksItem("magenta_socks",
                                                                            RYSOStatusEffects.ENDERMANS_FAVOR
    ));
    public static final SocksItem PINK_SOCKS       = register(new SocksItem("pink_socks", RYSOStatusEffects.CUTESY));
    public static final SocksItem RAINBOW_SOCKS    = register(new SocksItem("rainbow_socks",
                                                                            StatusEffects.RESISTANCE,
                                                                            1,
                                                                            new Item.Settings()
                                                                                    // Netherite scraps
                                                                                    .fireproof()
                                                                                    // Warden antenna
                                                                                    .rarity(Rarity.RARE)
    ));
    // TODO: Vampire socks (leeching) = attack without weapon makes you heal as much damage as you deal
    // TODO: Backpack socks (beast of burden) = have 4 extra inventory slots that can hold any item
    // TODO: Grandma's socks (cozy) = immunity to freezing/burning damage + becomes part of the christmas socks recipe
    // TODO: Firework socks (primed) = detonate several fireworks upon death, dealing damage to nearby entities
    // TODO: Music socks (musical) = each step plays the note block sound of the block you are walking on

    // Double upgrade socks
    public static final SocksItem CHRISTMAS_SOCKS = register(new SocksItem("christmas_socks",
                                                                           RYSOStatusEffects.JOLLY_SPIRIT
    ));
    // TODO: Explosive socks (creeper's favour) = made with firework socks + makes creepers neutral to the player
    // TODO: Midas socks (midas touch) = made with orange socks + makes all mobs drop gold nuggets, ingots and rarely
    //  blocks instead of their usual drops
    // TODO: Flowering socks (florist) = made with lime socks + 10% chance of placing a flower when walking on grass
    //  + bees follow you and pollinate off you
    // TODO: Treasure socks (spelunker's eye) = made with purple socks + random item from
    //  dungeon/shipwreck/treasure/mineshaft loot tables every 500 steps
    // TODO: Werewolf socks (strength) = made with black socks + gives strength at night with the level based on the
    //  moon phase
    // TODO: Chicken socks (avian alliance) = made with light blue socks + crouching has chance to drop eggs + gives
    //  attackers hunger
    // TODO: Ethereal socks (celestial grace) = made with light gray socks + gives attacks levitation for a short time

    // Triple upgrade socks
    // TODO: Volatile socks (fortitude) = made with explosive socks + immunity to explosions
    // TODO: XP socks (experienced) = looting for xp + maybe cheaper enchanting/anvil costs

    // Non-sock items
    public static final Item WARDEN_ANTENNA = register(new Item(new Item.Settings().rarity(Rarity.RARE)),
                                                       "warden_antenna"
    );

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

    public static final RegistryKey<ItemGroup> KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
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

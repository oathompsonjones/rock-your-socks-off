package uk.co.oathompsonjones.ryso;

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
    public static final SocksItem SOCKS = register(new SocksItem("socks", "\"Bland, get a better fashion sense.\""));

    // Single upgrade socks
    public static final SocksItem LIGHT_GRAY_SOCKS = register(new SocksItem("light_gray_socks",
            "You feel like you are more lethal with these socks.",
            "\"Usually poisonous things wear bright colours.\"",
            SOCKS,
            RYSOStatusEffects.POISONOUS
    ));
    public static final SocksItem GRAY_SOCKS       = register(new SocksItem("gray_socks",
            "You feel like your body is sturdier with these socks.",
            "\"Just don't high-five anyone please.\"",
            SOCKS,
            RYSOStatusEffects.STEEL_BODY
    ));
    public static final SocksItem BLACK_SOCKS      = register(new SocksItem("black_socks",
            "You feel like you can see clearer with these socks.",
            "\"Feels like your toes are being tickled by the darkness itself.\"",
            SOCKS,
            RYSOStatusEffects.TRUE_SIGHT
    ));
    public static final SocksItem BROWN_SOCKS      = register(new SocksItem("brown_socks",
            "You feel like you are harder to catch with these socks.",
            "\"Did you have fun playing in the mud?\"",
            SOCKS,
            RYSOStatusEffects.SLIPPERY
    ));
    public static final SocksItem RED_SOCKS        = register(new SocksItem("red_socks",
            "You feel like you can recover faster with these socks.",
            "\"Smells like determination.\"",
            SOCKS,
            StatusEffects.REGENERATION
    ));
    public static final SocksItem ORANGE_SOCKS     = register(new SocksItem("orange_socks",
            "You feel like you have formed an alliance with piglins.",
            "\"Have fun smelling like bacon all day.\"",
            SOCKS,
            RYSOStatusEffects.PIGLINS_FAVOR
    ));
    public static final SocksItem YELLOW_SOCKS     = register(new SocksItem("yellow_socks",
            "You feel like you are more energized with these socks.",
            "\"For those who can't stand the taste of coffee.\"",
            SOCKS,
            StatusEffects.HASTE,
            1
    ));
    // TODO (1.1): Add compatability with The Roads More Travelled (give lightness effect too)
    public static final SocksItem LIME_SOCKS       = register(new SocksItem("lime_socks",
            "You feel like your gardening is improved with these socks.",
            "\"Grow some skills while you're at it.\"",
            SOCKS,
            RYSOStatusEffects.GREEN_THUMB
    ));
    public static final SocksItem GREEN_SOCKS      = register(new SocksItem("green_socks",
            "You feel like you are immune to small wounds with these socks.",
            "\"If only netherite was built to withstand cacti.\"",
            SOCKS,
            RYSOStatusEffects.THICK_SKIN
    ));
    public static final SocksItem CYAN_SOCKS       = register(new SocksItem("cyan_socks",
            "You feel like you have formed an alliance with guardians.",
            "\"Have fun smelling like fish all day.\"",
            SOCKS,
            RYSOStatusEffects.GUARDIANS_FAVOR
    ));
    // TODO (1.1): Add compatability with The Roads More Travelled (give lightness effect too)
    public static final SocksItem LIGHT_BLUE_SOCKS = register(new SocksItem("light_blue_socks",
            "You feel like you are lighter on your feet with these socks.",
            "\"It's like walking on clouds.\"",
            SOCKS,
            StatusEffects.SLOW_FALLING
    ));
    public static final SocksItem BLUE_SOCKS       = register(new SocksItem("blue_socks",
            "You feel like you are prepared to go swimming with these socks.",
            "\"Wet socks, gross.\"",
            SOCKS,
            StatusEffects.DOLPHINS_GRACE
    ));
    public static final SocksItem PURPLE_SOCKS     = register(new SocksItem("purple_socks",
            "You feel like you are much steadier on your feet with these socks.",
            "\"Run for the hills.\"",
            SOCKS,
            RYSOStatusEffects.SURE_FOOTED
    ));
    public static final SocksItem MAGENTA_SOCKS    = register(new SocksItem("magenta_socks",
            "You feel like you have formed an alliance with endermen.",
            "\"Staring contest!\"",
            SOCKS,
            RYSOStatusEffects.ENDERMANS_FAVOR
    ));
    public static final SocksItem PINK_SOCKS       = register(new SocksItem("pink_socks",
            "You feel like you have formed an alliance with pillagers.",
            "\"Just don't try it on the magical ones, they see right through your spells.\"",
            SOCKS,
            RYSOStatusEffects.CUTESY
    ));
    public static final SocksItem ACORN_SOCKS      = register(new SocksItem("acorn_socks",
            "You feel like your senses" + " grow sharper with these socks.",
            "\"SQUIRREL!\"",
            SOCKS,
            // forest dweller: random item from dungeon/shipwreck/treasure/mineshaft loot tables every 1000 steps
            null
    ));
    public static final SocksItem AMBER_SOCKS      = register(new SocksItem("amber_socks",
            "You feel like your " + "hunting abilities have increased with these socks.",
            "\"Just like the good ol' days.\"",
            SOCKS,
            // hunter gatherer: looting
            null
    ));
    public static final SocksItem ARTICHOKE_SOCKS  = register(new SocksItem("artichoke_socks",
            "You feel like you are" + " learning faster with these socks.",
            "\"Sadly it doesn't work on books.\"",
            SOCKS,
            // experienced: looting for xp + maybe cheaper enchanting/anvil costs
            null
    ));
    public static final SocksItem BANANA_SOCKS     = register(new SocksItem("banana_socks",
            "You feel like the ground" + " is slippery with these socks.",
            "\"It's like walking on banana peels constantly.\"",
            SOCKS,
            // banana split: decrease friction + increase speed
            null
    ));
    public static final SocksItem CERULEAN_SOCKS   = register(new SocksItem("cerulean_socks",
            "You feel like you can " + "hold your breath longer with these socks.",
            "\"No snorkel? No problem!\"",
            SOCKS,
            StatusEffects.WATER_BREATHING
    ));
    public static final SocksItem FUCHSIA_SOCKS    = register(new SocksItem("fuchsia_socks",
            "You feel like you are " + "more radiant with these socks.",
            "\"My eyes!\"",
            SOCKS,
            StatusEffects.GLOWING
    ));
    public static final SocksItem GRAPE_SOCKS      = register(new SocksItem("grape_socks",
            "You feel like you are " + "stronger together with these socks.",
            "\"Now you just need friends to use them.\"",
            SOCKS,
            // strength in numbers: strength + absorption when 2+ players with same socks within 50 blocks of each other
            null
    ));
    public static final SocksItem INDIGO_SOCKS     = register(new SocksItem("indigo_socks",
            "You feel like you have " + "formed an alliance with shulkers.",
            "\"A shame there isn't more room in that shell of theirs.\"",
            SOCKS,
            // shulker's favor: gives attackers levitation for a short time + makes shulkers neutral to the player
            null
    ));
    public static final SocksItem MAROON_SOCKS     = register(new SocksItem("maroon_socks",
            "You feel like you are " + "stronger when falling with these socks.",
            "\"It's-a-me!\"",
            SOCKS,
            // stomping: deal more damage when falling from higher heights/deal damage when landing on something
            null
    ));
    public static final SocksItem MAUVE_SOCKS      = register(new SocksItem("mauve_socks",
            "You feel like you are " + "more resistant to knockback with these socks.",
            "\"What happens when an unstoppable force meets an immovable object?\"",
            SOCKS,
            // rooted: negate knockback
            null
    ));
    public static final SocksItem MINT_SOCKS       = register(new SocksItem("mint_socks",
            "You feel like you can walk" + " on water with these socks.",
            "\"Enjoy having constantly cold feet.\"",
            SOCKS,
            // frosty: the same as frost walker boots
            null
    ));
    public static final SocksItem MOLD_SOCKS       = register(new SocksItem("mold_socks",
            "You feel like you have a " + "stronger connection to mushrooms with these socks.",
            "\"You'll be patient zero when the apocalypse breaks out.\"",
            SOCKS,
            // fungal growth: regain hunger when standing on fungi
            null
    ));
    public static final SocksItem NAVY_SOCKS       = register(new SocksItem("navy_socks",
            "You feel like you are more" + " powerful in environments not made for you with these socks.",
            "\"Become the beast others fear.\"",
            SOCKS,
            // out of element: attack and speed boost in water and rain
            null
    ));
    public static final SocksItem PEACH_SOCKS      = register(new SocksItem("peach_socks",
            "You feel like you can " + "reach further with these socks.",
            "\"Just peachy.\"",
            SOCKS,
            // peach reach: increase reach
            null
    ));
    public static final SocksItem PERIWINKLE_SOCKS = register(new SocksItem("periwinkle_socks",
            "You feel like you'll" + " never sleep again with these socks.",
            "\"It's past your bedtime, go to sleep.\"",
            SOCKS,
            // insomnia: prevents phantoms spawning around the player + makes them neutral
            null
    ));
    public static final SocksItem SAGE_SOCKS       = register(new SocksItem("sage_socks",
            "You feel like you will " + "repel enemies with these socks.",
            "\"Stinky, go take a shower.\"",
            SOCKS,
            // stinky: gives attackers nausea
            null
    ));
    public static final SocksItem SAP_SOCKS        = register(new SocksItem("sap_socks",
            "You feel like you have a " + "stronger connection to flowers with these socks.",
            "\"Live out your fairy dreams!\"",
            SOCKS,
            // floral growth: 10% chance of placing a flower when walking on grass + bees follow you and pollinate
            // off you
            null
    ));
    public static final SocksItem SHAMROCK_SOCKS   = register(new SocksItem("shamrock_socks",
            "You feel like your " + "fortune is greater with these socks.",
            "\"You feelin' lucky?\"",
            SOCKS,
            StatusEffects.LUCK
    ));
    public static final SocksItem VELVET_SOCKS     = register(new SocksItem("velvet_socks",
            "You feel like you're " + "unstoppable in fights with these socks.",
            "\"Rip and tear until it is done.\"",
            SOCKS,
            // ferocity: increase attack speed as player attacks more mobs, reset after not fighting for x ticks
            null
    ));
    public static final SocksItem VERMILION_SOCKS  = register(new SocksItem("vermilion_socks",
            "You feel like you are" + " more resistant to fire with these socks.",
            "\"They say you're hot but I think you're on fire!\"",
            SOCKS,
            StatusEffects.FIRE_RESISTANCE
    ));
    public static final SocksItem RAINBOW_SOCKS    = register(new SocksItem("rainbow_socks",
            "You feel like you are protected with these socks.",
            "\"Happy pride!\"",
            SOCKS,
            StatusEffects.RESISTANCE,
            1,
            new Item.Settings()
                    // Netherite scraps
                    .fireproof()
                    // Warden antenna
                    .rarity(Rarity.RARE)
    ));
    // TODO (3.0): Spooky socks (spooky) = makes zombies and skeletons neutral to the player
    // TODO (3.0): Vampire socks (leeching) = attack without weapon makes you heal as much damage as you deal
    // TODO (3.0): Backpack socks (beast of burden) = have 4 extra inventory slots that can hold any item
    // TODO (3.0): Grandma's socks (cozy) = immunity to freezing/burning damage + becomes part of the christmas socks
    //  recipe
    // TODO (3.0): Firework socks (primed) = detonate several fireworks upon death, dealing damage to nearby entities
    // TODO (3.0): Music socks (musical) = each step plays the note block sound of the block you are walking on

    // Double upgrade socks
    public static final SocksItem CHRISTMAS_SOCKS = register(new SocksItem("christmas_socks",
            "You feel like you are possessed by the spirit of Christmas with these socks.",
            "\"Happy holidays!\"",
            SOCKS,
            RYSOStatusEffects.JOLLY_SPIRIT
    ));
    // TODO (4.0): Explosive socks (creeper's favour) = made with firework socks + makes creepers neutral to the player
    // TODO (4.0): Midas socks (midas touch) = made with orange socks + makes all mobs drop gold nuggets, ingots and
    //  rarely blocks instead of their usual drops
    // TODO (4.0): Werewolf socks (strength) = made with black socks + gives strength at night with the level based on
    //  the moon phase
    // TODO (4.0): Chicken socks (avian alliance) = made with light blue socks + crouching has chance to drop eggs +
    //  gives attackers hunger
    // TODO (4.0): Souldbound socks (styx and bones) = made with spooky socks + makes all undead mobs (except the
    //  wither) and ghasts neutral to the player
    // TODO (4.0): Vegetation socks (photosynthesis) = made with mold socks + same as fungal growth but works on plants

    // Triple upgrade socks
    // TODO (5.0): Volatile socks (fortitude) = made with explosive socks + immunity to explosions
    // TODO (5.0): Draconic socks (dragon's flight) = made with _______ socks + gives creative flight which causes
    //  hunger to deplete at same rate as sprinting and player falls out of the sky if they run out of hunger
    // TODO (5.0): Autotroph socks (saturation) = made with vegetation socks + saturation

    // Non-sock items
    // TODO (3.0): public static final Item CURSED_FLESH = register(new Item(new Item.Settings().rarity(Rarity
    //  .UNCOMMON).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.1F).statusEffect(new
    //  StatusEffectInstance(StatusEffects.WITHER, 600, 0), 0.8F).meat().build())), "cursed_flesh");
    // TODO (3.0): public static final Item VERTEBRA = register(new Item(new Item.Settings().rarity(Rarity.UNCOMMON))
    //  , "vertebra");
    // TODO (3.0): public static final Item SOUL_ROD = register(new Item(new Item.Settings().rarity(Rarity.UNCOMMON))
    //  , "soul_rod");
    // TODO (3.0): public static final Item GUARDIAN_ROD = register(new Item(new Item.Settings().rarity(Rarity
    //  .UNCOMMON)), "guardian_rod");
    // TODO (3.0): public static final Item SPARK_IN_A_BOTTLE = register(new Item(new Item.Settings().rarity(Rarity
    //  .UNCOMMON).maxCount(1)), "spark_in_a_bottle");

    public static final List<SocksItem> SOCKS_ITEMS = Arrays.stream(RYSOItems.class.getDeclaredFields()).filter(field ->
            field.getType()
                    == SocksItem.class).map(field -> {
        try {
            return (SocksItem) field.get(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access item field: " + field.getName(), e);
        }
    }).toList();

    public static final List<Item> ITEMS = Arrays
            .stream(RYSOItems.class.getDeclaredFields())
            .filter(field -> field.getType() == Item.class || field.getType() == SocksItem.class)
            .map(field -> {
                try {
                    return (Item) field.get(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to access item field: " + field.getName(), e);
                }
            })
            .toList();

    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(RYSO.MOD_ID, "item_group")
    );

    public static SocksItem register(SocksItem item) {
        return register(item, item.getId());
    }

    public static <T extends Item> T register(T item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(RYSO.MOD_ID, id), item);
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP,
                ITEM_GROUP,
                FabricItemGroup
                        .builder()
                        .icon(() -> new ItemStack(SOCKS))
                        .displayName(Text.of(RYSO.MOD_ID.toUpperCase()))
                        .build()
        );
        for (var item : ITEMS)
            ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register((group) -> group.add(item));
    }
}

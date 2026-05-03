package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import uk.co.oathompsonjones.ryso.RYSOBlocks;
import uk.co.oathompsonjones.ryso.RYSOItems;

import java.util.function.Consumer;

public class RYSORecipeProvider extends FabricRecipeProvider {
    public RYSORecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // base socks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RYSOItems.SOCKS).pattern("w w").pattern("w w").input(
                'w',
                Items.WHITE_WOOL
        ).criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL)).offerTo(
                exporter,
                getRecipeName(RYSOItems.SOCKS)
        );

        // light gray socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.LIGHT_GRAY_SOCKS)
                .pattern("lfl")
                .pattern("pbp")
                .pattern("lfl")
                .input('b', RYSOItems.SOCKS)
                .input('f', Items.FERMENTED_SPIDER_EYE)
                .input('l', Items.LILY_OF_THE_VALLEY)
                .input('p', Items.PUFFERFISH)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.FERMENTED_SPIDER_EYE), conditionsFromItem(Items.FERMENTED_SPIDER_EYE))
                .criterion(hasItem(Items.LILY_OF_THE_VALLEY), conditionsFromItem(Items.LILY_OF_THE_VALLEY))
                .criterion(hasItem(Items.PUFFERFISH), conditionsFromItem(Items.PUFFERFISH))
                .offerTo(exporter, getRecipeName(RYSOItems.LIGHT_GRAY_SOCKS));

        // gray socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.GRAY_SOCKS)
                .pattern("imi")
                .pattern("sbs")
                .pattern("imi")
                .input('b', RYSOItems.SOCKS)
                .input('m', Items.MILK_BUCKET)
                .input('i', Items.IRON_BLOCK)
                .input(
                        's',
                        Items.BONE_BLOCK
                )
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                .criterion(hasItem(Items.BONE_BLOCK), conditionsFromItem(Items.BONE_BLOCK))
                .offerTo(exporter, getRecipeName(RYSOItems.GRAY_SOCKS));

        // black socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.BLACK_SOCKS)
                .pattern("ici")
                .pattern("ebe")
                .pattern("ici")
                .input('b', RYSOItems.SOCKS)
                .input('c', Items.GOLDEN_CARROT)
                .input('i', Items.INK_SAC)
                .input('e', Items.ECHO_SHARD)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT))
                .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter, getRecipeName(RYSOItems.BLACK_SOCKS));

        // brown socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.BROWN_SOCKS)
                .pattern("mcm")
                .pattern("rbr")
                .pattern("mcm")
                .input('b', RYSOItems.SOCKS)
                .input('c', Items.COPPER_INGOT)
                .input('m', Items.MUD)
                .input('r', Items.RABBIT_HIDE)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.MUD), conditionsFromItem(Items.MUD))
                .criterion(hasItem(Items.RABBIT_HIDE), conditionsFromItem(Items.RABBIT_HIDE))
                .offerTo(exporter, getRecipeName(RYSOItems.BROWN_SOCKS));

        // red socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.RED_SOCKS)
                .pattern("rgr")
                .pattern("mbm")
                .pattern("rgr")
                .input('b', RYSOItems.SOCKS)
                .input('g', Items.GHAST_TEAR)
                .input('r', Items.REDSTONE)
                .input('m', Items.GLISTERING_MELON_SLICE)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(
                        hasItem(Items.GHAST_TEAR),
                        conditionsFromItem(Items.GHAST_TEAR)
                )
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.GLISTERING_MELON_SLICE), conditionsFromItem(Items.GLISTERING_MELON_SLICE))
                .offerTo(exporter, getRecipeName(RYSOItems.RED_SOCKS));

        // orange socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.ORANGE_SOCKS)
                .pattern("gpg")
                .pattern("nbn")
                .pattern("gpg")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.BLAZE_POWDER)
                .input('g', Items.GOLD_INGOT)
                .input('n', Items.NETHER_WART)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.NETHER_WART), conditionsFromItem(Items.NETHER_WART))
                .offerTo(exporter, getRecipeName(RYSOItems.ORANGE_SOCKS));

        // yellow socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.YELLOW_SOCKS)
                .pattern("gag")
                .pattern("ibi")
                .pattern("gag")
                .input('b', RYSOItems.SOCKS)
                .input('a', Items.GOLDEN_APPLE)
                .input('g', Items.GLOWSTONE_DUST)
                .input('i', Items.GOLD_INGOT)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, getRecipeName(RYSOItems.YELLOW_SOCKS));

        // lime socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.LIME_SOCKS)
                .pattern("cmc")
                .pattern("sbs")
                .pattern("cmc")
                .input('b', RYSOItems.SOCKS)
                .input('m', Items.BONE_MEAL)
                .input('c', Items.MOSS_CARPET)
                .input('s', Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .criterion(hasItem(Items.MOSS_CARPET), conditionsFromItem(Items.MOSS_CARPET))
                .criterion(hasItem(Items.WHEAT_SEEDS), conditionsFromItem(Items.WHEAT_SEEDS))
                .offerTo(exporter, getRecipeName(RYSOItems.LIME_SOCKS));

        // green socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.GREEN_SOCKS)
                .pattern("csc")
                .pattern("ebe")
                .pattern("csc")
                .input('b', RYSOItems.SOCKS)
                .input('s', Items.SCUTE)
                .input('c', Items.CACTUS)
                .input('e', Items.SWEET_BERRIES)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.SCUTE), conditionsFromItem(Items.SCUTE))
                .criterion(hasItem(Items.CACTUS), conditionsFromItem(Items.CACTUS))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter, getRecipeName(RYSOItems.GREEN_SOCKS));

        // cyan socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.CYAN_SOCKS)
                .pattern("pnp")
                .pattern("sbs")
                .pattern("pnp")
                .input('b', RYSOItems.SOCKS)
                .input('n', Items.NAUTILUS_SHELL)
                .input(
                        'p',
                        Items.PRISMARINE_CRYSTALS
                )
                .input('s', Items.SPONGE)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.NAUTILUS_SHELL), conditionsFromItem(Items.NAUTILUS_SHELL))
                .criterion(hasItem(Items.PRISMARINE_CRYSTALS), conditionsFromItem(Items.PRISMARINE_CRYSTALS))
                .criterion(hasItem(Items.SPONGE), conditionsFromItem(Items.SPONGE))
                .offerTo(exporter, getRecipeName(RYSOItems.CYAN_SOCKS));

        // light blue socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.LIGHT_BLUE_SOCKS)
                .pattern("fpf")
                .pattern("sbs")
                .pattern("fpf")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.PHANTOM_MEMBRANE)
                .input('f', Items.FEATHER)
                .input('s', Items.SOUL_SOIL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.PHANTOM_MEMBRANE), conditionsFromItem(Items.PHANTOM_MEMBRANE))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.SOUL_SOIL), conditionsFromItem(Items.SOUL_SOIL))
                .offerTo(exporter, getRecipeName(RYSOItems.LIGHT_BLUE_SOCKS));

        // blue socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.BLUE_SOCKS)
                .pattern("lpl")
                .pattern("cbc")
                .pattern("lpl")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.PRISMARINE_SHARD)
                .input('l', Items.LAPIS_LAZULI)
                .input('c', Items.TUBE_CORAL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.TUBE_CORAL), conditionsFromItem(Items.TUBE_CORAL))
                .offerTo(exporter, getRecipeName(RYSOItems.BLUE_SOCKS));

        // purple socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.PURPLE_SOCKS)
                .pattern("sas")
                .pattern("fbf")
                .pattern("sas")
                .input('b', RYSOItems.SOCKS)
                .input('a', Items.AMETHYST_BLOCK)
                .input('s', Items.SUGAR)
                .input('f', Items.ALLIUM)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.AMETHYST_BLOCK), conditionsFromItem(Items.AMETHYST_BLOCK))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.ALLIUM), conditionsFromItem(Items.ALLIUM))
                .offerTo(exporter, getRecipeName(RYSOItems.PURPLE_SOCKS));

        // magenta socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.MAGENTA_SOCKS)
                .pattern("pep")
                .pattern("cbc")
                .pattern("pep")
                .input('b', RYSOItems.SOCKS)
                .input('e', Items.ENDER_EYE)
                .input('p', Items.ENDER_PEARL)
                .input('c', Items.CHORUS_FRUIT)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter, getRecipeName(RYSOItems.MAGENTA_SOCKS));

        // pink socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.PINK_SOCKS)
                .pattern("pwp")
                .pattern("fbf")
                .pattern("pwp")
                .input('b', RYSOItems.SOCKS)
                .input('w', Items.PINK_WOOL)
                .input('p', Items.PINK_PETALS)
                .input(
                        'f',
                        Items.FLOWERING_AZALEA
                )
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(
                        hasItem(Items.PINK_WOOL),
                        conditionsFromItem(Items.PINK_WOOL)
                )
                .criterion(hasItem(Items.PINK_PETALS), conditionsFromItem(Items.PINK_PETALS))
                .criterion(hasItem(Items.FLOWERING_AZALEA), conditionsFromItem(Items.FLOWERING_AZALEA))
                .offerTo(exporter, getRecipeName(RYSOItems.PINK_SOCKS));

        // acorn socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.ACORN_SOCKS)
                .pattern("coc")
                .pattern("mbm")
                .pattern("coc")
                .input('b', RYSOItems.SOCKS)
                .input('c', Items.COCOA_BEANS)
                .input('o', Items.ORANGE_TERRACOTTA)
                .input('m', Items.MAP)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(Items.ORANGE_TERRACOTTA), conditionsFromItem(Items.ORANGE_TERRACOTTA))
                .criterion(hasItem(Items.MAP), conditionsFromItem(Items.MAP))
                .offerTo(exporter, getRecipeName(RYSOItems.ACORN_SOCKS));

        // amber socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.AMBER_SOCKS)
                .pattern("dcd")
                .pattern("bmb")
                .pattern("dcd")
                .input('b', RYSOItems.SOCKS)
                .input('d', Items.DRIPSTONE_BLOCK)
                .input('c', Items.CLAY)
                .input('m', Items.BONE)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.DRIPSTONE_BLOCK), conditionsFromItem(Items.DRIPSTONE_BLOCK))
                .criterion(hasItem(Items.CLAY), conditionsFromItem(Items.CLAY))
                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                .offerTo(exporter, getRecipeName(RYSOItems.AMBER_SOCKS));

        // artichoke socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.ARTICHOKE_SOCKS)
                .pattern("bqb")
                .pattern("xpx")
                .pattern("bqb")
                .input('b', RYSOItems.SOCKS)
                .input('q', Items.QUARTZ)
                .input('x', Items.EXPERIENCE_BOTTLE)
                .input('p', Items.BOOK)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE), conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .offerTo(exporter, getRecipeName(RYSOItems.ARTICHOKE_SOCKS));

        // banana socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.BANANA_SOCKS)
                .pattern("ipi")
                .pattern("sbs")
                .pattern("ipi")
                .input('b', RYSOItems.SOCKS)
                .input('i', Items.PACKED_ICE)
                .input('p', Items.JUNGLE_LEAVES)
                .input('s', Items.SUGAR)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.PACKED_ICE), conditionsFromItem(Items.PACKED_ICE))
                .criterion(hasItem(Items.JUNGLE_LEAVES), conditionsFromItem(Items.JUNGLE_LEAVES))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, getRecipeName(RYSOItems.BANANA_SOCKS));

        // cerulean socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.CERULEAN_SOCKS)
                .pattern("pmp")
                .pattern("sbs")
                .pattern("pmp")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.PUFFERFISH)
                .input('m', Items.SCUTE)
                .input('s', Items.TROPICAL_FISH)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.PUFFERFISH), conditionsFromItem(Items.PUFFERFISH))
                .criterion(hasItem(Items.SCUTE), conditionsFromItem(Items.SCUTE))
                .criterion(hasItem(Items.TROPICAL_FISH), conditionsFromItem(Items.TROPICAL_FISH))
                .offerTo(exporter, getRecipeName(RYSOItems.CERULEAN_SOCKS));

        // fuchsia socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.FUCHSIA_SOCKS)
                .pattern("gpg")
                .pattern("sbs")
                .pattern("gpg")
                .input('b', RYSOItems.SOCKS)
                .input('g', Items.GLOW_INK_SAC)
                .input('p', Items.PEONY)
                .input('s', Items.GLOWSTONE_DUST)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .criterion(hasItem(Items.PEONY), conditionsFromItem(Items.PEONY))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .offerTo(exporter, getRecipeName(RYSOItems.FUCHSIA_SOCKS));

        // grape socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.GRAPE_SOCKS)
                .pattern("aia")
                .pattern("lbl")
                .pattern("aia")
                .input('b', RYSOItems.SOCKS)
                .input('a', Items.AMETHYST_BLOCK)
                .input('i', Items.END_CRYSTAL)
                .input('l', Items.LEAD)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.AMETHYST_BLOCK), conditionsFromItem(Items.AMETHYST_BLOCK))
                .criterion(hasItem(Items.END_CRYSTAL), conditionsFromItem(Items.END_CRYSTAL))
                .criterion(hasItem(Items.LEAD), conditionsFromItem(Items.LEAD))
                .offerTo(exporter, getRecipeName(RYSOItems.GRAPE_SOCKS));

        // indigo socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.INDIGO_SOCKS)
                .pattern("ses")
                .pattern("pbp")
                .pattern("ses")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.PURPUR_BLOCK)
                .input('e', Items.ENDER_EYE)
                .input('s', Items.SHULKER_SHELL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.PURPUR_BLOCK), conditionsFromItem(Items.PURPUR_BLOCK))
                .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .offerTo(exporter, getRecipeName(RYSOItems.INDIGO_SOCKS));

        // maroon socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.MAROON_SOCKS)
                .pattern("dnd")
                .pattern("rbr")
                .pattern("dnd")
                .input('b', RYSOItems.SOCKS)
                .input('d', Items.DRIPSTONE_BLOCK)
                .input('n', Items.RED_SAND)
                .input('r', Items.ROSE_BUSH)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.DRIPSTONE_BLOCK), conditionsFromItem(Items.DRIPSTONE_BLOCK))
                .criterion(hasItem(Items.RED_SAND), conditionsFromItem(Items.RED_SAND))
                .criterion(hasItem(Items.ROSE_BUSH), conditionsFromItem(Items.ROSE_BUSH))
                .offerTo(exporter, getRecipeName(RYSOItems.MAROON_SOCKS));

        // mauve socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.MAUVE_SOCKS)
                .pattern("mrm")
                .pattern("nbn")
                .pattern("mrm")
                .input('b', RYSOItems.SOCKS)
                .input('m', Items.MOSS_BLOCK)
                .input('r', Items.ROOTED_DIRT)
                .input('n', Items.NETHER_WART)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.MOSS_BLOCK), conditionsFromItem(Items.MOSS_BLOCK))
                .criterion(hasItem(Items.ROOTED_DIRT), conditionsFromItem(Items.ROOTED_DIRT))
                .criterion(hasItem(Items.NETHER_WART), conditionsFromItem(Items.NETHER_WART))
                .offerTo(exporter, getRecipeName(RYSOItems.MAUVE_SOCKS));

        // mint socks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RYSOItems.MINT_SOCKS).pattern("ipi").pattern("sbs").pattern(
                "ipi").input('b', RYSOItems.SOCKS).input('i', Items.ICE).input('p', Items.PRISMARINE_SHARD).input('s',
                Items.POWDER_SNOW_BUCKET
        ).criterion(
                hasItem(Items.WHITE_WOOL),
                conditionsFromItem(Items.WHITE_WOOL)
        ).criterion(hasItem(Items.ICE), conditionsFromItem(Items.ICE)).criterion(
                hasItem(Items.PRISMARINE_SHARD),
                conditionsFromItem(Items.PRISMARINE_SHARD)
        ).criterion(hasItem(Items.POWDER_SNOW_BUCKET), conditionsFromItem(Items.POWDER_SNOW_BUCKET)).offerTo(
                exporter,
                getRecipeName(RYSOItems.MINT_SOCKS)
        );

        // mold socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.MOLD_SOCKS)
                .pattern("mrm")
                .pattern("sbs")
                .pattern("mrm")
                .input('b', RYSOItems.SOCKS)
                .input('m', Items.MYCELIUM)
                .input('r', Items.BROWN_MUSHROOM)
                .input('s', Items.RED_MUSHROOM)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.MYCELIUM), conditionsFromItem(Items.MYCELIUM))
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .criterion(hasItem(Items.RED_MUSHROOM), conditionsFromItem(Items.RED_MUSHROOM))
                .offerTo(exporter, getRecipeName(RYSOItems.MOLD_SOCKS));

        // navy socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.NAVY_SOCKS)
                .pattern("shs")
                .pattern("lbl")
                .pattern("shs")
                .input('b', RYSOItems.SOCKS)
                .input('l', Items.LAPIS_BLOCK)
                .input('h', Items.HEART_OF_THE_SEA)
                .input('s', Items.SEA_LANTERN)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.LAPIS_BLOCK), conditionsFromItem(Items.LAPIS_BLOCK))
                .criterion(hasItem(Items.HEART_OF_THE_SEA), conditionsFromItem(Items.HEART_OF_THE_SEA))
                .criterion(hasItem(Items.SEA_LANTERN), conditionsFromItem(Items.SEA_LANTERN))
                .offerTo(exporter, getRecipeName(RYSOItems.NAVY_SOCKS));

        // peach socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.PEACH_SOCKS)
                .pattern("vjv")
                .pattern("cbc")
                .pattern("vjv")
                .input('b', RYSOItems.SOCKS)
                .input('v', Items.VINE)
                .input('j', Items.JUNGLE_LOG)
                .input('c', Items.COPPER_INGOT)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.VINE), conditionsFromItem(Items.VINE))
                .criterion(hasItem(Items.JUNGLE_LOG), conditionsFromItem(Items.JUNGLE_LOG))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, getRecipeName(RYSOItems.PEACH_SOCKS));

        // periwinkle socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.PERIWINKLE_SOCKS)
                .pattern("pwp")
                .pattern("sbs")
                .pattern("pwp")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.PHANTOM_MEMBRANE)
                .input('w', Items.WHITE_BED)
                .input('s', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.PHANTOM_MEMBRANE), conditionsFromItem(Items.PHANTOM_MEMBRANE))
                .criterion(hasItem(Items.WHITE_BED), conditionsFromItem(Items.WHITE_BED))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, getRecipeName(RYSOItems.PERIWINKLE_SOCKS));

        // sage socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.SAGE_SOCKS)
                .pattern("rir")
                .pattern("mbm")
                .pattern("rir")
                .input('b', RYSOItems.SOCKS)
                .input('r', Items.ROTTEN_FLESH)
                .input('m', Items.MOSS_BLOCK)
                .input('i', Items.INK_SAC)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .criterion(hasItem(Items.MOSS_BLOCK), conditionsFromItem(Items.MOSS_BLOCK))
                .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
                .offerTo(exporter, getRecipeName(RYSOItems.SAGE_SOCKS));

        // sap socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.SAP_SOCKS)
                .pattern("dhd")
                .pattern("cbc")
                .pattern("dhd")
                .input('b', RYSOItems.SOCKS)
                .input('d', Items.DANDELION)
                .input('h', Items.HONEY_BOTTLE)
                .input('c', Items.CORNFLOWER)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.DANDELION), conditionsFromItem(Items.DANDELION))
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .criterion(hasItem(Items.CORNFLOWER), conditionsFromItem(Items.CORNFLOWER))
                .offerTo(exporter, getRecipeName(RYSOItems.SAP_SOCKS));

        // shamrock socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.SHAMROCK_SOCKS)
                .pattern("lgl")
                .pattern("rbr")
                .pattern("lgl")
                .input('b', RYSOItems.SOCKS)
                .input('l', Items.LIME_WOOL)
                .input('g', Items.GOLD_INGOT)
                .input('r', Items.RABBIT_FOOT)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.RABBIT_FOOT), conditionsFromItem(Items.RABBIT_FOOT))
                .offerTo(exporter, getRecipeName(RYSOItems.SHAMROCK_SOCKS));

        // velvet socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.VELVET_SOCKS)
                .pattern("pcp")
                .pattern("sbs")
                .pattern("pcp")
                .input('b', RYSOItems.SOCKS)
                .input('p', Items.BLAZE_POWDER)
                .input('s', Items.WITHER_SKELETON_SKULL)
                .input('c', Items.BEEF)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .criterion(hasItem(Items.WITHER_SKELETON_SKULL), conditionsFromItem(Items.WITHER_SKELETON_SKULL))
                .criterion(hasItem(Items.BEEF), conditionsFromItem(Items.BEEF))
                .offerTo(exporter, getRecipeName(RYSOItems.VELVET_SOCKS));

        // vermilion socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.VERMILION_SOCKS)
                .pattern("mom")
                .pattern("rbr")
                .pattern("mom")
                .input('b', RYSOItems.SOCKS)
                .input('m', Items.MAGMA_CREAM)
                .input('r', Items.BLAZE_ROD)
                .input('o', Items.OBSIDIAN)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter, getRecipeName(RYSOItems.VERMILION_SOCKS));

        // christmas socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.CHRISTMAS_SOCKS)
                .pattern("ses")
                .pattern("cbc")
                .pattern("sis")
                .input('b', RYSOItems.SOCKS)
                .input('e', Items.EMERALD)
                .input('i', Items.BLUE_ICE)
                .input('s', Items.POWDER_SNOW_BUCKET)
                .input('c', Items.COOKIE)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(Items.BLUE_ICE), conditionsFromItem(Items.BLUE_ICE))
                .criterion(hasItem(Items.POWDER_SNOW_BUCKET), conditionsFromItem(Items.POWDER_SNOW_BUCKET))
                .criterion(hasItem(Items.COOKIE), conditionsFromItem(Items.COOKIE))
                .offerTo(exporter, getRecipeName(RYSOItems.CHRISTMAS_SOCKS));

        // rainbow socks
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, RYSOItems.RAINBOW_SOCKS)
                .pattern("cnc")
                .pattern("wbw")
                .pattern("cnc")
                .input('b', RYSOItems.SOCKS)
                .input('n', Items.NETHERITE_SCRAP)
                .input('c', Items.CHORUS_FRUIT)
                .input('w', RYSOBlocks.WARDEN_ANTENNA)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                .criterion(hasItem(RYSOBlocks.WARDEN_ANTENNA), conditionsFromItem(RYSOBlocks.WARDEN_ANTENNA))
                .offerTo(exporter, getRecipeName(RYSOItems.RAINBOW_SOCKS));

        // TODO (3.0): spooky socks

        // TODO (3.0): vampire socks

        // TODO (3.0): backpack socks

        // TODO (3.0): grandma's socks

        // TODO (3.0): firework socks

        // TODO (3.0): music socks

        // TODO (4.0): explosive socks

        // TODO (4.0): midas socks

        // TODO (4.0): werewolf socks

        // TODO (4.0): chicken socks

        // TODO (4.0): souldbound socks

        // TODO (4.0): vegetation socks

        // TODO (5.0): volatile socks

        // TODO (5.0): draconic socks

        // TODO (5.0): autotroph socks

        // TODO (3.0): cursed flesh

        // TODO (3.0): vertebra

        // TODO (3.0): soul rod

        // TODO (3.0): guardian rod

        // TODO (3.0): spark in a bottle

    }
}

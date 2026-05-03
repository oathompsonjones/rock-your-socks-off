package uk.co.oathompsonjones.ryso.datagen;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetNbtLootFunction;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class RYSOBarteringLootTableProvider extends SimpleFabricLootTableProvider {
    public RYSOBarteringLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.BARTER);
    }

    private static SetCountLootFunction.Builder count(float min, float max) {
        return SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max));
    }

    private static NbtCompound nbt(String nbt) {
        try {
            return StringNbtReader.parse(nbt);
        } catch (CommandSyntaxException e) {
            throw new RuntimeException("Invalid loot table NBT: " + nbt, e);
        }
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(
                new Identifier("ryso", "gameplay/piglin_bartering_custom"),
                LootTable
                        .builder()
                        .randomSequenceId(new Identifier("minecraft", "gameplay/piglin_bartering"))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))

                                .with(ItemEntry
                                        .builder(Items.ENCHANTED_BOOK)
                                        .apply(SetNbtLootFunction.builder(nbt(
                                                "{StoredEnchantments:[{id:\"minecraft:soul_speed\",lvl:2s}]}")))
                                        .weight(1))

                                .with(ItemEntry
                                        .builder(Items.ENCHANTED_BOOK)
                                        .apply(SetNbtLootFunction.builder(nbt(
                                                "{StoredEnchantments:[{id:\"minecraft:soul_speed\",lvl:3s}]}")))
                                        .weight(1))

                                .with(ItemEntry.builder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).weight(2)).with(
                                        ItemEntry.builder(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE).weight(2))

                                .with(ItemEntry
                                        .builder(Items.POTION)
                                        .apply(SetPotionLootFunction.builder(Potions.REGENERATION))
                                        .weight(2))

                                .with(ItemEntry.builder(Items.GHAST_TEAR).apply(count(1, 2)).weight(2))

                                .with(ItemEntry.builder(Items.NETHER_WART).apply(count(6, 20)).weight(2))

                                .with(ItemEntry.builder(Items.BLAZE_POWDER).apply(count(2, 4)).weight(2))

                                .with(ItemEntry.builder(Items.WARPED_FUNGUS).apply(count(1, 4)).weight(5))

                                .with(ItemEntry.builder(Items.SADDLE).weight(5))

                                .with(ItemEntry.builder(Items.CRIMSON_FUNGUS).apply(count(1, 4)).weight(10))

                                .with(ItemEntry.builder(Items.BONE_BLOCK).apply(count(2, 8)).weight(10))

                                .with(ItemEntry.builder(Items.SOUL_TORCH).apply(count(8, 16)).weight(10))

                                .with(ItemEntry.builder(Items.SOUL_SAND).apply(count(4, 10)).weight(10))

                                .with(ItemEntry.builder(Items.BUCKET).apply(count(1, 2)).weight(10))

                                .with(ItemEntry.builder(Items.SPECTRAL_ARROW).apply(count(12, 16)).weight(10))

                                .with(ItemEntry.builder(Items.FIRE_CHARGE).apply(count(2, 4)).weight(10))

                                .with(ItemEntry.builder(Items.OBSIDIAN).apply(count(2, 3)).weight(10))

                                .with(ItemEntry.builder(Items.SOUL_LANTERN).apply(count(2, 6)).weight(10)))
        );
    }
}
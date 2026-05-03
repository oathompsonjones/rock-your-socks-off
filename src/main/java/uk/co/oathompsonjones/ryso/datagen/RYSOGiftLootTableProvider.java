package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class RYSOGiftLootTableProvider extends SimpleFabricLootTableProvider {
    public RYSOGiftLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.GIFT);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(
                new Identifier("ryso", "gameplay/jolly_spirit_gifts"),
                LootTable
                        .builder()
                        .pool(LootPool
                                .builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Items.EMERALD))
                                .with(ItemEntry.builder(Items.COOKIE))
                                .with(ItemEntry.builder(Items.MILK_BUCKET))
                                .with(ItemEntry.builder(Items.PUMPKIN_PIE))
                                .with(ItemEntry.builder(Items.SPRUCE_SAPLING))
                                .with(ItemEntry.builder(Items.WHITE_WOOL))
                                .with(ItemEntry.builder(Items.RED_WOOL))
                                .with(ItemEntry.builder(Items.PACKED_ICE))
                                .with(ItemEntry.builder(Items.POWDER_SNOW_BUCKET))
                                .with(ItemEntry.builder(Items.SNOWBALL)))
        );
    }
}
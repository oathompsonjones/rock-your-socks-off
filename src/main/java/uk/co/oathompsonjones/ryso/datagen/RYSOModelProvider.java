package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import uk.co.oathompsonjones.ryso.RYSOBlocks;
import uk.co.oathompsonjones.ryso.RYSOItems;

public class RYSOModelProvider extends FabricModelProvider {
    public RYSOModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        registerWardenAntenna(generator);

        for (Block block : RYSOBlocks.BLOCKS) {
            if (block == RYSOBlocks.WARDEN_ANTENNA)
                continue;

            generator.registerSimpleCubeAll(block);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        Models.GENERATED.upload(
                ModelIds.getItemModelId(RYSOBlocks.WARDEN_ANTENNA.asItem()),
                TextureMap.layer0(new Identifier("ryso", "block/warden_antenna")),
                generator.writer
        );

        for (Item item : RYSOItems.ITEMS)
            generator.register(item, Models.GENERATED);
    }

    private void registerWardenAntenna(BlockStateModelGenerator generator) {
        Identifier modelId = new Identifier("ryso", "block/warden_antenna");

        generator.blockStateCollector.accept(VariantsBlockStateSupplier
                .create(RYSOBlocks.WARDEN_ANTENNA)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING).register(
                        Direction.NORTH,
                        BlockStateVariant
                                .create()
                                .put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                ).register(
                        Direction.EAST,
                        BlockStateVariant
                                .create()
                                .put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                ).register(
                        Direction.SOUTH,
                        BlockStateVariant
                                .create()
                                .put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                ).register(
                        Direction.WEST,
                        BlockStateVariant
                                .create()
                                .put(VariantSettings.MODEL, modelId)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                )));
    }
}
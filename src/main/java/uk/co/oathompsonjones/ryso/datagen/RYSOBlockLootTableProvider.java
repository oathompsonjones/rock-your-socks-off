package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import uk.co.oathompsonjones.ryso.RYSOBlocks;

public class RYSOBlockLootTableProvider extends FabricBlockLootTableProvider {
    public RYSOBlockLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(RYSOBlocks.WARDEN_ANTENNA);
    }
}
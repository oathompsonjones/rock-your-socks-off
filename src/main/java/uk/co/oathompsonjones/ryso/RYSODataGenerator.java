package uk.co.oathompsonjones.ryso;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import uk.co.oathompsonjones.ryso.datagen.*;

public class RYSODataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(RYSOEnGbLanguageProvider::new);
        pack.addProvider(RYSOEnUsLanguageProvider::new);
        pack.addProvider(RYSOModelProvider::new);
        pack.addProvider(RYSORecipeProvider::new);
        pack.addProvider(RYSOAdvancementProvider::new);
        pack.addProvider(RYSOBlockLootTableProvider::new);
        pack.addProvider(RYSOBarteringLootTableProvider::new);
        pack.addProvider(RYSOGiftLootTableProvider::new);
        pack.addProvider(RYSOItemTagProvider::new);
        pack.addProvider(RYSOTrinketsEntityProvider::new);
        // TODO (3.0): pack.addProvider(RYSOPoiTagProvider::new);
    }
}

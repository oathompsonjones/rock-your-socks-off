package uk.co.oathompsonjones.datagen;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import uk.co.oathompsonjones.RYSO;

import java.util.concurrent.CompletableFuture;

public class RYSOPoiTagProvider extends TagProvider<PointOfInterestType> {
    public RYSOPoiTagProvider(
            DataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture
    ) {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(RYSO.MOD_ID,
                                                                                                           "socks_poi"
        ));
    }
}
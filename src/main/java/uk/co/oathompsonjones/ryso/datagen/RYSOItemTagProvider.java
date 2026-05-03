package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import uk.co.oathompsonjones.ryso.RYSOItems;
import uk.co.oathompsonjones.ryso.SocksItem;

import java.util.concurrent.CompletableFuture;

public class RYSOItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> TRINKETS_FEET_SHOES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("trinkets", "feet/shoes")
    );

    public RYSOItemTagProvider(
            FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        var shoeSlot = getOrCreateTagBuilder(TRINKETS_FEET_SHOES);
        for (SocksItem socksItem : RYSOItems.SOCKS_ITEMS)
            shoeSlot.add(socksItem);
    }
}
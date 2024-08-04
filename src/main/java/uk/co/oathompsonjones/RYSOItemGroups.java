package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RYSOItemGroups {
    public static final RegistryKey<ItemGroup> SOCKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                                                                          Identifier.of(RYSO.MOD_ID, "item_group")
    );

    public static final ItemGroup SOCKS = FabricItemGroup
            .builder()
            .icon(() -> new ItemStack(RYSOItems.ITEMS.get(0)))
            .displayName(Text.of(RYSO.MOD_ID.toUpperCase()))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, SOCKS_KEY, SOCKS);
    }
}

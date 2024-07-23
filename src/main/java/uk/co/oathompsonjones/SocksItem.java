package uk.co.oathompsonjones;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class SocksItem extends ArmorItem {
    public SocksItem() {
        super(WoolArmourMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());
    }
}
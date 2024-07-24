package uk.co.oathompsonjones;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class SocksItem extends ArmorItem {
    String id;

    public SocksItem(String id) {
        super(new SocksArmourMaterial(id), ArmorItem.Type.BOOTS, new Item.Settings());
        this.id = id;
    }
}
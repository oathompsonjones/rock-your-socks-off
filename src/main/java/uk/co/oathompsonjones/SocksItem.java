package uk.co.oathompsonjones;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.item.Item;
public class SocksItem extends TrinketItem {
    String id;

    public SocksItem(String id) {
        super(new Item.Settings());
        this.id = id;
    }
}
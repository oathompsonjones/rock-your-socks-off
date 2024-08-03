package uk.co.oathompsonjones;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SocksItem extends ArmorItem implements Trinket {
    String id;

    public SocksItem(String id) {
        super(new SocksArmourMaterial(id), Type.BOOTS, new Item.Settings());
        this.id = id;

        TrinketsApi.registerTrinket(this, this);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Attempts to equip the item as a trinket before falling back to the default behaviour
        ItemStack itemStack = user.getStackInHand(hand);
        boolean canEquipTrinket = TrinketItem.equipItem(user, itemStack);
        return canEquipTrinket ? TypedActionResult.success(itemStack) : super.use(world, user, hand);

    }

}
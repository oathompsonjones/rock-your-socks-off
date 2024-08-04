package uk.co.oathompsonjones;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import uk.co.oathompsonjones.integrations.trinkets.Trinkets;

public class SocksItem extends ArmorItem {
    public final String id;

    public SocksItem(String id) {
        super(new SocksArmourMaterial(id), Type.BOOTS, new Item.Settings());
        this.id = id;

        if (RYSO.HAS_TRINKETS)
            Trinkets.registerTrinket(this);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Attempts to equip the item as a trinket before falling back to the default behaviour
        if (RYSO.HAS_TRINKETS) {
            var result = Trinkets.equipTrinket(user, hand);
            return result.getResult().equals(ActionResult.SUCCESS) ? result : super.use(world, user, hand);
        }
        return super.use(world, user, hand);
    }
}
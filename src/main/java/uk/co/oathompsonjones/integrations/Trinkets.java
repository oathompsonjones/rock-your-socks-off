package uk.co.oathompsonjones.integrations;

import dev.emi.trinkets.api.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Pair;
import net.minecraft.util.TypedActionResult;
import uk.co.oathompsonjones.RYSOItems;
import uk.co.oathompsonjones.SocksItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Trinkets {
    public static void registerTrinket(Item item, Trinket trinket) {
        TrinketsApi.registerTrinket(item, trinket);
    }

    public static void registerTrinket(SocksItem item) {
        registerTrinket(item, new SocksTrinket(item.getId()));
    }

    public static TypedActionResult<ItemStack> equipTrinket(PlayerEntity user, Hand hand) {
        ItemStack itemStack       = user.getStackInHand(hand);
        boolean   canEquipTrinket = TrinketItem.equipItem(user, itemStack);
        return canEquipTrinket ? TypedActionResult.success(itemStack) : TypedActionResult.fail(itemStack);
    }

    public static List<ItemStack> getEquippedSocks(LivingEntity entity) {
        List<ItemStack> out = new ArrayList<>();

        // Return an empty list if the trinket component isn't present.
        Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(entity);
        if (optional.isEmpty())
            return out;

        // Check each trinket slot with socks.
        TrinketComponent trinketComponent = optional.get();
        for (Item item : RYSOItems.ITEMS) {
            for (Pair<SlotReference, ItemStack> pair : trinketComponent.getEquipped(item)) {
                // If the socks are in a shoes slot, add it to the output.
                if (pair.getLeft().inventory().getSlotType().getName().equals("shoes"))
                    out.add(pair.getRight());
            }
        }

        return out;
    }

    private record SocksTrinket(String id) implements Trinket {
        @Override
        public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
            Trinket.super.tick(stack, slot, entity);

            if (entity instanceof PlayerEntity user && stack.getItem() instanceof SocksItem socks) {
                // Apply the status effect
                if (socks.getEffect() != null)
                    user.addStatusEffect(new StatusEffectInstance(
                            socks.getEffect().getEffect(),
                            socks.getEffect().getCooldown(),
                            socks.getEffect().getAmplifier(),
                            false,
                            true
                    ));
            }
        }

        @Override
        public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
            Trinket.super.onEquip(stack, slot, entity);
            if (entity instanceof PlayerEntity user && stack.getItem() instanceof SocksItem socks) {
                // Play the equip sound
                user.playSound(socks.getEquipSound(), 1.0F, 1.0F);
            }
        }
    }
}

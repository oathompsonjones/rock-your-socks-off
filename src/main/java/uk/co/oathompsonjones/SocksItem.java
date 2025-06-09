package uk.co.oathompsonjones;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import uk.co.oathompsonjones.integrations.Trinkets;

import java.util.List;
import java.util.Objects;

public class SocksItem extends ArmorItem {
    private final String id;
    private final Effect effect;

    public SocksItem(String id) {
        this(id, null, 0, new Item.Settings());
    }

    public SocksItem(String id, Item.Settings settings) {
        this(id, null, 0, settings);
    }

    public SocksItem(String id, StatusEffect effect) {
        this(id, effect, 0, new Item.Settings());
    }

    public SocksItem(String id, StatusEffect effect, int amplifier) {
        this(id, effect, amplifier, new Item.Settings());
    }

    public SocksItem(String id, StatusEffect effect, Item.Settings settings) {
        this(id, effect, 0, settings);
    }

    public SocksItem(String id, StatusEffect effect, int amplifier, Item.Settings settings) {
        super(new SocksArmourMaterial(id), Type.BOOTS, settings);
        this.id     = id;
        this.effect = effect == null ? null : new Effect(effect, amplifier);

        // Register the item with the trinkets integration if it is present
        if (RYSO.HAS_TRINKETS)
            Trinkets.registerTrinket(this);
    }

    public String getId() {
        return id;
    }

    public Effect getEffect() {
        return effect;
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

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        // Apply the effect if the player is wearing the socks
        if (entity instanceof PlayerEntity player) {
            if (effect != null && stack.getItem() instanceof SocksItem socks && player
                    .getEquippedStack(EquipmentSlot.FEET)
                    .isOf(socks))
                player.addStatusEffect(new StatusEffectInstance(effect.effect,
                                                                effect.cooldown,
                                                                effect.amplifier,
                                                                false,
                                                                true
                ));
        }
    }

    @Override
    public void appendTooltip(
            ItemStack stack,
            @Nullable
            World world, List<Text> tooltip, TooltipContext context
    ) {
        tooltip.add(Text.translatable("tooltip.ryso." + id + ".0").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.ryso." + id + ".1").formatted(Formatting.GRAY));
        if (!Objects.equals(id, "socks"))
            tooltip.add(Text.literal(""));
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(
            ItemStack stack, EquipmentSlot slot
    ) {
        return ImmutableMultimap.of();
    }

    private static class SocksArmourMaterial implements ArmorMaterial {
        private final String name;

        public SocksArmourMaterial(String name) {
            this.name = name;
        }

        @Override
        public int getDurability(ArmorItem.Type type) {
            return 0;
        }

        @Override
        public int getProtection(ArmorItem.Type type) {
            return 0;
        }

        @Override
        public int getEnchantability() {
            return 0;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.BLOCK_WOOL_STEP;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return null;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }

    public static class Effect {
        private final StatusEffect effect;
        private final int          amplifier;
        private final int          cooldown = 60;

        public Effect(StatusEffect effect, int amplifier) {
            this.effect    = effect;
            this.amplifier = amplifier;
        }

        public StatusEffect getEffect() {
            return effect;
        }

        public int getAmplifier() {
            return amplifier;
        }

        public int getCooldown() {
            return cooldown;
        }
    }
}
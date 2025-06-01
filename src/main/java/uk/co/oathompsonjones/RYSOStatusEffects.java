package uk.co.oathompsonjones;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RYSOStatusEffects {
    public static final StatusEffect POISONOUS       = register("poisonous", new PoisonousStatusEffect());
    public static final StatusEffect STEEL_SKIN      = register("steel_skin", new SteelSkinStatusEffect());
    public static final StatusEffect TRUE_SIGHT      = register("true_sight", new TrueSightStatusEffect());
    public static final StatusEffect SLIPPERY        = register("slippery", new SlipperyStatusEffect());
    public static final StatusEffect PIGLINS_FAVOR   = register("piglins_favor", new PiglinsFavorStatusEffect());
    public static final StatusEffect GREEN_THUMB     = register("green_thumb", new GreenThumbStatusEffect());
    public static final StatusEffect THICK_SKIN      = register("thick_skin", new ThickSkinStatusEffect());
    public static final StatusEffect GUARDIANS_FAVOR = register("guardians_favor", new GuardiansFavorStatusEffect());
    public static final StatusEffect SURE_FOOTED     = register("sure_footed",
                                                                new SureFootedStatusEffect().addAttributeModifier(
                                                                        EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                                                        "91AEAA56-376B-4498-935B-2F7F68070635",
                                                                        0.2F,
                                                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                                                                )
    );
    public static final StatusEffect ENDERMANS_FAVOR = register("endermans_favor", new EndermansFavorStatusEffect());
    public static final StatusEffect CUTESY          = register("cutesy", new CutesyStatusEffect());
    public static final StatusEffect JOLLY_SPIRIT    = register("jolly_spirit", new JollySpiritStatusEffect());

    private static StatusEffect register(String id, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(RYSO.MOD_ID + ":" + id), entry);
    }

    public static void initialize() {
        // This method is intentionally empty. It is used to trigger static initializers.
        // The static initializers will register the status effects with the registry.
    }

    // Applies poison to attackers
    private static class PoisonousStatusEffect extends StatusEffect {
        public PoisonousStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x491110);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Immune to poison
    private static class SteelSkinStatusEffect extends StatusEffect {
        public SteelSkinStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x3E4447);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Night vision + immunity to darkness and blindness
    // TODO: Anti blindness/darkness does not work in production yet
    private static class TrueSightStatusEffect extends StatusEffect {
        public TrueSightStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x1FF6C8);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
            // TODO: This works, but it causes the night vision icon to appear in the inventory, which is not ideal.
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 0, false, false));
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Applies slowness to attackers and speed to player when attacked
    private static class SlipperyStatusEffect extends StatusEffect {
        public SlipperyStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x724728);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Makes piglins neutral to the player + better trades
    private static class PiglinsFavorStatusEffect extends StatusEffect {
        public PiglinsFavorStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0xF07613);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Fortune for crops and immune to crop trampling
    private static class GreenThumbStatusEffect extends StatusEffect {
        public GreenThumbStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x70B919);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Immune to berry bushes, cacti and thorns
    private static class ThickSkinStatusEffect extends StatusEffect {
        public ThickSkinStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x546D1B);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Makes guardians neutral to the player + immune to mining fatigue
    private static class GuardiansFavorStatusEffect extends StatusEffect {
        public GuardiansFavorStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x51E7BB);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Applies speed + walks up blocks like a horse
    // TODO: Walking up blocks is not implemented yet
    private static class SureFootedStatusEffect extends StatusEffect {
        public SureFootedStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x792AAC);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Acts like wearing a carved pumpkin + eating chorus fruit upon half a heart of health (33% chance every 10 seconds)
    private static class EndermansFavorStatusEffect extends StatusEffect {
        public EndermansFavorStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0xBD44B3);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Make pillagers and vindicators neutral to the player outside of raids
    private static class CutesyStatusEffect extends StatusEffect {
        public CutesyStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0xED8DAC);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }

    // Hero of the village (gifts, not discounts) + walk on powdered snow
    // TODO: Hero of the village is not implemented yet
    private static class JollySpiritStatusEffect extends StatusEffect {
        public JollySpiritStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0xA12722);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }
    }
}

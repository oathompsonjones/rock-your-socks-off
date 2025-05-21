package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(method="damage", at=@At("HEAD"), cancellable=true)
    public void ryso$damage_attacked(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
        var entity = (LivingEntity) (Object) this;

        // Handle the poisonous effect
        if (this.hasStatusEffect(RYSOStatusEffects.POISONOUS) && source.getAttacker() instanceof LivingEntity attacker)
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 1), this);

        // Handle the slippery effect
        if (this.hasStatusEffect(RYSOStatusEffects.SLIPPERY) && source.getAttacker() instanceof LivingEntity attacker) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0), this);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1), this);
        }

        // Handle the thick skin effect
        if (this.hasStatusEffect(RYSOStatusEffects.THICK_SKIN) && (
                source.isOf(DamageTypes.CACTUS)
                || source.isOf(DamageTypes.SWEET_BERRY_BUSH)
                || source.isOf(DamageTypes.THORNS)
        ))
            ci.cancel();
    }
}

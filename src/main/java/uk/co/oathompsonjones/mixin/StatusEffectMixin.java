package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(StatusEffect.class)
public class StatusEffectMixin {
    @Inject(method="applyUpdateEffect", at=@At("HEAD"), cancellable=true)
    private void ryso$applyUpdateEffect(LivingEntity entity, int amplifier, CallbackInfo ci) {
        var effect = (StatusEffect) (Object) this;
        if (entity.hasStatusEffect(RYSOStatusEffects.STEEL_SKIN) && effect == StatusEffects.POISON)
            ci.cancel();
    }
}

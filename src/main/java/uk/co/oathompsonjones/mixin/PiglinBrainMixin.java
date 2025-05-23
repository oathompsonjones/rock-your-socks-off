package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {
    // Prevent piglins from being hostile to players with the PIGLINS_FAVOR effect
    @Inject(method="wearsGoldArmor", at=@At("HEAD"), cancellable=true)
    private static void ryso$wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> ci) {
        if (entity.hasStatusEffect(RYSOStatusEffects.PIGLINS_FAVOR))
            ci.setReturnValue(true);
    }
}

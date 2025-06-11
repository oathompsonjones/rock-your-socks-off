package uk.co.oathompsonjones.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Inject(method="getNightVisionStrength", at=@At("HEAD"), cancellable=true)
    private static void ryso$getNightVisionStrength(
            LivingEntity entity, float tickDelta, CallbackInfoReturnable<Float> ci
    ) {
        StatusEffectInstance nightVisionEffect = entity.getStatusEffect(StatusEffects.NIGHT_VISION);
        StatusEffectInstance trueSightEffect   = entity.getStatusEffect(RYSOStatusEffects.TRUE_SIGHT);
        float maxDuration = Math.max(
                nightVisionEffect != null ? nightVisionEffect.getDuration() : 0.0F,
                trueSightEffect != null ? trueSightEffect.getDuration() : 0.0F
        );
        ci.setReturnValue(maxDuration > 200
                          ? 1.0F
                          : 0.7F + MathHelper.sin((maxDuration - tickDelta) * (float) Math.PI * 0.2F) * 0.3F);
    }
}

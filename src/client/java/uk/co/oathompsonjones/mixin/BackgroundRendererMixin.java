package uk.co.oathompsonjones.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {
    @Inject(method="getFogModifier", at=@At("HEAD"), cancellable=true)
    private static void ryso$getFogModifier(Entity entity, float tickDelta, CallbackInfoReturnable<Object> ci) {
        if (entity instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(RYSOStatusEffects.TRUE_SIGHT))
            ci.setReturnValue(null);
    }
}

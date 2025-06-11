package uk.co.oathompsonjones.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(BackgroundRenderer.class)
public abstract class BackgroundRendererMixin {
    @Inject(method="applyFog", at=@At("HEAD"), cancellable=true)
    private static void ryso$applyFog(
            Camera camera,
            BackgroundRenderer.FogType fogType,
            float viewDistance,
            boolean thickFog,
            float tickDelta,
            CallbackInfo ci
    ) {
        if (camera.getFocusedEntity() instanceof LivingEntity entity
            && entity.hasStatusEffect(RYSOStatusEffects.TRUE_SIGHT))
            ci.cancel();
    }

    @ModifyExpressionValue(
            method="render", at=@At(
            value="INVOKE",
            target="Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"
    )
    )
    private static boolean modifyNightVisionCheck(
            boolean original,
            @Local
            LivingEntity livingEntity2
    ) {
        return original || livingEntity2.hasStatusEffect(RYSOStatusEffects.TRUE_SIGHT);
    }
}

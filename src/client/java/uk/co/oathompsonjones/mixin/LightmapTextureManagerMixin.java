package uk.co.oathompsonjones.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(LightmapTextureManager.class)
public abstract class LightmapTextureManagerMixin {
    @Final
    @Shadow
    private MinecraftClient client;

    @ModifyExpressionValue(
            method="update(F)V", at=@At(
            value="INVOKE",
            target="Lnet/minecraft/client/network/ClientPlayerEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"
    )
    )
    private boolean modifyNightVisionCheck(boolean original) {
        return client.player.hasStatusEffect(RYSOStatusEffects.TRUE_SIGHT);
    }
}


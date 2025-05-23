package uk.co.oathompsonjones.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    // Prevent the effects of Mining Fatigue from being applied when the player has Guardians Favor
    @Inject(method="getBlockBreakingSpeed", at=@At("RETURN"), cancellable=true)
    private void modifyBreakingSpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        if (this.hasStatusEffect(StatusEffects.MINING_FATIGUE)
            && this.hasStatusEffect(RYSOStatusEffects.GUARDIANS_FAVOR)) {
            var player = (PlayerEntity) (Object) this;

            // Override mining fatigue by recalculating speed as if there were no fatigue
            float speed = player.getInventory().getMainHandStack().getMiningSpeedMultiplier(state);

            // Check if the player is in water without Aqua Affinity
            if (speed > 1.0f && !player.isOnGround() || player.hasStatusEffect(StatusEffects.HASTE))
                speed *= 1.0F + 0.2F * Objects
                        .requireNonNull(player.getStatusEffect(StatusEffects.HASTE))
                        .getAmplifier();

            cir.setReturnValue(speed);
        }
    }
}

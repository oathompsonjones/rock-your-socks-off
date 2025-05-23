package uk.co.oathompsonjones.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(PowderSnowBlock.class)
public abstract class PowderSnowBlockMixin extends Block {
    PowderSnowBlockMixin(Settings settings) {
        super(settings);
    }

    // Prevent player from sinking when wearing Christmas socks
    @Inject(method="canWalkOnPowderSnow", at=@At("HEAD"), cancellable=true)
    private static void ryso$canWalkOnPowerSnow(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (entity instanceof LivingEntity livingEntity
            && livingEntity.hasStatusEffect(RYSOStatusEffects.JOLLY_SPIRIT)) {
            ci.setReturnValue(true);
        }
    }
}

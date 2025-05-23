package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin extends HostileEntity implements Angerable {
    public EndermanEntityMixin(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method="isPlayerStaring", at=@At("HEAD"), cancellable=true)
    private void ryso$isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> ci) {
        if (player.hasStatusEffect(RYSOStatusEffects.ENDERMANS_FAVOR))
            ci.setReturnValue(false);
    }
}

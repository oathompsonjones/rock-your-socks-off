package uk.co.oathompsonjones.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin extends Block {
    public FarmlandBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method="onLandedUpon", at=@At("HEAD"), cancellable=true)
    private void ryso$onLandedUpon(
            World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci
    ) {
        if (entity instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(RYSOStatusEffects.GREEN_THUMB))
            ci.cancel();
    }
}

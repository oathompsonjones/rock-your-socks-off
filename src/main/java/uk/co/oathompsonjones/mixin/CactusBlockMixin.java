package uk.co.oathompsonjones.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.oathompsonjones.RYSOItems;
import uk.co.oathompsonjones.SocksItem;

@Mixin(CactusBlock.class)
public abstract class CactusBlockMixin extends Block {
    CactusBlockMixin(AbstractBlock.Settings settings) {
        super(settings);
    }

    // Prevent green socks from breaking when hitting cactus
    @Inject(method="onEntityCollision", at=@At("HEAD"), cancellable=true)
    private void ryso$onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (entity instanceof ItemEntity itemEntity
            && itemEntity.getStack().getItem() instanceof SocksItem socksItem
            && socksItem == RYSOItems.GREEN_SOCKS)
            ci.cancel();
    }
}

package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;
import uk.co.oathompsonjones.interfaces.PiglinEntityAccessor;

import java.util.List;
import java.util.Objects;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {
    // Prevent piglins from being hostile to players with the PIGLINS_FAVOR effect
    @Inject(method="wearsGoldArmor", at=@At("HEAD"), cancellable=true)
    private static void ryso$wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> ci) {
        if (entity.hasStatusEffect(RYSOStatusEffects.PIGLINS_FAVOR))
            ci.setReturnValue(true);
    }

    // Keep track of the player that the piglin is currently bartering with
    @Inject(method="playerInteract", at=@At("HEAD"))
    private static void ryso$playerInteract(
            PiglinEntity piglin, PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> ci
    ) {
        ((PiglinEntityAccessor) piglin).ryso$setBarteringWith(player);
    }

    // Clear the player that the piglin was bartering with when the interaction ends
    @Inject(method="doBarter", at=@At("RETURN"))
    private static void ryso$doBarter(PiglinEntity piglin, List<ItemStack> items, CallbackInfo ci) {
        ((PiglinEntityAccessor) piglin).ryso$setBarteringWith(null);
    }

    // Modify the loot table for bartering with piglins if the player has the PIGLINS_FAVOR effect
    @Inject(method="getBarteredItem", at=@At("HEAD"), cancellable=true)
    private static void ryso$getBarteredItem(PiglinEntity piglin, CallbackInfoReturnable<List<ItemStack>> ci) {
        var player = ((PiglinEntityAccessor) piglin).ryso$getBarteringWith();
        if (player != null
            && player.hasStatusEffect(RYSOStatusEffects.PIGLINS_FAVOR)
            && piglin.getWorld() instanceof ServerWorld) {
            ci.setReturnValue(Objects
                                      .requireNonNull(piglin.getWorld().getServer())
                                      .getLootManager()
                                      .getLootTable(new Identifier("ryso", "gameplay/piglin_bartering_custom"))
                                      .generateLoot(new LootContextParameterSet.Builder((ServerWorld) piglin.getWorld())
                                                            .add(LootContextParameters.THIS_ENTITY, piglin)
                                                            .build(LootContextTypes.BARTER)));
        }
    }
}

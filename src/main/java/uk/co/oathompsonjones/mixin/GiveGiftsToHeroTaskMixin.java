package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.GiveGiftsToHeroTask;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSO;
import uk.co.oathompsonjones.RYSOStatusEffects;

import java.util.Map;
import java.util.Objects;

@Mixin(GiveGiftsToHeroTask.class)
public abstract class GiveGiftsToHeroTaskMixin extends MultiTickTask<VillagerEntity> {
    public GiveGiftsToHeroTaskMixin(Map<MemoryModuleType<?>, MemoryModuleState> requiredMemoryState) {
        super(requiredMemoryState);
    }

    // Change the isHero condition to check for Jolly Spirit as well as Hero of the Village
    @Inject(method="isHero", at=@At("HEAD"), cancellable=true)
    private void ryso$isHero(PlayerEntity player, CallbackInfoReturnable<Boolean> ci) {
        if (player.hasStatusEffect(RYSOStatusEffects.JOLLY_SPIRIT))
            ci.setReturnValue(true);
    }

    // Override the loot table if the player has the Jolly Spirit effect
    @Inject(method="giveGifts", at=@At("HEAD"), cancellable=true)
    private void ryso$giveGifts(VillagerEntity villager, LivingEntity recipient, CallbackInfo ci) {
        if (recipient.hasStatusEffect(RYSOStatusEffects.JOLLY_SPIRIT)) {
            LootTable lootTable = Objects.requireNonNull(villager.getWorld().getServer()).getLootManager().getLootTable(
                    Identifier.of("ryso", "gameplay/jolly_spirit_gifts"));

            LootContextParameterSet
                    lootContextParameterSet
                    = new LootContextParameterSet.Builder((ServerWorld) villager.getWorld())
                    .add(LootContextParameters.ORIGIN, villager.getPos())
                    .add(LootContextParameters.THIS_ENTITY, villager)
                    .build(LootContextTypes.GIFT);

            var loot = lootTable.generateLoot(lootContextParameterSet);
            RYSO.LOGGER.info("Loot: {}", loot);
            for (ItemStack itemStack : loot)
                LookTargetUtil.give(villager, itemStack, recipient.getPos());

            ci.cancel();
        }
    }
}

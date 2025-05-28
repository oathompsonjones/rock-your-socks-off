package uk.co.oathompsonjones.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

import java.util.List;

@Mixin(Block.class)
public abstract class BlockMixin extends AbstractBlock implements ItemConvertible, FabricBlock {
    public BlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(
            method="getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
            at=@At("RETURN"),
            cancellable=true
    )
    private static void ryso$getDroppedStacks(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            @Nullable
            BlockEntity blockEntity,
            @Nullable
            Entity entity,
            ItemStack stack,
            CallbackInfoReturnable<List<ItemStack>> ci,
            @Local
            LootContextParameterSet.Builder builder
    ) {
        if ((
                    state.getBlock() instanceof CropBlock
                    || state.getBlock() == Blocks.MELON
                    || state.getBlock() instanceof NetherWartBlock
            )
            && entity instanceof LivingEntity livingEntity
            && livingEntity.hasStatusEffect(RYSOStatusEffects.GREEN_THUMB)) {
            var tool = stack.getItem() == Items.AIR ? new ItemStack(Items.NETHERITE_HOE) : stack.copy();
            tool.addEnchantment(Enchantments.FORTUNE, 5);
            builder.add(LootContextParameters.TOOL, tool);
            ci.setReturnValue(state.getDroppedStacks(builder));
        }
    }
}

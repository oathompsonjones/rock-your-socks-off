package uk.co.oathompsonjones;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RYSOCauldronBehaviours {
    public static CauldronBehavior CLEAN_SOCKS = (
            BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack
    ) -> {
        if (!world.isClient && RYSOItems.ITEMS.contains(stack.getItem()) && stack.getItem() != RYSOItems.SOCKS) {
            if (state.get(LeveledCauldronBlock.LEVEL) > 0) {
                // Replace with clean sock
                stack.decrement(1);
                player.getInventory().insertStack(player.getInventory().selectedSlot, new ItemStack(RYSOItems.SOCKS));

                // Decrease cauldron level
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);

                // Play sound
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        return ActionResult.success(world.isClient);
    };

    public static void register() {
        for (var sock : RYSOItems.ITEMS.stream().filter(item -> item != RYSOItems.SOCKS).toList())
            CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(sock, CLEAN_SOCKS);
    }
}

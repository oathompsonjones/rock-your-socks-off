package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.CrossbowUser;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InventoryOwner;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import uk.co.oathompsonjones.interfaces.PiglinEntityAccessor;

@Mixin(PiglinEntity.class)
public abstract class PiglinEntityMixin extends AbstractPiglinEntity
        implements CrossbowUser, InventoryOwner, PiglinEntityAccessor {
    @Nullable
    @Unique
    private PlayerEntity ryso$barteringWith;

    public PiglinEntityMixin(EntityType<? extends AbstractPiglinEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public PlayerEntity ryso$getBarteringWith() {
        return ryso$barteringWith;
    }

    @Override
    public void ryso$setBarteringWith(PlayerEntity barteringWith) {
        ryso$barteringWith = barteringWith;
    }
}
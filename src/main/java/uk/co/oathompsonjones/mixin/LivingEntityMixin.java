package uk.co.oathompsonjones.mixin;

import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uk.co.oathompsonjones.RYSOStatusEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    @Unique
    LivingEntity cutesyAttacker;

    @Unique
    LivingEntity guardiansFavorAttacker;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow
    public abstract float getHealth();

    @Shadow
    public abstract ItemStack eatFood(World world, ItemStack stack);

    @Inject(method="damage", at=@At("HEAD"), cancellable=true)
    public void ryso$damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
        var entity = (LivingEntity) (Object) this;

        // Handle the poisonous effect
        if (this.hasStatusEffect(RYSOStatusEffects.POISONOUS) && source.getAttacker() instanceof LivingEntity attacker)
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 1), this);

        // Handle the slippery effect
        if (this.hasStatusEffect(RYSOStatusEffects.SLIPPERY) && source.getAttacker() instanceof LivingEntity attacker) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0), this);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1), this);
        }

        // Handle the thick skin effect
        if (this.hasStatusEffect(RYSOStatusEffects.THICK_SKIN) && (
                source.isOf(DamageTypes.CACTUS)
                || source.isOf(DamageTypes.SWEET_BERRY_BUSH)
                || source.isOf(DamageTypes.THORNS)
        ))
            ci.cancel();

        // Handle the cutesy effect
        if ((entity instanceof PillagerEntity || entity instanceof VindicatorEntity)
            && source.getAttacker() instanceof LivingEntity attacker
            && attacker.hasStatusEffect(RYSOStatusEffects.CUTESY))
            cutesyAttacker = attacker;

        // Handle the guardians favor effect
        if ((this.getType() == EntityType.GUARDIAN || this.getType() == EntityType.ELDER_GUARDIAN)
            && source.getAttacker() instanceof LivingEntity attacker
            && attacker.hasStatusEffect(RYSOStatusEffects.GUARDIANS_FAVOR))
            guardiansFavorAttacker = attacker;

        // Handle the endermans favor effect
        if (this.hasStatusEffect(RYSOStatusEffects.ENDERMANS_FAVOR) && this.getHealth() - amount == 1) {
            var stack = new ItemStack(Items.CHORUS_FRUIT);
            stack.getItem().finishUsing(stack, this.getWorld(), entity);
        }
    }

    @Inject(method="canTarget(Lnet/minecraft/entity/LivingEntity;)Z", at=@At("HEAD"), cancellable=true)
    public void ryso$canTarget(LivingEntity target, CallbackInfoReturnable<Boolean> ci) {
        // Prevent pillagers and vindicators from attacking players with the CUTESY effect outside of raids unless provoked
        if (((LivingEntity) (Object) this) instanceof IllagerEntity illager
            && (illager instanceof PillagerEntity || illager instanceof VindicatorEntity)
            && !illager.hasActiveRaid()
            && target.hasStatusEffect(RYSOStatusEffects.CUTESY)
            && cutesyAttacker != target)
            ci.setReturnValue(false);

        // Prevent guardians from attacking players with the GUARDIANS_FAVOR effect unless provoked
        if ((this.getType() == EntityType.GUARDIAN || this.getType() == EntityType.ELDER_GUARDIAN)
            && target.hasStatusEffect(RYSOStatusEffects.GUARDIANS_FAVOR)
            && guardiansFavorAttacker != target) {
            ci.setReturnValue(false);
        }
    }
}

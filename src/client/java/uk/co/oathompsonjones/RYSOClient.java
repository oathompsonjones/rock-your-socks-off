package uk.co.oathompsonjones;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

public class RYSOClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        // Enable rendering socks in the trinket slot.
        // @formatter:off
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(
            (
                EntityType<? extends LivingEntity> entityType,
                LivingEntityRenderer<?, ?> entityRenderer,
                LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper registrationHelper,
                Context context
            ) -> registrationHelper.register(new SocksTrinketRenderer<>(entityRenderer, context.getModelLoader()))
        );
        // @formatter:on

        // Handle the sure-footed status effect.
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null)
                return;
            client.player.setStepHeight(client.player.hasStatusEffect(RYSOStatusEffects.SURE_FOOTED) ? 1.5F : 0.6F);
        });
    }
}
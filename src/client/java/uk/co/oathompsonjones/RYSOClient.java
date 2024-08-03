package uk.co.oathompsonjones;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;

public class RYSOClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		// Enable rendering socks in the trinket slot.
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((
				EntityType<? extends LivingEntity> entityType, LivingEntityRenderer<?, ?> entityRenderer,
				LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper registrationHelper,
				Context context) -> registrationHelper
				.register(new SocksTrinketRenderer<>(entityRenderer, context.getModelLoader())));

	}
}
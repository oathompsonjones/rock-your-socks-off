package uk.co.oathompsonjones;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import uk.co.oathompsonjones.integrations.trinkets.Trinkets;

import java.util.List;

public class SocksTrinketRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private final ArmorEntityModel<T> model;

    public SocksTrinketRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        model = new ArmorEntityModel<>(loader.getModelPart(EntityModelLayers.PLAYER_OUTER_ARMOR));
    }

    @Override
    public void render(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            T entity,
            float limbAngle,
            float limbDistance,
            float tickDelta,
            float animationProgress,
            float headYaw,
            float headPitch
    ) {
        // Get the stack of the socks.
        List<ItemStack> equippedTrinkets = RYSO.HAS_TRINKETS ? Trinkets.getEquippedSocks(entity) : List.of();
        if (equippedTrinkets.isEmpty())
            return;
        ItemStack stack = equippedTrinkets.get(0);
        Item      socks = stack.getItem();

        // Get the texture of the socks.
        String     path       = String.format("textures/models/armor/%s_layer_1.png", socks.toString());
        Identifier identifier = new Identifier("minecraft", path);

        // Render the socks.
        matrices.push();
        // Scale the socks to fit under the boots and over the leggings.
        matrices.scale(0.9f, 1, 0.9f);
        getContextModel().copyStateTo(model);
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        VertexConsumer vertex = vertexConsumers.getBuffer(RenderLayer.getArmorCutoutNoCull(identifier));
        model.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrices.pop();
    }
}

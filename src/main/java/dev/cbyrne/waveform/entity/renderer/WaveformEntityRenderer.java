package dev.cbyrne.waveform.entity.renderer;

import dev.cbyrne.waveform.entity.WaveformEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class WaveformEntityRenderer<T extends WaveformEntity> extends EntityRenderer<T> {
    public WaveformEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double x, double y, double z) {
        return super.shouldRender(entity, frustum, x, y, z);
    }

    @Override
    public void render(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        // This is just rendering an item to confirm if rendering works or not
        MinecraftClient.getInstance().getItemRenderer().renderItem(
            Items.APPLE.getDefaultStack(),
            ModelTransformation.Mode.FIXED,
            light,
            OverlayTexture.DEFAULT_UV,
            matrices,
            vertexConsumers,
            0
        );

        matrices.pop();
    }

    @Override
    public Identifier getTexture(T entity) {
        return null;
    }
}

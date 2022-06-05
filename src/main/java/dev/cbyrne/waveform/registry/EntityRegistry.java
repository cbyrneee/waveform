package dev.cbyrne.waveform.registry;

import dev.cbyrne.waveform.entity.WaveformEntity;
import dev.cbyrne.waveform.entity.renderer.WaveformEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("SameParameterValue")
public class EntityRegistry {
    public static final EntityType<WaveformEntity> WAVEFORM_ENTITY = FabricEntityTypeBuilder
        .create(SpawnGroup.MISC, WaveformEntity::new)
        .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
        .trackRangeBlocks(10)
        .trackedUpdateRate(Integer.MAX_VALUE)
        .build();

    public static void register() {
        registerEntity("waveform", WAVEFORM_ENTITY);
        registerRenderer(WAVEFORM_ENTITY, WaveformEntityRenderer::new);
    }

    private static <T extends Entity> void registerEntity(String id, EntityType<T> type) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier("waveform", id), type);
    }
    
    private static <T extends Entity> void registerRenderer(EntityType<T> entity, EntityRendererFactory<T> entityRendererFactory) {
        EntityRendererRegistry.register(entity, entityRendererFactory);
    }
}

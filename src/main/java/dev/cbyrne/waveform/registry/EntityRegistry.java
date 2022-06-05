package dev.cbyrne.waveform.registry;

import dev.cbyrne.waveform.entity.WaveformEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("SameParameterValue")
public class EntityRegistry {
    public static final EntityType<WaveformEntity> WAVEFORM = FabricEntityTypeBuilder.create(SpawnGroup.MISC, WaveformEntity::new).build();

    public static void register() {
        registerEntity("waveform", WAVEFORM);
    }

    private static <T extends Entity> void registerEntity(String id, EntityType<T> type) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier("waveform", id), type);
    }
}

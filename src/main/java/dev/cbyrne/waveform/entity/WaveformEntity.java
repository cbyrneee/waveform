package dev.cbyrne.waveform.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WaveformEntity extends AbstractDecorationEntity {
    public WaveformEntity(EntityType<? extends AbstractDecorationEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public int getWidthPixels() {
        return 12;
    }

    @Override
    public int getHeightPixels() {
        return 12;
    }

    @Override
    public void onBreak(@Nullable Entity entity) {
    }

    @Override
    public void onPlace() {
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this, this.facing.getId(), this.getDecorationBlockPos());
    }
}

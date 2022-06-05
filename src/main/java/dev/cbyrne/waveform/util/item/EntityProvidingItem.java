package dev.cbyrne.waveform.util.item;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

/**
 * Your class should be able to construct an entity type
 *
 * @param <T> The type of your entity
 */
public interface EntityProvidingItem<T extends Entity> {
    Provider<T> getEntityProvider();

    @FunctionalInterface
    interface Provider<T extends Entity> {
        T invoke(World world, BlockPos position, Direction direction);
    }
}

package dev.cbyrne.waveform.util.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.event.GameEvent;

/**
 * Mojang's default {@link DecorationItem} has a fatal flaw for extensibility: it doesn't automatically spawn the entity.
 * This class aims to solve that problem.
 */
public abstract class BetterDecorationItem<T extends AbstractDecorationEntity> extends DecorationItem implements EntityProvidingItem<T> {
    public BetterDecorationItem(EntityType<T> type, Settings settings) {
        super(type, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var direction = context.getSide();
        var position = context.getBlockPos().offset(direction);
        var entity = getEntityProvider().invoke(world, position, direction);

        if (entity.canStayAttached()) {
            if (!world.isClient) {
                entity.onPlace();
                world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, entity.getPos());
                world.spawnEntity(entity);
            }

            context.getStack().decrement(1);
            return ActionResult.success(world.isClient);
        }

        return ActionResult.CONSUME;
    }
}

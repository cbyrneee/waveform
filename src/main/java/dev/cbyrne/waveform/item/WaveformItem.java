package dev.cbyrne.waveform.item;

import dev.cbyrne.waveform.entity.WaveformEntity;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.event.GameEvent;

public class WaveformItem extends DecorationItem {
    public WaveformItem(EntityType<? extends AbstractDecorationEntity> type, Settings settings) {
        super(type, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var direction = context.getSide();
        var position = context.getBlockPos().offset(direction);
        var entity = WaveformEntity.create(world, position, direction);

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

    @Override
    protected boolean canPlaceOn(PlayerEntity player, Direction side, ItemStack stack, BlockPos pos) {
        var targetBlock = player.getWorld()
            .getBlockState(pos.offset(side, -1))
            .getBlock();

        // TODO: We should only allow one waveform on a jukebox at a time

        return super.canPlaceOn(player, side, stack, pos) && targetBlock instanceof JukeboxBlock;
    }
}

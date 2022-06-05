package dev.cbyrne.waveform.item;

import dev.cbyrne.waveform.entity.WaveformEntity;
import dev.cbyrne.waveform.util.item.BetterDecorationItem;
import dev.cbyrne.waveform.util.item.EntityProvidingItem;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class WaveformItem extends BetterDecorationItem<WaveformEntity> {
    public WaveformItem(EntityType<WaveformEntity> type, Settings settings) {
        super(type, settings);
    }

    @Override
    public EntityProvidingItem.Provider<WaveformEntity> getEntityProvider() {
        return WaveformEntity::create;
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

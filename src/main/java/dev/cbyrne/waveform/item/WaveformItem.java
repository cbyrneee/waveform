package dev.cbyrne.waveform.item;

import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class WaveformItem extends DecorationItem {
    public WaveformItem(EntityType<? extends AbstractDecorationEntity> type, Settings settings) {
        super(type, settings);
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

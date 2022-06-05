package dev.cbyrne.waveform.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.item.DecorationItem;

public class WaveformItem extends DecorationItem {
    public WaveformItem(EntityType<? extends AbstractDecorationEntity> type, Settings settings) {
        super(type, settings);
    }
}

package dev.cbyrne.waveform.registry;

import dev.cbyrne.waveform.item.WaveformItem;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("SameParameterValue")
public class ItemRegistry {
    public static final Item WAVEFORM_ITEM = new WaveformItem(EntityType.ITEM_FRAME, new Item.Settings().group(ItemGroup.DECORATIONS));

    private static final ItemRegistry INSTANCE = new ItemRegistry();

    public static ItemRegistry getInstance() {
        return INSTANCE;
    }

    public void register() {
        registerItem("waveform", WAVEFORM_ITEM);
    }

    private void registerItem(String id, Item item) {
        Registry.register(Registry.ITEM, new Identifier("waveform", id), item);
    }
}

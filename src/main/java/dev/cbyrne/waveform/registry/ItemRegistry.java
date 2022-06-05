package dev.cbyrne.waveform.registry;

import dev.cbyrne.waveform.item.WaveformItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("SameParameterValue")
public class ItemRegistry {
    public static final Item WAVEFORM_ITEM = new WaveformItem(EntityRegistry.WAVEFORM_ENTITY, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static void register() {
        registerItem("waveform", WAVEFORM_ITEM);
    }

    private static void registerItem(String id, Item item) {
        Registry.register(Registry.ITEM, new Identifier("waveform", id), item);
    }
}

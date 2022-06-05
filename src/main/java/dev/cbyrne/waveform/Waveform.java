package dev.cbyrne.waveform;

import com.mojang.logging.LogUtils;
import dev.cbyrne.waveform.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class Waveform implements ModInitializer {
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Registering items!");
        ItemRegistry.getInstance().register();
    }
}

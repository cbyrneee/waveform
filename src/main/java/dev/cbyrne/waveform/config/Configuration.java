package dev.cbyrne.waveform.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Excluded;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.client.gui.screen.Screen;

@Config(name = "waveform")
public class Configuration implements ConfigData {
    @Excluded
    private static Configuration INSTANCE;

    public static Configuration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = AutoConfig.register(Configuration.class, GsonConfigSerializer::new).get();
        }

        return INSTANCE;
    }

    public Screen getScreen(Screen parent) {
        return AutoConfig.getConfigScreen(Configuration.class, parent).get();
    }
}

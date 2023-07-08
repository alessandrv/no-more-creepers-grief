package com.alessandrv.nomorecreepersgrief.util.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
@Config(name = "nomorecreepersgrief")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.TransitiveObject
    public final CreepersOptions creepersOptions = new CreepersOptions();


    public static class CreepersOptions {
        @ConfigEntry.Gui.Tooltip(count = 3)
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public CreeperExplosionModes creeperExplosionModes = CreeperExplosionModes.TNT;
    }



    @Override
    public void validatePostLoad() {

    }
}
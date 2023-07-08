package com.alessandrv.nomorecreepersgrief;

import com.alessandrv.nomorecreepersgrief.util.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoMoreCreepersGrief implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	private static ModConfig config;
	private static World.ExplosionSourceType type;


	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		type= config.creepersOptions.creeperExplosionModes.getType();


	}
	public static ModConfig getConfig() {
		return config;
	}
	public static  World.ExplosionSourceType getType(){
		return type;
	}
}
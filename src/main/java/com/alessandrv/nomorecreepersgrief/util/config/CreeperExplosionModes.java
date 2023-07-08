package com.alessandrv.nomorecreepersgrief.util.config;


import net.minecraft.world.World;


public enum CreeperExplosionModes {
    TNT(World.ExplosionSourceType.TNT),
    MOB(World.ExplosionSourceType.MOB),
    NONE(World.ExplosionSourceType.NONE);

    private final World.ExplosionSourceType type;

    CreeperExplosionModes(World.ExplosionSourceType type) {
        this.type = type;
    }

    public World.ExplosionSourceType getType() {
        return type;
    }
}

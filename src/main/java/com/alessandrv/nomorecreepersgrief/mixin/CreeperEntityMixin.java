
package com.alessandrv.nomorecreepersgrief.mixin;

import com.alessandrv.nomorecreepersgrief.NoMoreCreepersGrief;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin extends HostileEntity {




    protected CreeperEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);

    }

    @Shadow private int explosionRadius;


    @Shadow public abstract boolean shouldRenderOverlay();

    @Shadow protected abstract void spawnEffectsCloud();

    /**
     * @author alessandrv
     * @reason non-griefing creepers
     */
    @Overwrite
    public void explode() {

        if (!this.getWorld().isClient) {
            float f = this.shouldRenderOverlay() ? 2.0F : 1.0F;
            this.dead = true;
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * f, NoMoreCreepersGrief.getType());
            this.discard();
            this.spawnEffectsCloud();
        }
    }
}

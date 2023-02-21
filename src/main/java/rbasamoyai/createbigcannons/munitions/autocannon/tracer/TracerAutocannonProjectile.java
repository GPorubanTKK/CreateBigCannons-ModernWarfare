package rbasamoyai.createbigcannons.munitions.autocannon.tracer;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;

public class TracerAutocannonProjectile extends AbstractAutocannonProjectile {

    public TracerAutocannonProjectile(EntityType<? extends TracerAutocannonProjectile> type, Level level) {
        super(type, level);
        setProjectileMass(10);
        setTracer(true);
        setGlowingTag(true);
        damage -= 3;
    }

    @Override
    public void tick() {
        super.tick();
        for(int i = 0; i < 3; i++) level.addParticle(ParticleTypes.CRIMSON_SPORE, getX(), getY(), getZ(), 0,0,0);
    }
}

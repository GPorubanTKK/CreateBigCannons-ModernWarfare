package rbasamoyai.createbigcannons.munitions.autocannon.incendiary;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;

public class IncendiaryAutocannonProjectile extends AbstractAutocannonProjectile {
    public IncendiaryAutocannonProjectile(EntityType<? extends AbstractAutocannonProjectile> type, Level level) {
        super(type, level);
        setProjectileMass(12);
        //set fire
    }
}

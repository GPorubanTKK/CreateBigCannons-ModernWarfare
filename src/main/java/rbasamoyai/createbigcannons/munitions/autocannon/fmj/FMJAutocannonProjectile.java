package rbasamoyai.createbigcannons.munitions.autocannon.fmj;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;

public class FMJAutocannonProjectile extends AbstractAutocannonProjectile {
    public FMJAutocannonProjectile(EntityType<? extends AbstractAutocannonProjectile> type, Level level) {
        super(type, level);
        setProjectileMass(12);
        damage -= 1.5;
    }
}

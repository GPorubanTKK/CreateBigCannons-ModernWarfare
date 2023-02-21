package rbasamoyai.createbigcannons.munitions.autocannon.subsonic;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;

public class SubsonicAutocannonProjectile extends AbstractAutocannonProjectile {

    public SubsonicAutocannonProjectile(EntityType<? extends SubsonicAutocannonProjectile> type, Level level) {
        super(type, level);
        setProjectileMass(9);
        damage = 12;
    }
}

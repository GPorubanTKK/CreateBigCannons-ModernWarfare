package rbasamoyai.createbigcannons.munitions.autocannon.tracer;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonRoundItem;

public class TracerAutocannonRoundItem extends AutocannonRoundItem {

    public TracerAutocannonRoundItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractAutocannonProjectile getAutocannonProjectile(ItemStack stack, Level level) {
        return CBCEntityTypes.TRACER_AUTOCANNON.create(level);
    }

}

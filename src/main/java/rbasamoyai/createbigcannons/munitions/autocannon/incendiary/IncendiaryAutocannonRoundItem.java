package rbasamoyai.createbigcannons.munitions.autocannon.incendiary;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonRoundItem;

public class IncendiaryAutocannonRoundItem extends AutocannonRoundItem {
    public IncendiaryAutocannonRoundItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractAutocannonProjectile getAutocannonProjectile(ItemStack stack, Level level) {
        return CBCEntityTypes.INCENDIARY_AUTOCANNON.create(level);
    }
}

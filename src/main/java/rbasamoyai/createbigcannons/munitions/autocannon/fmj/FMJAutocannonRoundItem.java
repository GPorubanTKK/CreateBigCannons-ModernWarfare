package rbasamoyai.createbigcannons.munitions.autocannon.fmj;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonRoundItem;

public class FMJAutocannonRoundItem extends AutocannonRoundItem {
    public FMJAutocannonRoundItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractAutocannonProjectile getAutocannonProjectile(ItemStack stack, Level level) {
        return CBCEntityTypes.FMJ_AUTOCANNON.create(level);
    }
}

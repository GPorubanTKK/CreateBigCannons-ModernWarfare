package rbasamoyai.createbigcannons.munitions.autocannon.hollowpt;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonRoundItem;

public class HPAutocannonRoundItem extends AutocannonRoundItem {

    public HPAutocannonRoundItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractAutocannonProjectile getAutocannonProjectile(ItemStack stack, Level level) {
        return CBCEntityTypes.HP_AUTOCANNON.create(level);
    }

}

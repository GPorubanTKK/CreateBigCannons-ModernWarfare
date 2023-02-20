package rbasamoyai.createbigcannons.munitions.big_cannon.chlorine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.AbstractCannonProjectile;
import rbasamoyai.createbigcannons.munitions.big_cannon.ProjectileBlock;

public class GasBlock extends ProjectileBlock {

    public GasBlock(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractCannonProjectile getProjectile(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity blockEntity) {
        return CBCEntityTypes.GENEVA_SUGGESTION.get().create(level);
    }
}

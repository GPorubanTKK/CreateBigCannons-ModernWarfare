package rbasamoyai.createbigcannons.munitions.big_cannon.smoke;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.AbstractCannonProjectile;
import rbasamoyai.createbigcannons.munitions.big_cannon.ProjectileBlock;

public class SmokeShellBlock extends ProjectileBlock {

    public SmokeShellBlock(Properties properties) {
        super(properties);
    }

    public AbstractCannonProjectile getProjectile(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity blockEntity) {
        return CBCEntityTypes.SMOKE.get().create(level);
    }
}

package rbasamoyai.createbigcannons.cannons.autocannon;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class Silencer extends AutocannonBarrelBlock {
    public Silencer(Properties properties) {
        super(properties, AutocannonMaterial.SILENCER);
    }

    @Override public boolean isFlammable(BlockState s, BlockGetter g, BlockPos p, Direction d) { return false; }

    @Override public Class<AutocannonBlockEntity> getTileEntityClass() { return AutocannonBlockEntity.class; }
}

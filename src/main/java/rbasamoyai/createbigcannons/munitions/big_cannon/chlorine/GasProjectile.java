package rbasamoyai.createbigcannons.munitions.big_cannon.chlorine;

import com.simibubi.create.content.contraptions.fluids.potion.PotionFluid;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidStack;
import rbasamoyai.createbigcannons.CBCBlocks;
import rbasamoyai.createbigcannons.CBCEntityTypes;
import rbasamoyai.createbigcannons.munitions.big_cannon.AbstractBigCannonProjectile;
import rbasamoyai.createbigcannons.munitions.big_cannon.fluid_shell.FluidBlob;
import rbasamoyai.createbigcannons.munitions.big_cannon.shrapnel.Shrapnel;

import java.util.List;

public class GasProjectile extends AbstractBigCannonProjectile {
    private final FluidStack fluid = PotionFluid.of(20000, Potions.STRONG_POISON);
    public GasProjectile(EntityType<? extends AbstractBigCannonProjectile> type, Level level) {
        super(type, level);
    }

    @Override
    protected void onDestroyBlock(BlockState state, BlockHitResult result) {}

    @Override
    protected void onFinalImpact(HitResult result) {
        if (!level.isClientSide) {
            Vec3 hitLoc = result.getLocation();
            detonate(hitLoc);
            this.discard();
        }
    }

    private void detonate(Vec3 pos){
        List<FluidBlob> blobs = Shrapnel.spawnShrapnelBurst(this.level, CBCEntityTypes.FLUID_BLOB.get(),pos,this.getDeltaMovement(), 20, 5, 0);
        for (FluidBlob blob: blobs) {
            FluidStack lPoison = fluid.copy();
            lPoison.setAmount(1000);
            blob.setFluidStack(lPoison);
        }
    }

    public BlockState getRenderedBlockState() {
        return CBCBlocks.GENEVA_SUGGESTION.getDefaultState().setValue(BlockStateProperties.FACING, Direction.NORTH);
    }

    @Override
    protected BounceType canBounce(BlockState state, BlockHitResult result) { return BounceType.NO_BOUNCE; }
}

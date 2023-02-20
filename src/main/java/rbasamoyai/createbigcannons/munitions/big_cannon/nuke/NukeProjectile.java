package rbasamoyai.createbigcannons.munitions.big_cannon.nuke;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import rbasamoyai.createbigcannons.CBCBlocks;
import rbasamoyai.createbigcannons.base.SoundRegisterer;
import rbasamoyai.createbigcannons.config.CBCCfgMunitions;
import rbasamoyai.createbigcannons.config.CBCConfigs;
import rbasamoyai.createbigcannons.munitions.big_cannon.AbstractBigCannonProjectile;

public class NukeProjectile extends AbstractBigCannonProjectile {
    public NukeProjectile(EntityType<? extends NukeProjectile> type, Level level){
        super(type,level);
        playSound(SoundRegisterer.mw2nuke_warn,200F,1F);
    }

    public BlockState getRenderedBlockState(){
        return CBCBlocks.NUKE.getDefaultState().setValue(BlockStateProperties.FACING, Direction.NORTH);
    }

    @Override
    protected void onFinalImpact(HitResult result) {
        if(!level.isClientSide) {
            Vec3 hitLoc = result.getLocation();
            level.explode(null, hitLoc.x, hitLoc.y, hitLoc.z, 256, Explosion.BlockInteraction.DESTROY).explode();
            playSound(SoundRegisterer.mw2nuke_explode, 300F, 1F);
            this.discard();
        }
    }

    @Override
    protected void onDestroyBlock(BlockState state, BlockHitResult result) {}

    @Override
    protected BounceType canBounce(BlockState state, BlockHitResult result) { return BounceType.NO_BOUNCE; }
}
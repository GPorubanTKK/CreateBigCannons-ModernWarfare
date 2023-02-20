package rbasamoyai.createbigcannons.munitions.big_cannon.white_phosphorous;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import rbasamoyai.createbigcannons.CBCBlocks;
import rbasamoyai.createbigcannons.config.CBCCfgMunitions;
import rbasamoyai.createbigcannons.config.CBCConfigs;
import rbasamoyai.createbigcannons.munitions.AbstractCannonProjectile;
import rbasamoyai.createbigcannons.munitions.big_cannon.AbstractBigCannonProjectile;

import java.util.ArrayList;
import java.util.List;

public class WPProjectile extends AbstractBigCannonProjectile {
    public WPProjectile(EntityType<? extends WPProjectile> type, Level level){
        super(type,level);
    }

    public BlockState getRenderedBlockState(){
        return CBCBlocks.WHITE_PHOSPHOROUS.getDefaultState().setValue(BlockStateProperties.FACING, Direction.NORTH);
    }

    @Override
    protected void onFinalImpact(HitResult result) {
        if(!level.isClientSide) {
            fire(result.getLocation(), 10);
            this.discard();
        }
    }

     @Override
     protected BounceType canBounce(BlockState state, BlockHitResult result) { return BounceType.NO_BOUNCE; }

    private void fire(Vec3 location, int radius){
        level.explode(this, location.x, location.y, location.z, 0.1f*radius, Explosion.BlockInteraction.DESTROY);
        ArrayList<Block> targets = new ArrayList<>(List.of(Blocks.AIR,Blocks.GRASS,Blocks.TALL_GRASS,Blocks.VINE));
        int xStart = (int)(location.x-radius), xMax = (int)(location.x+radius);
        int yStart = (int)(location.y-2), yMax = (int)(location.y+radius);
        int zStart = (int)(location.z-radius), zMax = (int)(location.z+radius);
        for(int xRow = xStart, col = yStart, zRow = zStart; col < yMax; xRow++) {
            Block blockAtLoc = level.getBlockState(new BlockPos(new Vec3(xRow,col,zRow))).getBlock();
            if(targets.contains(blockAtLoc)){
                level.setBlockAndUpdate(new BlockPos(new Vec3(xRow,col,zRow)), Blocks.FIRE.defaultBlockState());
            }
            if (xRow == xMax) {
                xRow = xStart;
                zRow++;
            }
            if (zRow == zMax) {
                xRow = xStart;
                zRow = zStart;
                col++;
            }
        }
    }

    @Override
    protected void onDestroyBlock(BlockState state, BlockHitResult result) {}
}
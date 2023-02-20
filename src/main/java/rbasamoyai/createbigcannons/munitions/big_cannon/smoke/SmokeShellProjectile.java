package rbasamoyai.createbigcannons.munitions.big_cannon.smoke;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import rbasamoyai.createbigcannons.CBCBlocks;
import rbasamoyai.createbigcannons.cannon_control.effects.CannonSmokeParticleData;
import rbasamoyai.createbigcannons.config.CBCCfgMunitions;
import rbasamoyai.createbigcannons.config.CBCConfigs;
import rbasamoyai.createbigcannons.munitions.big_cannon.AbstractBigCannonProjectile;

public class SmokeShellProjectile extends AbstractBigCannonProjectile {
    Vec3 hitLoc;
    public SmokeShellProjectile(EntityType<? extends AbstractBigCannonProjectile> type, Level level) {
        super(type, level);
    }

    public BlockState getRenderedBlockState() {
        return CBCBlocks.SMOKE.getDefaultState().setValue(BlockStateProperties.FACING, Direction.NORTH);
    }
    @Override
    protected void onFinalImpact(HitResult result) {
        if (!this.level.isClientSide) {
            hitLoc = result.getLocation();
            if (CBCConfigs.SERVER.munitions.damageRestriction.get() == CBCCfgMunitions.GriefState.NO_DAMAGE) {
                this.level.explode(null, hitLoc.x, hitLoc.y, hitLoc.z, 2, Explosion.BlockInteraction.NONE);
            }
            this.setInGround(true);
            this.setPos(hitLoc);
            //smoke(5);
            level.setBlockAndUpdate(new BlockPos(hitLoc),Blocks.DIAMOND_BLOCK.defaultBlockState());
            this.discard();
        }
    }

    public void smoke(int radius){
        int xStart = (int)(hitLoc.x-radius), xMax = (int)(hitLoc.x+radius);
        int yStart = (int)(hitLoc.y), yMax = (int)(hitLoc.y+radius);
        int zStart = (int)(hitLoc.z-radius), zMax = (int)(hitLoc.z+radius);
        for(int xRow = xStart, col = yStart, zRow = zStart; col < yMax; xRow++) {
            Vec3 pos = new Vec3(xRow,col,zRow);
            //playSound(SoundRegisterer.smoke_shell_hiss, 10F, 0.01F); //shitty sound.  fix.
            //spawn particles try using /particle????

            Vector3f startColor = new Vector3f(0,0,0), endColor = new Vector3f(0.2F,0.2F,0.2F);
            ParticleOptions particle = new CannonSmokeParticleData(100,startColor,endColor,1000);
            this.level.addParticle(particle,xRow,col,xRow,0,0,0);
            if (xRow >= xMax) {
                xRow = xStart;
                zRow++;
            }
            if (zRow >= zMax) {
                xRow = xStart;
                zRow = zStart;
                col++;
            }
        }
    }

    @Override
    protected BounceType canBounce(BlockState state, BlockHitResult result) { return BounceType.NO_BOUNCE; }
}

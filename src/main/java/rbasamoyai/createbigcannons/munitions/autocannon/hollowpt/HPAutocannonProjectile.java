package rbasamoyai.createbigcannons.munitions.autocannon.hollowpt;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;

public class HPAutocannonProjectile extends AbstractAutocannonProjectile {

    public HPAutocannonProjectile(EntityType<? extends HPAutocannonProjectile> type, Level level) {
        super(type, level);
        setProjectileMass(12);
        damage = 20;
    }
    @Override public void onHitBlock(@NotNull BlockHitResult result) {}
    @Override public void onDestroyBlock(BlockState state, BlockHitResult bhr){}
    @Override public void onHitEntity(@NotNull EntityHitResult result) {
        if(!level.isClientSide) ((LivingEntity)result.getEntity()).addEffect(new MobEffectInstance(MobEffects.WITHER, 12, 2));
    }
}
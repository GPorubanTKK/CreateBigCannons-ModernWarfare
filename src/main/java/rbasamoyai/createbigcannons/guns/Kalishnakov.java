package rbasamoyai.createbigcannons.guns;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Deque;
import java.util.LinkedList;

public class Kalishnakov extends Item {
    private final int bufSize = 1;
    private final Deque<ItemStack> buffer = new LinkedList<>();

    public Kalishnakov(Properties p) { super(p); }

    @Override public boolean canAttackBlock(@NotNull BlockState bs, @NotNull Level l, @NotNull BlockPos bp, @NotNull Player p) { return false; }
    @Override public InteractionResultHolder<ItemStack> use(Level l, Player p, InteractionHand h) {
        p.getCooldowns().addCooldown(this, 20);
        shoot(l);
        return InteractionResultHolder.pass(p.getItemInHand(h));
    }

    private void shoot(Level l) {
        if(!l.isClientSide) {
            fire();
        }
        extractFromInventory();
    }

    private void fire() {

    }

    private void extractFromInventory() {

    }
}
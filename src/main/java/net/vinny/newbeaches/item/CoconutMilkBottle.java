package net.vinny.newbeaches.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CoconutMilkBottle extends Item {
    public CoconutMilkBottle(Item.Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.SLOWNESS);
            user.removeStatusEffect(StatusEffects.POISON);
            user.removeStatusEffect(StatusEffects.BAD_OMEN);
            user.removeStatusEffect(StatusEffects.BLINDNESS);
            user.removeStatusEffect(StatusEffects.DARKNESS);
            user.removeStatusEffect(StatusEffects.HUNGER);
            user.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            user.removeStatusEffect(StatusEffects.UNLUCK);
            user.removeStatusEffect(StatusEffects.WEAKNESS);
            user.removeStatusEffect(StatusEffects.WITHER);
        }
        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
            PlayerEntity playerEntity = (PlayerEntity)user;
            if (!playerEntity.getInventory().insertStack(itemStack)) {
                playerEntity.dropItem(itemStack, false);
            }
        }
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}

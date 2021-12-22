package net.blocmc.dairymod;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DairyMod.MODID, bus= Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventHandler {
    
    @SubscribeEvent
    public static void onRightClickToAnimal( PlayerInteractEvent.EntityInteract event){

        InteractionHand hand = event.getHand();
        if (hand == InteractionHand.MAIN_HAND) {
            LivingEntity player = event.getPlayer();
            Entity entity = event.getTarget();
            ItemStack stacks = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (!player.isSpectator() && !stacks.isEmpty() && stacks.is( Items.BOWL )
                    && (entity.getType() ==  EntityType.COW  || entity.getType() == EntityType.SHEEP)) {
                int count = stacks.getCount();
                if (count == 1) {
                    ItemStack newStack = new ItemStack( DairyMod.ItemInitializer.MILK_BOWL_ITEM.get() );
                    player.setItemInHand(InteractionHand.MAIN_HAND, newStack);
                } else {
                    ItemStack stack = new ItemStack( DairyMod.ItemInitializer.MILK_BOWL_ITEM.get());
                    ItemEntity itemEntity = new ItemEntity(player.level, player.getX(), player.getY(),
                            player.getZ(), stack);
                    itemEntity.spawnAtLocation( stack );
                    stacks.setCount(count - 1);
                    player.setItemInHand(InteractionHand.MAIN_HAND, stacks);
                }
            }
        }

    }

    @SubscribeEvent
    public static void onUseItem( LivingEntityUseItemEvent.Finish event ){
        
        LivingEntity player = event.getEntityLiving();
        Item item = event.getItem().getItem();
        if (!player.isSpectator() && item != null) {
            // Handle poison treatment with yogurt
            if (item == DairyMod.ItemInitializer.YOGURT_ITEM.get() && player.hasEffect(MobEffects.POISON)) {
                player.removeEffect(MobEffects.POISON);
            }
            // If on fire, put out fire
            if (player.isOnFire() && item == DairyMod.ItemInitializer.ICECREAM_ITEM.get()) {
                player.clearFire();
            }
            if (item == DairyMod.ItemInitializer.BUTTER_ITEM.get()) {
                player.addEffect( new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*3));
            }
        }

    }
}

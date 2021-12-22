package net.blocmc.dairymod;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;

public interface FinishUsingItemCallback { 
    Event<FinishUsingItemCallback> EVENT = EventFactory.createArrayBacked(FinishUsingItemCallback.class,
        (listeners) -> (player, item) -> {
            for (FinishUsingItemCallback listener : listeners) {
                ActionResult result = listener.interact(player, item);
 
                if(result != ActionResult.PASS) {
                    return result;
                }
            }
        return ActionResult.PASS;
    });
    ActionResult interact(LivingEntity user, Item item);
}
package net.blocmc.dairymod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.blocmc.dairymod.FinishUsingItemCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

@Mixin(Item.class)
public class ItemFinishUsingMixin {
    @Inject(at = @At("INVOKE"), method = "finishUsing")
    private void onShear(final ItemStack stack, final World world, final LivingEntity user, final CallbackInfoReturnable<Boolean> info) {
        ActionResult result = FinishUsingItemCallback.EVENT.invoker().interact(user, (Item) (Object) this);
        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}
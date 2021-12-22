package net.blocmc.dairymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DairyMod implements ModInitializer {

	// Adding items
	public static final Item CHEESE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(2).saturationModifier(6f).build()));
	public static final Item YOGURT_ITEM = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(2).saturationModifier(7f).alwaysEdible().build()));
	public static final Item ICECREAM_ITEM = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(4).saturationModifier(3f).alwaysEdible().build()));
	public static final Item BUTTER_ITEM = new Item(new FabricItemSettings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(3).saturationModifier(5f).alwaysEdible().build()));
	public static final Item MILK_BOWL_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("dairy", "milk_bowl_item"), MILK_BOWL_ITEM);
		Registry.register(Registry.ITEM, new Identifier("dairy", "cheese_item"), CHEESE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("dairy", "icecream_item"), ICECREAM_ITEM);
		Registry.register(Registry.ITEM, new Identifier("dairy", "butter_item"), BUTTER_ITEM);
		Registry.register(Registry.ITEM, new Identifier("dairy", "yogurt_item"), YOGURT_ITEM);

		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (hand == Hand.MAIN_HAND) {
				ItemStack stacks = player.getMainHandStack();
				if (!player.isSpectator() && !stacks.isEmpty() && stacks.isOf(Items.BOWL)
						&& (entity.getType() == EntityType.COW || entity.getType() == EntityType.SHEEP)) {
					int count = stacks.getCount();
					if (count == 1) {
						ItemStack newStack = new ItemStack(MILK_BOWL_ITEM);
						player.setStackInHand(Hand.MAIN_HAND, newStack);
					} else {
						ItemStack stack = new ItemStack(MILK_BOWL_ITEM);
						ItemEntity itemEntity = new ItemEntity(player.world, player.getX(), player.getY(),
								player.getZ(), stack);
						player.world.spawnEntity(itemEntity);
						stacks.setCount(count - 1);
						player.setStackInHand(Hand.MAIN_HAND, stacks);
					}
				}
			}
			return ActionResult.PASS;
		});

		FinishUsingItemCallback.EVENT.register((player, item) -> {
			if (!player.isSpectator() && item != null) {
				// Handle poison treatment with yogurt
				if (item == YOGURT_ITEM && player.hasStatusEffect(StatusEffects.POISON)) {
					player.removeStatusEffect(StatusEffects.POISON);
				}
				// If on fire, put out fire
				if (player.isOnFire() && item == ICECREAM_ITEM) {
					player.extinguish();
				}
				if (item == BUTTER_ITEM) {
					player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 3));
				}
			}
			return ActionResult.PASS;
		});
	}
}

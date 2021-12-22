package net.blocmc.dairymod;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(value = DairyMod.MODID)
public class DairyMod {	
    public static final String MODID = "dairymod";

    public DairyMod() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInitializer.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

	public final class ItemInitializer{
		public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DairyMod.MODID);

		public static final RegistryObject<Item> CHEESE_ITEM = ITEMS.register("cheese_item",  () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(
			new FoodProperties.Builder().nutrition(2).saturationMod(6f).build())));
		public static final RegistryObject<Item> YOGURT_ITEM = ITEMS.register("yogurt_item",  () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(
			new FoodProperties.Builder().nutrition(2).saturationMod(7f).alwaysEat().build())));
		public static final RegistryObject<Item> ICECREAM_ITEM = ITEMS.register("icecream_item",  () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(
			new FoodProperties.Builder().nutrition(4).saturationMod(3f).alwaysEat().build())));
		public static final RegistryObject<Item> BUTTER_ITEM = ITEMS.register("butter_item",  () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(
			new FoodProperties.Builder().nutrition(3).saturationMod(5f).alwaysEat().build())));
		public static final RegistryObject<Item> MILK_BOWL_ITEM = ITEMS.register("milk_bowl_item",  () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	}
}

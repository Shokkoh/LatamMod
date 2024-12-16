package com.shokkoh.latammod.init;

import com.shokkoh.latammod.LatamMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("ALL")
public class MainItems {
	public static Item.Properties properties = new Item.Properties();
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LatamMod.MOD_ID);

	// Item ejemplo
	public static final RegistryObject<Item> HOLAXD = regItem("holaxd");

	public static RegistryObject<Item> regItem(String name) {
		return ITEMS.register(name, () -> new Item(properties.stacksTo(64)));
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}

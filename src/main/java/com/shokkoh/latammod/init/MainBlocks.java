package com.shokkoh.latammod.init;

import com.shokkoh.latammod.LatamMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class MainBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LatamMod.MOD_ID);

	// Bloque ejemplo :P
	public static final RegistryObject<Block> PAPUBLOQUE = registerBlock("papubloque",
			() -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK)));

	private static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
		RegistryObject<Block> registeredObject = BLOCKS.register(name, supplier);
		//Registramos bloques como items también, así ahorramos el registrarlos también en el MainItems y se hace únicamente aquí.
		MainItems.ITEMS.register(name, () -> new BlockItem(registeredObject.get(), new Item.Properties()));
		return registeredObject;
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
}

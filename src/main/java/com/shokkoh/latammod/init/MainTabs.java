package com.shokkoh.latammod.init;

import com.shokkoh.latammod.LatamMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class MainTabs {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LatamMod.MOD_ID);

	public static final RegistryObject<CreativeModeTab> BLOQUES_TAB = TABS.register("latammod_blocks_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(MainBlocks.PAPUBLOQUE.get()))

					.title(Component.translatable("itemGroup.latammod.blocks"))
					.displayItems((parameters, output) -> MainBlocks.BLOCKS.getEntries().forEach((block) -> {
						output.accept(block.get().asItem());
					})).build()
	);

	public static void register(IEventBus bus) {
		TABS.register(bus);
	}
}

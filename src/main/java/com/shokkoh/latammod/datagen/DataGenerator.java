package com.shokkoh.latammod.datagen;

import com.shokkoh.latammod.LatamMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = LatamMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		net.minecraft.data.DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup .Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		generator.addProvider(event.includeServer(), new LatAdvancementsProvider(packOutput, lookupProvider));
		generator.addProvider(event.includeServer(), LatBlockLootTables.LatLootTableProvider.create(packOutput));
		generator.addProvider(event.includeServer(), new LatBlockStateProvider(packOutput, existingFileHelper));
		generator.addProvider(event.includeServer(), new LatBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
		generator.addProvider(event.includeServer(), new LatItemModelProvider(packOutput, existingFileHelper));
		generator.addProvider(event.includeServer(), new LatRecipeProvider(packOutput));

		LatBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(), new LatBlockTagGenerator(packOutput,
				lookupProvider, existingFileHelper));
		generator.addProvider(event.includeServer(), new LatItemTagGenerator(packOutput, lookupProvider,
				blockTagGenerator.contentsGetter(), existingFileHelper));

	}
}

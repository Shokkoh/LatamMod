package com.shokkoh.latammod.datagen;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.MainBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LatBlockStateProvider extends BlockStateProvider {
	public LatBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, LatamMod.MOD_ID, existingFileHelper);
	}

	@Override
	public void registerStatesAndModels() {
		// Registramos los bloques
		 blockWithItem(MainBlocks.PAPUBLOQUE);
	}

	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
	private void blockItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(LatamMod.MOD_ID +
				":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
	}
	private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
				new ResourceLocation("minecraft:block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
	}
}

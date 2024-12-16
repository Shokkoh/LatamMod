package com.shokkoh.latammod.datagen;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.MainItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LatItemModelProvider extends ItemModelProvider {
	public LatItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, LatamMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(MainItems.HOLAXD);
	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(LatamMod.MOD_ID, "item/" + item.getId().getPath()));
	}
	private ItemModelBuilder armorItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(LatamMod.MOD_ID, "item/armors/" + item.getId().getPath()));
	}
	private ItemModelBuilder blockItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(LatamMod.MOD_ID, "block/" + item.getId().getPath()));
	}
	private ItemModelBuilder blockAsItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(LatamMod.MOD_ID, "item/" + item.getId().getPath()));
	}
	public void simpleBlockItem(RegistryObject<Block> block) {
		this.withExistingParent(LatamMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
				modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
	}
}

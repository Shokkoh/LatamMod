package com.shokkoh.latammod.datagen;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.MainBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LatItemTagGenerator extends ItemTagsProvider {
	public LatItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
							   CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags, LatamMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
				.add(MainBlocks.PAPUBLOQUE.get().asItem());
	}
}

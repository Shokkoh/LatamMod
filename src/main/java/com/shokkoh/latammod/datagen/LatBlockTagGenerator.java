package com.shokkoh.latammod.datagen;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.MainBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LatBlockTagGenerator extends BlockTagsProvider {
	public LatBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, LatamMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		this.tag(BlockTags.NEEDS_STONE_TOOL)
				.add(MainBlocks.PAPUBLOQUE.get());

		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(MainBlocks.PAPUBLOQUE.get());
	}
}

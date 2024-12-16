package com.shokkoh.latammod.datagen;

import com.shokkoh.latammod.init.MainBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class LatBlockLootTables extends BlockLootSubProvider {
	public LatBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate () {
		// Bloques que se dropean a sí mismos
		this.dropSelf(MainBlocks.PAPUBLOQUE.get());

		// Bloques que dropean otros items
		//this.add(MainBlocks.NAMEK_DIAMOND_ORE.get(),
		//		block -> SingleOreDrop(MainBlocks.NAMEK_DIAMOND_ORE.get(), Items.DIAMOND));

		// Bloques que se dropean si se rompen con Silk Touch, si no, dropea el segundo bloque
		//this.add(MainBlocks.NAMEK_STONE.get(), block -> SilkTouchBlockDrop(MainBlocks.NAMEK_STONE.get(), MainBlocks.NAMEK_COBBLESTONE.get()));
	}

	//Ores que dropeen más de un item (Ej: Lapis, Cobre)
	protected LootTable.Builder MultiOreDrop(Block pBlock, Item item) {
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(item)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
								.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}
	protected LootTable.Builder CopperOreDrop(Block pBlock, Item item) {
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(item)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
								.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}

	//Ores que dropeen un solo item (Ej: Diamante, Oro)
	protected LootTable.Builder SingleOreDrop(Block pBlock, Item item) {
		return createSilkTouchDispatchTable(pBlock,
				this.applyExplosionDecay(pBlock,
						LootItem.lootTableItem(item)
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
								.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}

	protected LootTable.Builder SilkTouchBlockDrop(Block pBlock, Block pDrop) {
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(pBlock)
								.when(HAS_SILK_TOUCH))
						.add(LootItem.lootTableItem(pDrop)
								.when(HAS_NO_SILK_TOUCH)));
	}
	protected LootTable.Builder ShearsOnlyDrop(Block pBlock) {
		return LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(pBlock)
								.when(HAS_SHEARS))
						.add(EmptyLootItem.emptyItem()
								.when(HAS_SHEARS.invert())));
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return MainBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}

	public class LatLootTableProvider {
		public static LootTableProvider create(PackOutput output) {
			return new LootTableProvider(output, Set.of(), List.of(
					new LootTableProvider.SubProviderEntry(LatBlockLootTables::new, LootContextParamSets.BLOCK)
			));
		}
	}
}

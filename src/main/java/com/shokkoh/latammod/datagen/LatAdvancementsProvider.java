package com.shokkoh.latammod.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class LatAdvancementsProvider extends AdvancementProvider {
	private static ServerLevel serverLevel;

	public LatAdvancementsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(packOutput, registries, List.of(new LatAdvancements()));
	}

	private static class LatAdvancements implements AdvancementSubProvider {
		@Override
		public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer) {

			Advancement root = Advancement.Builder.advancement()
					.display(
							Items.ACACIA_BOAT, // Ítem de muestra
							Component.translatable("advancements.latammod.root.title"), // Título
							Component.translatable("advancements.latammod.root.description"), // Descripción
							new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Textura de fondo
							FrameType.TASK, true, true, false
					) // Tipo de marco, si se muestra en la esquina superior derecha, si se muestra en el chat y si se oculta en los Logros ("Logro Oculto/Secreto")
					.addCriterion("first_spawn_in_world", // Nombre del criterio
							PlayerTrigger.TriggerInstance.located(EntityPredicate.Builder.entity().of(EntityType.PLAYER).build())) // Criterio
					.rewards(AdvancementRewards.Builder.experience(0)) // Recompensa de experiencia (Se pueden poner más tipos xd)
					.save(consumer, "latammod:root"); // Logro "raíz" o "inicial"; el primero de todos.
		}
	}
}

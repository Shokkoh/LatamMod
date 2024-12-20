package com.shokkoh.latammod.init;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.entity.custom.ThiagoEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = LatamMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainEntity {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_REGISTER =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LatamMod.MOD_ID);

    public static final RegistryObject<EntityType<ThiagoEntity>> THIAGO_DUENDE =
            ENTITY_TYPES_REGISTER.register("thiago",
                    () -> EntityType.Builder.of(ThiagoEntity::new, MobCategory.CREATURE)
                            .sized(4.5f, 4.8f)
                            .build(new ResourceLocation(LatamMod.MOD_ID, "thiago").toString())
            );

//    @SubscribeEvent
//    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent e) {
//        e.register(MainEntity.DINO1.get(),
//                ON_GROUND,
//                MOTION_BLOCKING,
//                Animal::checkAnimalSpawnRules,
//                REPLACE);
//    }

    public static void register(IEventBus bus) {
        ENTITY_TYPES_REGISTER.register(bus);
    }
}

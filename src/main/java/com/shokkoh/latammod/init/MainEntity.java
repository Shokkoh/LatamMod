package com.shokkoh.latammod.init;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.entity.custom.CuyEntity;
import com.shokkoh.latammod.init.entity.custom.ThiagoEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MainEntity {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_REGISTER =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LatamMod.MOD_ID);

    public static final RegistryObject<EntityType<ThiagoEntity>> THIAGO_DUENDE =
            ENTITY_TYPES_REGISTER.register("thiago",
                    () -> EntityType.Builder.of(ThiagoEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(LatamMod.MOD_ID, "thiago").toString())
            );
    public static final RegistryObject<EntityType<CuyEntity>> CUY =
            ENTITY_TYPES_REGISTER.register("cuy",
                    () -> EntityType.Builder.of(CuyEntity::new, MobCategory.CREATURE)
                            .sized(0.3f, 0.3f)
                            .build(new ResourceLocation(LatamMod.MOD_ID, "cuy").toString())
            );



    public static void register(IEventBus bus) {
        ENTITY_TYPES_REGISTER.register(bus);
    }
}

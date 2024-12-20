package com.shokkoh.latammod;

import com.shokkoh.latammod.init.MainBlocks;
import com.shokkoh.latammod.init.MainEntity;
import com.shokkoh.latammod.init.MainItems;
import com.shokkoh.latammod.init.MainTabs;
import com.shokkoh.latammod.init.entity.client.renderer.ThiagoRenderer;
import com.shokkoh.latammod.init.entity.custom.ThiagoEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LatamMod.MOD_ID)
public class LatamMod {
    public static final String MOD_ID = "latammod";

    public LatamMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MainBlocks.register(modEventBus);
        MainItems.register(modEventBus);
        MainTabs.register(modEventBus);
        MainEntity.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        System.out.println("HOLA PES TILINASO");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        System.out.println("Server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {

                //Entidades
                EntityRenderers.register(MainEntity.THIAGO_DUENDE.get(), ThiagoRenderer::new);

            });
        }
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents
    {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

            event.put(MainEntity.THIAGO_DUENDE.get(), ThiagoEntity.setAttributes());

        }

    }

}

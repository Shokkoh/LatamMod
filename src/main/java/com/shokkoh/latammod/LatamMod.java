package com.shokkoh.latammod;

import com.shokkoh.latammod.init.MainBlocks;
import com.shokkoh.latammod.init.MainItems;
import com.shokkoh.latammod.init.MainTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
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
            System.out.println("Client setup");
        }
    }
}

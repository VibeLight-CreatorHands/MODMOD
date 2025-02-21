package com.yuyuto.galaxyall;

import com.yuyuto.galaxyall.config.Config;
import com.yuyuto.galaxyall.registry.ModBlocks;
import com.yuyuto.galaxyall.registry.ModCreativeTabs;
import com.yuyuto.galaxyall.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(GalaxyAll.MODID)
public class GalaxyAll {
    public static final String MODID = "galaxyall";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public GalaxyAll() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 各種登録クラスを初期化
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // イベントリスナーを登録
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // コンフィグの登録
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup initialized.");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server is starting!");
    }
}

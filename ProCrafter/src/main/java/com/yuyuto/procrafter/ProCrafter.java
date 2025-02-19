package com.yuyuto.procrafter;

import com.yuyuto.procrafter.registry.*;
import com.yuyuto.procrafter.event.PlayerSkillPointHandler;
import com.yuyuto.procrafter.skill.SkillData;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

/**  
 * ProCrafter MOD 
 *MOD ID: `procrafter`  
 *アイテム・ブロック・GUI などを管理  
 */
@Mod(ProCrafter.MODID)
public class ProCrafter {
    public static final String MODID = "procrafter";
    private static final Logger LOGGER = LogUtils.getLogger();

    /** MODの初期化 */
    public ProCrafter() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ✅ レジストリの登録
        registerModComponents(eventBus);

        // ✅ イベント登録
        eventBus.addListener(this::onCommonSetup);
        eventBus.addListener(this::onAddCreativeTabs);
        MinecraftForge.EVENT_BUS.register(this);

        // ✅ 設定ファイルの登録
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    /**  
     *📌 MODのコンポーネント（アイテム・ブロックなど）を登録 
     */
    private void registerModComponents(IEventBus eventBus) {
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModScreenHandlers.register(eventBus);
        ModSounds.register(eventBus);
        ModCreativeModeTabs.register(eventBus);
    }

    /**  
     *📌 共通セットアップ（サーバー＆クライアント）  
     */
    private void onCommonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("🔹 共通セットアップ開始");

        if (Config.logDirtBlock) {
            LOGGER.info("🌱 土ブロックID >> {}", Registries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("✨ Magic Number: {}", Config.magicNumber);
        Config.items.forEach(item -> LOGGER.info("🛒 アイテム登録 >> {}", item));
    }

    /**  
     *📌 クリエイティブモードタブへアイテムを追加
     */
    private void onAddCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeModeTabs.PROCRAFTER_TAB) {
            event.accept(ModItems.EXAMPLE_ITEM);
        }
    }

    /**  
     * **📌 サーバー起動時のイベント**  
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("🖥️ サーバー起動開始...");
    }

    /**  
     * **📌 クライアント専用のイベント**  
     */
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("🎮 クライアントセットアップ...");
             // HUDを登録
            event.enqueueWork(() -> {
            MinecraftForge.EVENT_BUS.register(SkillPointOverlay.class);
            });
        }
    }
}

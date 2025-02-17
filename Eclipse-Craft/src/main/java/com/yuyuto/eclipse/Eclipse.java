package com.yuyuto.eclipse;

import com.yuyuto.eclipse.block.ModBlocks;
import com.yuyuto.eclipse.item.ModItems;
import com.yuyuto.eclipse.entity.ModEntities;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Eclipse.MOD_ID)
public class Eclipse {
    // MOD ID
    public static final String MOD_ID = "eclipse";

    // ログ出力用のLogger
    private static final Logger LOGGER = LogManager.getLogger();

    // コンストラクタ
    public Eclipse() {
        // イベントバスを取得
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 共通セットアップイベントの登録
        modEventBus.addListener(this::commonSetup);

        // アイテム、ブロック、エンティティの登録
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        // サーバーイベントの登録
        LOGGER.info("EclipseCraft MOD Loaded!");
    }

    /**
     * 共通セットアップ処理
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("EclipseCraft: Common setup initialized.");
        // ネットワーク設定や他MODとの互換処理を記述
    }

    /**
     * クライアント専用のセットアップ処理
     */
    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("EclipseCraft: Client setup initialized.");
        // クライアントサイド専用の処理（例: モデルのレンダリング登録）
    }

    /**
     * サーバー開始時の処理
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("EclipseCraft: Server is starting!");
        // サーバー専用の処理（例: カスタムコマンド登録）
    }
}

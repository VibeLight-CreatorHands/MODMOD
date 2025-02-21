package com.yuyuto.galaxyall;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Configクラス：MODの設定を管理するためのクラス。
 * Forgeの設定APIを使用しており、設定変更時にデータを反映します。
 */
@Mod.EventBusSubscriber(modid = GalaxyAll.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    // コンフィグのビルダー
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // 設定項目：Dirtブロックのログ出力
    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Dirtブロックの情報をCommon Setup時にログ出力するかどうか")
            .define("logDirtBlock", true);

    // 設定項目：魔法の数値
    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("魔法の数値（範囲：0～Integerの最大値）")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    // 設定項目：魔法の数値に関する説明
    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("魔法の数値の紹介文")
            .define("magicNumberIntroduction", "The magic number is... ");

    // 設定項目：リソースロケーション文字列のリスト
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("Common Setup時にログ出力するアイテムのリスト")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

    // コンフィグの仕様を確定
    static final ForgeConfigSpec SPEC = BUILDER.build();

    // 設定値のキャッシュ
    public static boolean logDirtBlock;
    public static int magicNumber;
    public static String magicNumberIntroduction;
    public static Set<Item> items;

    /**
     * リソースロケーション文字列が正しいか検証します。
     *
     * @param obj 入力オブジェクト
     * @return 正しいリソースロケーションの場合はtrue、それ以外はfalse
     */
    private static boolean validateItemName(final Object obj) {
        if (obj instanceof String itemName) {
            ResourceLocation location = new ResourceLocation(itemName);
            return BuiltInRegistries.ITEM.containsKey(location);
        }
        return false;
    }

    /**
     * コンフィグの読み込み時に値をキャッシュします。
     *
     * @param event ModConfigEvent
     */
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // 各設定値をキャッシュに保存
        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // リソースロケーション文字列をItemセットに変換
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> BuiltInRegistries.ITEM.get(new ResourceLocation(itemName)))
                .collect(Collectors.toSet());
    }
}

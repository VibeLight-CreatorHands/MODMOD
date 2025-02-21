package com.yuyuto.procrafter.registry;

import com.yuyuto.procrafter.items.GunItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.yuyuto.procrafter.ProCrafter;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProCrafter.MOD_ID);

    // 銃の登録
    public static final RegistryObject<Item> PISTOL = ITEMS.register("pistol", 
            () -> new GunItem(5, 20, 6, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> RIFLE = ITEMS.register("rifle", 
            () -> new GunItem(10, 30, 10, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> SHOTGUN = ITEMS.register("shotgun", 
            () -> new GunItem(15, 40, 5, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> SNIPER_RIFLE = ITEMS.register("sniper_rifle", 
            () -> new GunItem(25, 50, 5, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> SMG = ITEMS.register("smg", 
            () -> new GunItem(8, 20, 30, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> ASSAULT_RIFLE = ITEMS.register("assault_rifle", 
            () -> new GunItem(12, 25, 20, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> MACHINE_GUN = ITEMS.register("machine_gun", 
            () -> new GunItem(10, 15, 100, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));
    public static final RegistryObject<Item> GATLING_GUN = ITEMS.register("gatling_gun", 
            () -> new GunItem(20, 50, 200, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1)));

    // 新しい銃を追加
    public static final RegistryObject<Item> MINI_GUN = ITEMS.register("mini_gun", 
            () -> new GunItem(25, 40, 100, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1))); // 小型の機関銃
    public static final RegistryObject<Item> LASER_RIFLE = ITEMS.register("laser_rifle", 
            () -> new GunItem(15, 35, 50, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1))); // レーザーライフル
    public static final RegistryObject<Item> FLAME_THROWER = ITEMS.register("flame_thrower", 
            () -> new GunItem(12, 20, 3, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1))); // 火炎放射器
    public static final RegistryObject<Item> PLASMA_GUN = ITEMS.register("plasma_gun", 
            () -> new GunItem(30, 60, 10, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1))); // プラズマガン
    public static final RegistryObject<Item> STUN_GUN = ITEMS.register("stun_gun", 
            () -> new GunItem(5, 15, 1, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1))); // スタンガン
    public static final RegistryObject<Item> CROSSBOW = ITEMS.register("crossbow", 
            () -> new GunItem(18, 35, 15, new Item.Properties().tab(CreativeModeTabs.BUILDING_BLOCKS).stacksTo(1))); // クロスボウ

    // 魔法アイテムなど
    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> NEOMAGIC_DUST = ITEMS.register("neomagic_dust",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> GRINGHAM_SMALLORE = ITEMS.register("gringham_smallore",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> MAGIC_SWORD = ITEMS.register("magic_sword",
            () -> new SwordItem(Tiers.IRON, 10, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1)));

    // 追加されたアイテムもここに登録
    public static final RegistryObject<Item> MAGIC_CHOCO = ITEMS.register("magic_choco",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).alwaysEat().build()).stacksTo(64)));

    // その他アイテムの登録
    public static final RegistryObject<Item> MAGIC_CRYSTAL = ITEMS.register("magic_crystal",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> STAR_CABBAGE = ITEMS.register("star_cabbage",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> FIREBALL_MAGICBOOK = ITEMS.register("fireball_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> WATER_MAGICBOOK = ITEMS.register("water_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> BOLTAGE_MAGICBOOK = ITEMS.register("boltage_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> LOWSTAR_MAGICBOOK = ITEMS.register("lowstar_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> WIND_MAGICBOOK = ITEMS.register("wind_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> LIGHT_MAGICBOOK = ITEMS.register("light_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> DARKNESS_MAGICBOOK = ITEMS.register("darkness_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> GALAXY_MAGICBOOK = ITEMS.register("galaxy_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
    public static final RegistryObject<Item> CYBER_MAGICBOOK = ITEMS.register("cyber_magicbook",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
}

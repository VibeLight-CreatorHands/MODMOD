package com.yuyuto.procrafter.registry;

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
// アイテム追加コードは以下
    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));

    public static final RegistryObject<Item> NEOMAGIC_DUST = ITEMS.register("neomagic_dust",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));

    public static final RegistryObject<Item> GRINGHAM_SMALLORE = ITEMS.register("gringham_smallore",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));

    public static final RegistryObject<Item> MAGIC_SWORD = ITEMS.register("magic_sword",
            () -> new SwordItem(Tiers.IRON, 10, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1)));

    public static final RegistryObject<Item> MAGIC_CHOCO = ITEMS.register("magic_choco",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).alwaysEat().build()).stacksTo(64)));

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

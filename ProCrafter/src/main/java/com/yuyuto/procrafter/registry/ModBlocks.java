package com.yuyuto.procrafter.registry;

import com.yuyuto.procrafter.ProCrafter;
import com.yuyuto.procrafter.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProCrafter.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProCrafter.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ProCrafter.MOD_ID);

    // ブロック登録
    public static final RegistryObject<Block> MAGIC_MACHINE_BLOCK = BLOCKS.register("magic_machine_block",
            () -> new Block(Block.Properties.of().strength(3.0f)));

    public static final RegistryObject<Block> CABBAGE = BLOCKS.register("cabbage",
            () -> new CustomCropBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> NUCLEAR_GENERATOR = BLOCKS.register("nuclear_generator",
            () -> new Block(Block.Properties.of().strength(5.0f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> SOLAR_PANEL = BLOCKS.register("solar_panel",
            () -> new Block(Block.Properties.of().strength(3.0f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> STAR_ENERGY_EXTRACTOR = BLOCKS.register("star_energy_extractor",
            () -> new Block(Block.Properties.of().strength(6.0f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> MOLECULAR_SYNTHESIZER = BLOCKS.register("molecular_synthesizer",
            () -> new Block(Block.Properties.of().strength(4.0f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> ELEMENTAL_FURNACE = BLOCKS.register("elemental_furnace",
            () -> new Block(Block.Properties.of().strength(4.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MATTER_TRANSMITTER = BLOCKS.register("matter_transmitter",
            () -> new Block(Block.Properties.of().strength(5.5f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> MATTER_DECOMPOSER = BLOCKS.register("matter_decomposer",
            () -> new Block(Block.Properties.of().strength(5.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GAS_SEPARATOR = BLOCKS.register("gas_separator",
            () -> new Block(Block.Properties.of().strength(4.5f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> ANOMALOUS_MATERIAL_REMOVER = BLOCKS.register("anomalous_material_remover",
            () -> new Block(Block.Properties.of().strength(5.0f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> ENERGY_STORAGE = BLOCKS.register("energy_storage",
            () -> new Block(Block.Properties.of().strength(3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> COOLING_UNIT = BLOCKS.register("cooling_unit",
            () -> new Block(Block.Properties.of().strength(3.5f).requiresCorrectToolForDrops()));

    // ブロックエンティティ登録
    public static final RegistryObject<BlockEntityType<MagicMachineBlockEntity>> MAGIC_MACHINE_ENTITY = BLOCK_ENTITIES.register("magic_machine",
            () -> BlockEntityType.Builder.of(MagicMachineBlockEntity::new, MAGIC_MACHINE_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<?>> NUCLEAR_GENERATOR_ENTITY = BLOCK_ENTITIES.register("nuclear_generator",
            () -> BlockEntityType.Builder.of(NuclearGeneratorBlockEntity::new, NUCLEAR_GENERATOR.get()).build(null));

    // アイテム（ブロックアイテム）登録
    public static final RegistryObject<Item> MAGIC_MACHINE_ITEM = ITEMS.register("magic_machine_block",
            () -> new BlockItem(MAGIC_MACHINE_BLOCK.get(), new Properties()));

    public static final RegistryObject<Item> NUCLEAR_GENERATOR_ITEM = ITEMS.register("nuclear_generator",
            () -> new BlockItem(NUCLEAR_GENERATOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> SOLAR_PANEL_ITEM = ITEMS.register("solar_panel",
            () -> new BlockItem(SOLAR_PANEL.get(), new Item.Properties()));

    public static final RegistryObject<Item> STAR_ENERGY_EXTRACTOR_ITEM = ITEMS.register("star_energy_extractor",
            () -> new BlockItem(STAR_ENERGY_EXTRACTOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> MOLECULAR_SYNTHESIZER_ITEM = ITEMS.register("molecular_synthesizer",
            () -> new BlockItem(MOLECULAR_SYNTHESIZER.get(), new Item.Properties()));

    public static final RegistryObject<Item> ELEMENTAL_FURNACE_ITEM = ITEMS.register("elemental_furnace",
            () -> new BlockItem(ELEMENTAL_FURNACE.get(), new Item.Properties()));

    public static final RegistryObject<Item> MATTER_TRANSMITTER_ITEM = ITEMS.register("matter_transmitter",
            () -> new BlockItem(MATTER_TRANSMITTER.get(), new Item.Properties()));

    public static final RegistryObject<Item> MATTER_DECOMPOSER_ITEM = ITEMS.register("matter_decomposer",
            () -> new BlockItem(MATTER_DECOMPOSER.get(), new Item.Properties()));

    public static final RegistryObject<Item> GAS_SEPARATOR_ITEM = ITEMS.register("gas_separator",
            () -> new BlockItem(GAS_SEPARATOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANOMALOUS_MATERIAL_REMOVER_ITEM = ITEMS.register("anomalous_material_remover",
            () -> new BlockItem(ANOMALOUS_MATERIAL_REMOVER.get(), new Item.Properties()));

    public static final RegistryObject<Item> ENERGY_STORAGE_ITEM = ITEMS.register("energy_storage",
            () -> new BlockItem(ENERGY_STORAGE.get(), new Item.Properties()));

    public static final RegistryObject<Item> COOLING_UNIT_ITEM = ITEMS.register("cooling_unit",
            () -> new BlockItem(COOLING_UNIT.get(), new Item.Properties()));

    public static void register() {}
}

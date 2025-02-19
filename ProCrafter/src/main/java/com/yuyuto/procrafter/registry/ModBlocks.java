package com.yuyuto.procrafter.registry;

import com.yuyuto.procrafter.ProCrafter;
import com.yuyuto.procrafter.blocks.CustomCropBlock;
import com.yuyuto.procrafter.blocks.MagicMachineBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
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

    // ブロックエンティティ登録
    public static final RegistryObject<BlockEntityType<MagicMachineBlockEntity>> MAGIC_MACHINE_ENTITY = BLOCK_ENTITIES.register("magic_machine",
            () -> BlockEntityType.Builder.of(MagicMachineBlockEntity::new, MAGIC_MACHINE_BLOCK.get()).build(null));

    // アイテム（ブロックアイテム）登録
    public static final RegistryObject<Item> MAGIC_MACHINE_ITEM = ITEMS.register("magic_machine_block",
            () -> new BlockItem(MAGIC_MACHINE_BLOCK.get(), new Properties()));

    public static void register() {}
}

package com.yuyuto.procrafter.registry;

import com.yuyuto.procrafter.ProCrafter;
import com.yuyuto.procrafter.blocks.entity.MagicMachineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    // DeferredRegisterを作成
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ProCrafter.MOD_ID);

    // MagicMachineBlockEntity の登録
    public static final RegistryObject<BlockEntityType<MagicMachineBlockEntity>> MAGIC_MACHINE_ENTITY = BLOCK_ENTITIES.register("magic_machine",
        () -> BlockEntityType.Builder.of(MagicMachineBlockEntity::new, ModBlocks.MAGIC_MACHINE_BLOCK.get()).build(null));

    public static void register() {} // NeoForgeでは不要だが、統一性のために定義
}

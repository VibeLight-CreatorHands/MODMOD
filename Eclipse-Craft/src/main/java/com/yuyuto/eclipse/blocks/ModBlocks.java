package com.yuyuto.eclipse.block;

import com.yuyuto.eclipse.Eclipse;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    // ブロックの登録用DeferredRegister
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Eclipse.MOD_ID);

    // 独自ブロックの登録例：Lunar Block
    public static final RegistryObject<Block> LUNAR_BLOCK = BLOCKS.register("lunar_block", 
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0f, 6.0f)) {
            @Override
            public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
                super.onRemove(state, level, pos, newState, isMoving);
                if (!level.isClientSide()) {
                    // ブロック破壊時にアイテムドロップ
                    Block.dropResources(state, level, pos, null);
                }
            }
        });

    // ブロックアイテムの登録
    public static void addBlockItemsToCreativeTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.TAB_BUILDING_BLOCKS) {
            event.accept(LUNAR_BLOCK.get().asItem());
        }
    }

    // イベント登録
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        eventBus.addListener(ModBlocks::addBlockItemsToCreativeTab);
    }
}

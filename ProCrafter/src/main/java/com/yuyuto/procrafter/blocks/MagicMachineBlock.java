package com.yuyuto.procrafter.blocks;

import com.yuyuto.procrafter.blocks.entity.MagicMachineBlockEntity;
import com.yuyuto.procrafter.registry.ModBlockEntities;
import com.yuyuto.procrafter.registry.ModScreenHandlers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;

public class MagicMachineBlock extends Block {

    public MagicMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {  // サーバー側での処理
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MagicMachineBlockEntity) {
                // GUIを開く処理
                NetworkHooks.openScreen((ServerPlayer) player, (MagicMachineBlockEntity) blockEntity, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }
}

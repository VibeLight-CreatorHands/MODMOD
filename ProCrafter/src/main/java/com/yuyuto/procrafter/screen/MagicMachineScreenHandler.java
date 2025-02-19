package com.yuyuto.procrafter.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.vlyh.procrafter.blocks.entity.MagicMachineBlockEntity;

public class MagicMachineScreenHandler extends AbstractContainerMenu {

    private final MagicMachineBlockEntity blockEntity;

    public MagicMachineScreenHandler(int syncId, Inventory inv, FriendlyByteBuf buf) {
        this(syncId, inv, (MagicMachineBlockEntity) inv.player.level.getBlockEntity(buf.readBlockPos()));
    }

    public MagicMachineScreenHandler(int syncId, Inventory inv, MagicMachineBlockEntity blockEntity) {
        super(ModScreenHandlers.MAGIC_MACHINE_SCREEN_HANDLER.get(), syncId);
        this.blockEntity = blockEntity;
        // 実際のUIで使うためにスロットなどを追加
        // 例: addSlot(new Slot(blockEntity, 0, 80, 35));
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity.isUsableByPlayer(player);
    }
}

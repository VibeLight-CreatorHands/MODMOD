package com.yuyuto.procrafter.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;

public class NuclearGeneratorBlock extends Block {
    public NuclearGeneratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NuclearGeneratorBlockEntity(pos, state);  // BlockEntityを返す
    }

    @Override
    public boolean hasBlockEntity(BlockState state) {
        return true;  // このブロックはBlockEntityを持っている
    }
}

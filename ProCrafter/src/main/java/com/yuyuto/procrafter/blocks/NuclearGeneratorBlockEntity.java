package com.yuyuto.procrafter.blocks;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class NuclearGeneratorBlockEntity extends BlockEntity {
    private int energyStored = 0;  // 現在のエネルギー量

    // エネルギー生成の速度や最大容量を設定
    private static final int ENERGY_GENERATION_RATE = 10;  // エネルギー生成速度
    private static final int MAX_ENERGY = 1000;  // 最大エネルギー

    public NuclearGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.NUCLEAR_GENERATOR_ENTITY.get(), pos, state);
    }

    @Override
    public void tick() {
        // エネルギー生成ロジック
        if (this.level != null && this.level.isDay()) {  // 日中だけ発電
            generateEnergy();
        }
    }

    public void generateEnergy() {
        if (energyStored < MAX_ENERGY) {
            energyStored += ENERGY_GENERATION_RATE;
        } else {
            energyStored = MAX_ENERGY;  // 最大容量を超えないようにする
        }
    }

    public int getEnergyStored() {
        return energyStored;
    }

    public void consumeEnergy(int amount) {
        energyStored -= amount;
        if (energyStored < 0) {
            energyStored = 0;
        }
    }

    // GUIなどでエネルギー情報を表示する際に使う
    public Component getDisplayName() {
        return new TextComponent("Nuclear Generator");
    }
}

package com.yuyuto.procrafter.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class SolarPanelBlockEntity extends BlockEntity {
    private int energyStored = 0; // 現在のエネルギー量
    private static final int ENERGY_GENERATION_RATE = 5; // 1ティックあたりの生成エネルギー量
    private static final int MAX_ENERGY = 500; // 最大エネルギー量

    public SolarPanelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.SOLAR_PANEL_ENTITY.get(), pos, state);
    }

    // 毎ティック処理
    public static void tick(Level level, BlockPos pos, BlockState state, SolarPanelBlockEntity entity) {
        if (!level.isClientSide) {
            if (isDaytime(level) && isSkyVisible(level, pos)) {
                entity.generateEnergy();
            }
        }
    }

    // エネルギー生成ロジック
    private void generateEnergy() {
        if (energyStored < MAX_ENERGY) {
            energyStored += ENERGY_GENERATION_RATE;
            if (energyStored > MAX_ENERGY) {
                energyStored = MAX_ENERGY;
            }
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

    // 日中かどうかを確認
    private static boolean isDaytime(Level level) {
        return level.isDay(); // 日中のみエネルギー生成
    }

    // 空が見えるかを確認
    private static boolean isSkyVisible(Level level, BlockPos pos) {
        return level.canSeeSky(pos.above()); // 上に遮蔽物がないことを確認
    }
}

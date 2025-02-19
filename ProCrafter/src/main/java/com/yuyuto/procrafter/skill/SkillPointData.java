package com.yuyuto.procrafter.skill;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class SkillPointData implements INBTSerializable<CompoundTag> {
    private int skillPoints = 0;  // 初期スキルポイント

    // スキルポイントを取得
    public int getSkillPoints() {
        return skillPoints;
    }

    // スキルポイントを追加
    public void addSkillPoints(int amount) {
        this.skillPoints += amount;
    }

    // スキルポイントを消費（足りない場合はfalse）
    public boolean useSkillPoints(int amount) {
        if (skillPoints >= amount) {
            skillPoints -= amount;
            return true;
        }
        return false;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("SkillPoints", skillPoints);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.skillPoints = tag.getInt("SkillPoints");
    }
}

package com.yuyuto.procrafter.skill;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;

public class SkillData {
    private static final Map<String, Integer> skillLevels = new HashMap<>();

    // スキルを習得する（攻撃力 +1 など）
    public static void learnSkill(String skillName, int effectValue) {
        skillLevels.put(skillName, effectValue);
    }

    // スキルの値を取得
    public static int getSkillLevel(String skillName) {
        return skillLevels.getOrDefault(skillName, 0);
    }
    
    public static void increaseJumpBoost() {
        int currentLevel = getSkillLevel("jump_boost");
        learnSkill("jump_boost", currentLevel + 1);
    }

    // スキルデータをNBTに保存
    public static CompoundTag saveToNBT() {
        CompoundTag tag = new CompoundTag();
        for (Map.Entry<String, Integer> entry : skillLevels.entrySet()) {
            tag.putInt(entry.getKey(), entry.getValue());
        }
        return tag;
    }

    // NBTからスキルデータをロード
    public static void loadFromNBT(CompoundTag tag) {
        skillLevels.clear();
        for (String key : tag.getAllKeys()) {
            skillLevels.put(key, tag.getInt(key));
        }
    }
}

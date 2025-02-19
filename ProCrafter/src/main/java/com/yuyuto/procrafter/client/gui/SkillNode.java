package com.yuyuto.procrafter.client.gui;

import com.yuyuto.procrafter.skill.SkillData;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/** スキルツリーの各ノード（スキルポイント）を表すクラス */
public class SkillNode {
    private int x, y;
    private ResourceLocation icon;
    private Component name;
    private boolean learned;

    public SkillNode(int x, int y, ResourceLocation icon, Component name) {
        this.x = x;
        this.y = y;
        this.icon = icon;
        this.name = name;
        this.learned = false;  // 初期状態ではスキル未習得
    }

    // スキルをクリックしたときに習得する
    public void learn() {
        if (!learned) {
            learned = true;  // スキルを習得
            String skillKey = name.getString();

            if (skillKey.contains("attack_boost")) {
                SkillData.learnSkill("attack_boost", SkillData.getSkillLevel("attack_boost") + 1);
            } else if (skillKey.contains("defense_boost")) {
                SkillData.learnSkill("defense_boost", SkillData.getSkillLevel("defense_boost") + 1);
            } else if (skillKey.contains("jump_boost")) {  // 🎯 ジャンプスキルの処理
                SkillData.learnSkill("jump_boost", SkillData.getSkillLevel("jump_boost") + 1);
                }
        }
    }    


    public boolean isLearned() {
        return learned;  // スキルが習得されているか
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        // アイコンを描画
        Minecraft.getInstance().getTextureManager().bind(icon);
        RenderSystem.enableBlend();
        blit(poseStack, x, y, 0, 0, 16, 16); // アイコン位置とサイズ
        RenderSystem.disableBlend();

        // スキルが習得されていれば「習得済み」と表示
        if (learned) {
            drawCenteredString(poseStack, Minecraft.getInstance().font, "Learned", x + 8, y + 20);
        }
    }

    // スキルの位置にマウスがあるかチェック
    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + 16 && mouseY >= y && mouseY <= y + 16;
    }
}

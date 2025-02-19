package com.yuyuto.procrafter.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.yuyuto.procrafter.ProCrafter;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/** スキルツリーの GUI クラス */
public class SkillTreeScreen extends Screen {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ProCrafter.MODID, "textures/gui/skill_tree.png");

    // スキルノードのリスト
    private final List<SkillNode> skillNodes = new ArrayList<>();

    public SkillTreeScreen() {
        super(Component.translatable("screen.procrafter.skill_tree"));

        // サンプルのスキルノードを追加
        /**
        *スキルを追加する場合はこのようにする*
        *skillNodes.add(new SkillNode(40, 20, new ResourceLocation(ProCrafter.MODID, "textures/gui/スキルアイコン.png"),
                Component.translatable("skill.procrafter.ここにスキル名を追加")));
        */
        skillNodes.add(new SkillNode(40, 20, new ResourceLocation(ProCrafter.MODID, "textures/gui/skill_attack.png"),
                Component.translatable("skill.procrafter.attack_power1.")));
        skillNodes.add(new SkillNode(80, 50, new ResourceLocation(ProCrafter.MODID, "textures/gui/skill_defence.png"),
                Component.translatable("skill.procrafter.defensive_strength1")));
            // スキルを追加
        skillNodes.add(new SkillNode(120, 80, new ResourceLocation(ProCrafter.MODID, "textures/gui/skill_jump.png"),
                Component.translatable("skill.procrafter.jump_boost")));
    }

        @Override
    protected void init() {
        super.init();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // スキルノードをクリックしたかどうかをチェック
        for (SkillNode node : skillNodes) {
            if (node.isMouseOver((int) mouseX, (int) mouseY)) {
                node.learn();  // スキルを習得
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        int x = (this.width - 176) / 2;
        int y = (this.height - 166) / 2;

        // 背景を描画
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        graphics.blit(BACKGROUND_TEXTURE, x, y, 0, 0, 176, 166);

        // スキルノードを描画
        for (SkillNode node : skillNodes) {
            node.render(graphics, x, y);
        }
    }
}

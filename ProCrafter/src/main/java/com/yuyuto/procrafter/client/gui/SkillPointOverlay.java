package com.yuyuto.procrafter.client.gui;

import com.yuyuto.procrafter.skill.SkillPointProvider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class SkillPointOverlay {
    public static final IGuiOverlay HUD = (gui, poseStack, partialTicks, screenWidth, screenHeight) -> {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            int skillPoints = SkillPointProvider.get(mc.player).getSkillPoints();
            gui.getFont().draw(poseStack, "Skill Points: " + skillPoints, 10, 10, 0xFFFFFF);
        }
    };
}

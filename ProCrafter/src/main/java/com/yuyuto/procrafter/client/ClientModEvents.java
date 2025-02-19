package com.yuyuto.procrafter.client;

import com.yuyuto.procrafter.ProCrafter;
import com.yuyuto.procrafter.client.gui.SkillTreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyMapping;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = ProCrafter.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientModEvents {
    public static final String CATEGORY = "key.procrafter.category";
    public static final KeyMapping SKILL_TREE_KEY = new KeyMapping("key.procrafter.skill_tree", GLFW.GLFW_KEY_K, CATEGORY);

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (SKILL_TREE_KEY.isDown()) {
            Minecraft.getInstance().setScreen(new SkillTreeScreen());
        }
    }
}

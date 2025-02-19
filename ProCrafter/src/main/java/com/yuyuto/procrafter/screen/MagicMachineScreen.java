package com.yuyuto.procrafter.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.yuyuto.procrafter.ProCrafter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class MagicMachineScreen extends AbstractContainerScreen<MagicMachineScreenHandler> {

    public MagicMachineScreen(MagicMachineScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void renderBg(float partialTick, int mouseX, int mouseY) {
        // 背景画像などを描画
        RenderSystem.setShaderTexture(0, new ResourceLocation(ProCrafter.MOD_ID, "textures/gui/magic_machine_gui.png"));
        blit(leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);
        this.renderTooltip(mouseX, mouseY);
    }
}

//textures/gui/magic_machine_gui.png を UI の背景として使用（画像を assets/procrafter/textures/gui/ に追加する必要あり）

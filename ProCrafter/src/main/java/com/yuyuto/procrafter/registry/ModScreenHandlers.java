package com.yuyuto.procrafter.registry;

import com.yuyuto.procrafter.screen.MagicMachineScreenHandler;
import com.yuyuto.procrafter.screen.MagicMachineScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModScreenHandlers {
    public static final DeferredRegister<MenuType<?>> SCREEN_HANDLERS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ProCrafter.MOD_ID);

    public static final RegistryObject<MenuType<MagicMachineScreenHandler>> MAGIC_MACHINE_SCREEN_HANDLER = SCREEN_HANDLERS.register("magic_machine_screen_handler",
            () -> new MenuType<>(MagicMachineScreenHandler::new));

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens() {
        MenuScreens.register(MAGIC_MACHINE_SCREEN_HANDLER.get(), MagicMachineScreen::new);
    }

    public static void register() {}
}

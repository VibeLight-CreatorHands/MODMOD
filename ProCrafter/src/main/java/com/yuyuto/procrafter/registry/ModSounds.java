package com.yuyuto.procrafter.registry;

import com.yuyuto.procrafter.ProCrafter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    // DeferredRegister を作成（登録リスト）
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ProCrafter.MOD_ID);

    // 魔法の詠唱音を登録
    public static final RegistryObject<SoundEvent> MAGIC_CAST = SOUND_EVENTS.register("magic_cast",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ProCrafter.MOD_ID, "magic_cast")));

    public static void register() {} // `FMLJavaModLoadingContext` で登録するため、メソッドは空
}

package com.yuyuto.procrafter.event;

import com.yuyuto.procrafter.skill.SkillData;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerSaveHandler {

    // ワールドにデータを保存
    @SubscribeEvent
    public static void onPlayerSave(PlayerEvent.SaveToFile event) {
        event.getData().put("procrafter_skills", SkillData.saveToNBT());
    }

    // ワールドからデータをロード
    @SubscribeEvent
    public static void onPlayerLoad(PlayerEvent.LoadFromFile event) {
        SkillData.loadFromNBT(event.getData().getCompound("procrafter_skills"));
    }
}

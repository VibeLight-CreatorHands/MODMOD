package com.yuyuto.procrafter.event;

import com.yuyuto.procrafter.skill.SkillData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;

@Mod.EventBusSubscriber
public class PlayerTickHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
    
        // 速度ブーストの適用
        int speedBoost = SkillData.getSkillLevel("speed_boost");
        player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1 + (speedBoost * 0.01));

        // 🎯 ジャンプ力スキルの適用
        int jumpBoost = SkillData.getSkillLevel("jump_boost");
        player.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.42 + (jumpBoost * 0.1)); 
        // 通常ジャンプ力0.42, 1レベルごとに+0.1
    }

}

package com.yuyuto.procrafter.event;

import com.yuyuto.procrafter.skill.SkillPointProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerSkillPointHandler {

    // ✅ MOBを倒したときにスキルポイントを得る
    @SubscribeEvent
    public static void onMobKilled(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            SkillPointProvider.get(player).addSkillPoints(1); // 1ポイント追加
        }
    }

    // ✅ かまどでアイテムを精錬して取り出したときにスキルポイントを得る
    @SubscribeEvent
    public static void onItemSmelted(ItemPickupEvent event) {
        Player player = event.getEntity();
        SkillPointProvider.get(player).addSkillPoints(2); // 2ポイント追加
    }
}

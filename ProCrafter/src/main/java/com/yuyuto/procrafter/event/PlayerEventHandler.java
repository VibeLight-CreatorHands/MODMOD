package com.yuyuto.procrafter.event;

import com.yuyuto.procrafter.skill.SkillData;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerEventHandler {

    @SubscribeEvent
    public static void onPlayerDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player player) {
            int defenseBoost = SkillData.getSkillLevel("defense_boost");
            float newDamage = event.getAmount() - (defenseBoost * 0.5f); // 例：スキル1レベルごとに0.5ダメージ軽減
            event.setAmount(Math.max(newDamage, 0)); // ダメージを0以下にはしない
        }
    }
    @SubscribeEvent
    public static void onPlayerAttack(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            int attackBoost = SkillData.getSkillLevel("attack_boost");
            event.setAmount(event.getAmount() + attackBoost); // スキル1レベルごとに攻撃力+1
        }
    }

}

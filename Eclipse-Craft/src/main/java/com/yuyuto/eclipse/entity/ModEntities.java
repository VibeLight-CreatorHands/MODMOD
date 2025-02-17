package com.yuyuto.eclipse.entity;

import com.yuyuto.eclipse.Eclipse;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    // エンティティの登録用DeferredRegister
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Eclipse.MOD_ID);

    // 独自エンティティの登録例：Lunar Wolf
    public static final RegistryObject<EntityType<LunarWolf>> LUNAR_WOLF = ENTITIES.register("lunar_wolf",
    () -> EntityType.Builder.of(LunarWolf::new, MobCategory.CREATURE)
        .sized(0.6f, 0.85f)
        .build(Eclipse.MOD_ID + ":lunar_wolf"));

    // 独自エンティティクラス：Lunar Wolf
    public static class LunarWolf extends Wolf {
        public LunarWolf(EntityType<? extends Wolf> p_32504_, Level p_32505_) {
            super(p_32504_, p_32505_);
        }

        @Override
        public void aiStep() {
            super.aiStep();
            if (!level.isClientSide) {
                // 独自の行動やエフェクトを追加
                // 例: 月の光に反応する
            }
        }

        @Override
        public void dropCustomDeathLoot(DamageSource damageSource, int lootingLevel, boolean recentlyHit) {
            super.dropCustomDeathLoot(damageSource, lootingLevel, recentlyHit);
            // 独自のドロップアイテム
            this.spawnAtLocation(new ItemStack(Items.SUNSTONE));
        }
    }
    // イベント登録
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}

package com.yuyuto.eclipse.item;

import com.yuyuto.eclipse.Eclipse;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // アイテムの登録用DeferredRegister
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Eclipse.MOD_ID);

    // アイテムの登録
    public static final RegistryObject<Item> SUNSTONE = ITEMS.register("sunstone", 
        () -> new Item(new Item.Properties()));

    // 独自仕様：アイテムを使用した時にメッセージを表示するカスタムアイテム
    public static class SunstoneItem extends Item {
        public SunstoneItem() {
            super(new Item.Properties());
        }

        @Override
        public UseAnim getUseAnimation(ItemStack pStack) {
            return UseAnim.DRINK; // 使用アニメーションを飲み物のように設定
        }

        @Override
        public void onUseTick(ItemStack stack, World level, LivingEntity user, int count) {
            super.onUseTick(stack, level, user, count);
            if (!level.isClientSide) {
                user.sendMessage(new TextComponent("You are harnessing the power of the Sunstone!"), user.getUUID());
            }
        }
    }
    // アイテムのCreative Tab登録
    public static void addItemsToCreativeTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.TAB_MISC) {
            event.accept(SUNSTONE);
        }
    }

    // イベント登録
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        eventBus.addListener(ModItems::addItemsToCreativeTab);
    }
}

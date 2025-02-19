package com.vlyh.procrafter.items;

import com.vlyh.procrafter.registry.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class MagicChocoItem extends Item {

    public MagicChocoItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // 魔法の音を鳴らす
        context.getLevel().playSound(null, context.getClickedPos(), ModSounds.MAGIC_CAST.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        return super.useOn(context);
    }
}

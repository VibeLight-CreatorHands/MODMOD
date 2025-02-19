package com.yuyuto.procrafter.skill;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SkillPointProvider extends CapabilityProvider<SkillPointProvider> {
    private final SkillPointData data = new SkillPointData();
    private final LazyOptional<SkillPointData> optionalData = LazyOptional.of(() -> data);

    public SkillPointProvider() {
        super(SkillPointProvider.class);
    }

    public static SkillPointData get(Player player) {
        return player.getCapability(SkillCapability.SKILL_POINTS).orElse(new SkillPointData());
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == SkillCapability.SKILL_POINTS ? optionalData.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return data.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        data.deserializeNBT(tag);
    }
}

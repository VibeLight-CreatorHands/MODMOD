package com.yuyuto.procrafter.skill;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class SkillCapability {
    public static final Capability<SkillPointData> SKILL_POINTS = CapabilityManager.get(new CapabilityToken<>() {});
}

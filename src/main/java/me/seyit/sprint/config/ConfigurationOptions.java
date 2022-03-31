package me.seyit.sprint.config;

import me.seyit.sprint.util.HitDelayType;

public class ConfigurationOptions {
    public boolean enabled = true;

    public HitDelayType hitDelayType = HitDelayType.NEW;

    public int clicksPerSecond = 10;

    public int randomDelayTicksMin = 3;
    public int randomDelayTicksMax = 5;

    public boolean attackInvisible = false;
}

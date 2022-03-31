package me.seyit.sprint;

import me.seyit.sprint.config.Configuration;
import me.seyit.sprint.config.ConfigurationOptions;
import me.seyit.sprint.util.HitDelayType;
import me.seyit.sprint.util.KeyBindings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;

public class Sprint {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private KeyBindings keyBindings = Sprintmod.getInstance().keyBindings;
    private ConfigurationOptions configurationOptions = Sprintmod.getInstance().configurationOptions;
    private int delay;

    private boolean enabled = true;

    public void onTick() {
        if (!configurationOptions.enabled || mc.crosshairTarget == null || !(mc.crosshairTarget instanceof EntityHitResult) || !mc.player.isAlive()) {
            return;
        }

        if (keyBindings.keyBindingToggle.wasPressed()) {
            enabled = !enabled;
        }

        if (keyBindings.keyBindingHold.isPressed() || enabled) {

            Entity entity = ((EntityHitResult) mc.crosshairTarget).getEntity();

            if (!entity.isAlive()) {
                return;
            }

            if (configurationOptions.hitDelayType == HitDelayType.NEW) {
                attackWithNewHitDelay(entity);
            } else {
                attackWithOldHitDelay(entity);
            }
        }
    }

    private void attackWithNewHitDelay(Entity entity) {
        if (mc.player.getAttackCooldownProgress(mc.getTickDelta()) == 1f) {
            mc.interactionManager.attackEntity(mc.player, entity);
            mc.player.swingHand(Hand.MAIN_HAND);
        }
    }

    private void attackWithOldHitDelay(Entity entity) {
        delay++;
        int reqDelay = Math.round(20 / configurationOptions.clicksPerSecond);
        if (delay > reqDelay || reqDelay == 0) {
            mc.interactionManager.attackEntity(mc.player, entity);
            mc.player.swingHand(Hand.MAIN_HAND);
            delay = 0;
        }
    }
}

package me.seyit.sprint.util;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public KeyBinding keyBindingToggle = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            TranslationKeyHelper.keyBindKey + "toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            TranslationKeyHelper.keyBindCategory));

    public KeyBinding keyBindingHold = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            TranslationKeyHelper.keyBindKey + "hold",
            InputUtil.Type.MOUSE,
            GLFW.GLFW_KEY_END,
            TranslationKeyHelper.keyBindCategory));
}

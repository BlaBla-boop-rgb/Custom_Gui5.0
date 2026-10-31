package dev.customgui;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class CustomGuiMod implements ClientModInitializer {
    public static KeyMapping customGuiKey;

    @Override
    public void onInitializeClient() {
        // KeyBinding 'H' registrieren (änderbar in den Minecraft-Steuerungseinstellungen)
        customGuiKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.customgui.open",
                GLFW.GLFW_KEY_H,
                "category.customgui.general"
        ));

        // Event-Listener zum Öffnen des GUI
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (customGuiKey.consumeClick()) {
                Minecraft.getInstance().setScreen(new CustomGuiScreen());
            }
        });
    }
}

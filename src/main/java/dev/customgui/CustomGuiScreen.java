package dev.customgui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CustomGuiScreen extends Screen {

    public CustomGuiScreen() {
        super(Component.literal("Cytooxien Style GUI"));
    }

    @Override
    protected void init() {
        super.init();

        // Button: Layout / Modus wechseln
        this.addRenderableWidget(Button.builder(Component.literal("Layout umschalten"), button -> {
            CustomGuiConfig.darkMode = !CustomGuiConfig.darkMode;
        }).bounds(this.width / 2 - 100, this.height / 4 + 24, 200, 20).build());

        // Button: Design-Farbe ändern
        this.addRenderableWidget(Button.builder(Component.literal("Style: Cytooxien Dark"), button -> {
            // Einstellungsoption
        }).bounds(this.width / 2 - 100, this.height / 4 + 52, 200, 20).build());

        // Schließen-Button
        this.addRenderableWidget(Button.builder(Component.literal("Schließen"), button -> {
            this.onClose();
        }).bounds(this.width / 2 - 100, this.height / 4 + 92, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        // Cytooxien-typischer dunkler, eleganter Hintergrund
        graphics.fillGradient(0, 0, this.width, this.height, 0xC0101010, 0xD0101010);

        // Titel
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0x00FFCC);

        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

package de.lightplugins.skills.inventories;

import me.devnatan.inventoryframework.View;
import me.devnatan.inventoryframework.ViewConfigBuilder;
import me.devnatan.inventoryframework.context.RenderContext;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SkillsMainMenu extends View {

    @Override
    public void onInit(ViewConfigBuilder config) {
        // Both works and achieve same result
        config.size(5);
        config.size(45);
    }

    @Override
    public void onFirstRender(RenderContext render) {
        render.slot(2, 5, new ItemStack(Material.EGG));
    }
}

package ch.saymn.power_tools.screen;

import info.u_team.u_team_core.gui.UContainerScreen;
import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.container.BackpackContainer;
import ch.saymn.power_tools.type.Backpack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class BackpackScreen extends UContainerScreen<BackpackContainer> {
	
	public BackpackScreen(BackpackContainer container, PlayerInventory playerInventory, ITextComponent title) {
		super(container, playerInventory, title, new ResourceLocation(power_tools.MODID, "textures/gui/backpack/" + container.getBackpack().getName() + ".png"));
		backgroundWidth = backgroundHeight = 512;
		final Backpack backpack = container.getBackpack();
		xSize = backpack.getTextureSizeX();
		ySize = backpack.getTextureSizeY();
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		font.drawString(title.getFormattedText(), 8, 9, 4210752);
	}
}
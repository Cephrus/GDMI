package tk.cephlab.gdmi;

import net.minecraft.client.gui.GuiScreen;

public class GuiGDMIConfigurator extends GuiScreen
{
	public GuiGDMIConfigurator(GuiScreen parent)
	{
		
	}
	
	@Override
	public void initGui()
	{
		this.drawDefaultBackground();
	}
	
	@Override
	public void drawScreen(int x, int y, float f)
	{
		this.fontRendererObj.drawString("Download Mods", 2, 2, 1);
	}
}

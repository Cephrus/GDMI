package tk.cephlab.gdmi;

import java.io.File;
import java.net.MalformedURLException;

import net.minecraft.client.Minecraft;
import tk.cephlab.gdmi.resource.CurseForgeInterface;
import tk.cephlab.gdmi.resource.CurseModInstance;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="gdmi", name="Guided Dynamic Mod Installer", version="1.0", guiFactory="tk.cephlab.gdmi.GUIFactory")
public class DynamicModInstaller 
{
	@Instance
	public static DynamicModInstaller gdmi;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		try 
		{
			CurseModInstance instance = CurseForgeInterface.instance().getModInstance("http://minecraft.curseforge.com/mc-mods/51195-railcraft");
			instance.downloadMod(new File(Minecraft.getMinecraft().mcDataDir, "/mods/railrcaft.zip"));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package tk.cephlab.gdmi.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CurseForgeInterface
{
	public String minecraftVer = "1.7.10";
	
	public static CurseForgeInterface instance()
	{
		return new CurseForgeInterface();
	}	
	
	public CurseModInstance getModInstance(String linkToModPg) throws MalformedURLException
	{
		//String nam = getModName(linkToModPg);
		String dll = linkToModPg + "/files/latest";
		String lic = getModLicense(linkToModPg);
		String img = getModImage(linkToModPg);
		int  modid = getModId(linkToModPg);
		
		return new CurseModInstance(new URL(dll));
	}
	
	public int getModId(String ltp)
	{
		return Integer.parseInt(downloadPage(ltp)[417].substring(24).split("\"")[1]);
	}
	
	public String getModImage(String ltp)
	{
		return downloadPage(ltp)[239].substring(39).split("\"")[1];
	}
	
	public String getModLicense(String ltp)
	{
		return downloadPage(ltp)[409].split(">")[2].split(".")[1];
	}
	
	public String getModName(String ltp)
	{
		return downloadPage(ltp)[243].split(">")[3].split("<")[1];
	}
	
	private static String[] downloadPage(String url)
    {
		URL qrl;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    String[] pg = new String[65360];
	    int index = 0;

	    try 
	    {
	        qrl = new URL(url);
	        is = qrl.openStream();
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null)
	        {
	            index++;
	            pg[index] = line;
	        }
	    } 
	    catch (MalformedURLException mue) 
	    {
	         mue.printStackTrace();
	    } 
	    catch (IOException ioe) 
	    {
	         ioe.printStackTrace();
	    } 
	    finally 
	    {
	        try 
	        {
	            if (is != null) is.close();
	        } 
	        catch (IOException ioe)
	        {}
	    }
	    
	    return pg;
    }
}

package tk.cephlab.gdmi.resource;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class CurseModInstance 
{
	public URL DL;
	public URL IMG;
	//public String name;
	public String lic;
	public int id;
	
	public CurseModInstance(URL dl, URL img, String lic, int id)
	{
		this.DL = dl;
		this.IMG = img;
		//this.name = name;
		this.lic = lic;
		this.id = id;
	}
	
	public CurseModInstance(URL dl)
	{
		this.DL = dl;
	}
	
	/**
	 * Downloads the CurseModInstance.
	 * 
	 * @param file the File to download the mod to.
	 * 
	 * @return The file the mod is downloaded in.
	 * @throws IOException IOException
	 */
	public File downloadMod(File file) throws IOException
	{
		 InputStream in = new BufferedInputStream(DL.openStream());
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 byte[] buf = new byte[1024];
		 int n = 0;
		 while (-1!=(n=in.read(buf)))
		 {
		    out.write(buf, 0, n);
		 }
		 out.close();
		 in.close();
		 byte[] response = out.toByteArray();
 
		 FileOutputStream fos = new FileOutputStream(file);
		 fos.write(response);
		 fos.close();
		 
		 return file;
	}
}

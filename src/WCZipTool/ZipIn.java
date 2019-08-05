package WCZipTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JTabbedPane;

public class ZipIn {
	  //文件解压类
		protected void zip(String zipFileName) throws Exception {
			ZipInputStream zin;		
			WCZipTool zipTool = new WCZipTool();
			try {
				zin = new ZipInputStream(new FileInputStream(zipFileName));
				ZipEntry entry;
				while ((entry = zin.getNextEntry())!=null && !entry.isDirectory()) {
				  	//File file = new File(zipFileName.substring(0,zipFileName.lastIndexOf("."))+ "/" +entry.getName());
					File file = new File(zipFileName.substring(0,zipFileName.lastIndexOf(File.separator))+ "/" +entry.getName());
				  	System.out.println(file);				  	
				  	if(!file.exists()){
				  		file.getParentFile().mkdirs();			  		
				  		file.createNewFile();			  
				  	}
				  	FileOutputStream out = new FileOutputStream(file);
				  	byte[] bt = new byte[1024];
				  	int len;
				  	while ((len = zin.read(bt)) > 0) {
		               out.write(bt,0,len);
						
					}
				  	zin.closeEntry();
				  	
				  	System.out.println(entry.getName() + "解压成功！");
				}			
				new ZipJDialog(zipTool, "文件解压成功！").setVisible(true);
			  	System.out.println("解压完毕!");
				zin.close();
			} catch (Exception e) {
				e.printStackTrace();
				new ZipJDialog(new WCZipTool(), e.toString()).setVisible(true);
			}		
		}

}

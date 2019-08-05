package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JPopupMenu.Separator;

public class ZipFileTest1 {
	
	public static void main(String[] args) {
		ZipOut zipFile = new ZipOut();
		ZipIn zipFileDe = new ZipIn();
		try {
			//zipFile.zip("C:/tmp/testDemo.zip", new File("C:/tmp/testDemo"));
			zipFileDe.zip("C:/tmp/testDemo.zip");
			//System.out.println("压缩成功!");
			//System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ZipOut{
	protected void zip(String zipFileName,File FileName) throws Exception {
		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(zipFileName));
		if(FileName.isDirectory()){
			zip(zipout,FileName,"");
		}else {
			zip(zipout,FileName,FileName.getName());
		}
		
		zipout.close();
		
	}
	private void zip(ZipOutputStream zipout,File file,String base) throws Exception{
		if(file.isDirectory()){        //待压缩文件是目录，即为文件夹
			File[] fileList = file.listFiles();
			//zipout.putNextEntry(new ZipEntry(base+"/"));
			base = base.length()==0?"":base.substring(0, base.lastIndexOf("/")+1);//去除重复根目录
			for(File fileSec:fileList){				
				zip(zipout, fileSec,base + file.getName()+"/"+ fileSec.getName());	//递归调用	
			}
		}
		else{
			zipout.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(file);
			int len;
			System.out.println(base);
			while ((len = in.read())!= -1) {
				zipout.write(len);				
			}
			in.close();
		}
	}
}
class ZipIn{
	protected void zip(String zipFileName) throws Exception {
		ZipInputStream zin;		
		try {
			zin = new ZipInputStream(new FileInputStream(zipFileName));
			ZipEntry entry;
			while ((entry = zin.getNextEntry())!=null && !entry.isDirectory()) {
			  	File file = new File(zipFileName.substring(0,zipFileName.lastIndexOf("."))+ "/" +entry.getName());
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
			
		  	System.out.println("解压完毕!");
			zin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

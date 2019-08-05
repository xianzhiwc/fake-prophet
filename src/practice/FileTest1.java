package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

public class FileTest1 {
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
		File f = new File("D:/test/test"+i+".txt");
		if(f.exists()){
			//f.delete();
			//System.out.println("文件已删除！");
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(dateFm.format(f.lastModified()));
		}else {
			try {
				f.createNewFile();
				System.out.println("文件已创建！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(f,false);
			byte[] bt = "我的滑板鞋，时尚时尚最时尚。".getBytes("GBK"); 
			out.write(bt);
			out.write("\r\n".getBytes());
		    out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream in = new FileInputStream(f);
			byte[] by = new byte[1024];
			int len = in.read(by);
			System.out.println(f.getName()+"\n"+new String(by, 0, len));
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}

}

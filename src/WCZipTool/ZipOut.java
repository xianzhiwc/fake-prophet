package WCZipTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOut {
	   //�ļ�ѹ����
		protected void zip(String zipFileName,File FileName) throws Exception {
			ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(zipFileName));
			WCZipTool zipTool = new WCZipTool();
			try{
			if(FileName.isDirectory()){
				zip(zipout,FileName,"");
			}else {
				zip(zipout,FileName,FileName.getName());
			}			
			zipout.close();			
			new ZipJDialog(zipTool, "�ļ�ѹ���ɹ���").setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
				new ZipJDialog(zipTool, "�ļ�ѹ��ʧ�ܣ�").setVisible(true);
			}
			
		}
		private void zip(ZipOutputStream zipout,File file,String base) throws Exception{
			if(file.isDirectory()){        //��ѹ���ļ���Ŀ¼����Ϊ�ļ���
				File[] fileList = file.listFiles();
				//zipout.putNextEntry(new ZipEntry(base+"/"));
				base = base.length()==0?"":base.substring(0, base.lastIndexOf("/")+1);//ȥ���ظ���Ŀ¼
				for(File fileSec:fileList){				
					zip(zipout, fileSec,base + file.getName()+"/"+ fileSec.getName());	//�ݹ����	
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

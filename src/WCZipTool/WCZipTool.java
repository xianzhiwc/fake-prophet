package WCZipTool;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileSystemView;
import javax.tools.FileObject;

public class WCZipTool extends JFrame{
	public void CreatFrame(String title) {
	JFrame jf = new JFrame(title);
	//jf.setLayout(null);
	jf.setBounds(500, 300, 500, 400);
	Container con = jf.getContentPane();
	jf.setLayout(new FlowLayout(1,10,10));
	con.setBackground(Color.lightGray);
	final JTextArea jt = new JTextArea(14,40);
	final JTextField filePath = new JTextField("��ѡ���ļ����ļ���...",30);	
	JButton jb1 = new JButton("���");    //�ļ�·��ѡ��
	JButton jb2 = new JButton("��ʼѹ��");
	JButton jb3 = new JButton("��ʼ��ѹ");
	con.add(filePath);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	con.add(jt);
	//jb1.setBounds(30,300, 180, 40);
	//jb2.setBounds(260,300, 180, 40);
	//jt.setBounds(0, 0, 480, 280);
	jb1.addActionListener(new ActionListener() {		    
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jf = new JFileChooser();
			//FileSystemView fsv = FileSystemView.getFileSystemView();  //  
			//System.out.println(fsv.getHomeDirectory());                //�õ�����·��  
			//jf.setCurrentDirectory(fsv.getHomeDirectory());            //����Ĭ��·��Ϊ����
			jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			 int returnVal  = jf.showOpenDialog(getContentPane());  //opendialog  
		        if(returnVal == JFileChooser.APPROVE_OPTION)  //�ж��Ƿ�Ϊ�򿪵İ�ť  
		        {  
		        	File selectFile = jf.getSelectedFile();
		        	if(selectFile.isDirectory()){
		            filePath.setText("��ѡ���ļ���:  "+selectFile.getName() 
		            		+ "<"+selectFile.getPath() + ">");   //ȡ���ļ���·��  
		           }else{
		        	filePath.setText("��ѡ���ļ�:  "+selectFile.getName() 
		        			+ "<"+selectFile.getPath() + ">");   //ȡ���ļ�·��   
		           }
		        }
			
		}
	});
	jb2.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			ZipOut zipout = new ZipOut();
			try {
				String fpath = filePath.getText().substring(filePath.getText().lastIndexOf("<") + 1, 
						       filePath.getText().lastIndexOf(">"));
				//System.out.println(fpath);
				jt.setText(fpath);
				zipout.zip(fpath+".zip", new File(fpath));	
				//new ZipJDialog(WCZipTool.this, "�ļ�ѹ���ɹ���").setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				new ZipJDialog(WCZipTool.this, e1.toString()).setVisible(true);
			}catch (IOException e2) {
				e2.printStackTrace();
				new ZipJDialog(WCZipTool.this, e2.toString()).setVisible(true);
			}catch (Exception e3) {
				e3.printStackTrace();
				new ZipJDialog(WCZipTool.this, e3.toString()).setVisible(true);
			}			
		}
	});
	jb3.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			ZipIn zipin = new ZipIn();
			try {
				String fpath = filePath.getText().substring(filePath.getText().lastIndexOf("<") + 1, 
					       filePath.getText().lastIndexOf(">"));
			    //System.out.println(fpath);
				zipin.zip(fpath);
				//new ZipJDialog(WCZipTool.this, "�ļ���ѹ�ɹ���").setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				new ZipJDialog(WCZipTool.this, e1.toString()).setVisible(true);
			}catch (IOException e2) {
				e2.printStackTrace();
				new ZipJDialog(WCZipTool.this, e2.toString()).setVisible(true);
			}catch (Exception e3) {
				e3.printStackTrace();
				new ZipJDialog(WCZipTool.this, e3.toString()).setVisible(true);
			}			
		}
	});
	
	con.add(jt);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
    public static void main(String[] args) {
    	try {
    		new WCZipTool().CreatFrame("�ļ���ѹ������");
		} catch (Exception e3) {
			e3.printStackTrace();
			new ZipJDialog(new WCZipTool(), e3.toString()).setVisible(true);
		}	
		
	}
}
   

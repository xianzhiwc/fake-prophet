package practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;


public class FileWriterTest1 extends JFrame{
	public void CreatFrame(String title) {
	JFrame jf = new JFrame(title);
	jf.setLayout(null);
	jf.setBounds(500, 300, 500, 400);
	Container con = jf.getContentPane();
	con.setBackground(Color.lightGray);
	final JTextArea jt = new JTextArea();
	JButton jb1 = new JButton("д���ļ�");
	JButton jb2 = new JButton("��ȡ�ļ�");
	jb1.setBounds(30,300, 180, 40);
	jb2.setBounds(260,300, 180, 40);
	jt.setBounds(0, 0, 480, 280);
	
	jb1.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = new File("C:/tmp/word.txt");
			try {
				FileWriter out = new FileWriter(file,true);
				String s = jt.getText();
				out.write(s+"\r\n");
				out.close();
				new MyJDialog(FileWriterTest1.this, "�ļ�д��ɹ���").setVisible(true);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
	});
	jb2.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = new File("C:/tmp/word.txt");
			try {
				FileReader in = new FileReader(file);
				char byt[] = new char[1024];
				int len = in.read(byt);
				jt.setText(new String(byt, 0, len));
				in.close();
				new MyJDialog(FileWriterTest1.this, "�ļ���ȡ�ɹ���").setVisible(true);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
		}
	});
	con.add(jb1);
	con.add(jb2);
	con.add(jt);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {
		new FileWriterTest1().CreatFrame("�ļ���Ϣ¼��");
	}
}

class MyJDialog extends JDialog{
	public  MyJDialog(FileWriterTest1 frame,String title) {
		super(frame, "��ʾ", true);
		Container cont = getContentPane();
		JButton jb = new JButton("��֪����");		
		jb.setBounds(100, 70, 100, 30);
		jb.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}
		});
		cont.add(jb);
		cont.add(new JLabel(title));
		setBounds(600, 350, 300, 150);		
	}
}

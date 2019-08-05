package WCZipTool;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ZipJDialog extends JDialog {  //解压缩结果对话框
	public  ZipJDialog(WCZipTool frame,String title) {
		super(frame, "提示", true);
		Container cont = getContentPane();
		setLayout(new FlowLayout(1,15,15));
		JButton jb = new JButton("确定");		
		//jb.setBounds(100, 70, 100, 30);
		jb.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}
		});
		JLabel jl = new JLabel(title);
		cont.add(jl);
		cont.add(jb);		
		setBounds(600, 350, 350, 150);		
	}
}

package company;

import jframe.Login;
import jframe.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test implements ActionListener{
	public static Login frame;
	public static Main zhu;
	/*sqlserver���ݿ⣬ʹ�õ�sa��¼���ҵ�������123*/
	public static String mysqlname="sa";
	public static String mysqlpassword="123";
	public static String database="foodcompany";
	//��¼����
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}
	//�������ݿ�
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		if(e1.getSource()==Login.denglu)
		{
			new Testmysql();
		}
		/*if(e1.getSource()==Kucun_ruku.ruku){
			//�������ݿ�ruku��
		}*/
	}

}

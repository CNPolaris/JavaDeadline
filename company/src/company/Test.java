package company;

import jframe.Login;
import jframe.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test implements ActionListener{
	public static Login frame;
	public static Main zhu;
	/*sqlserver数据库，使用的sa登录，我的密码是123*/
	public static String mysqlname="sa";
	public static String mysqlpassword="123";
	public static String database="foodcompany";
	//登录界面
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
	//连接数据库
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		if(e1.getSource()==Login.denglu)
		{
			new Testmysql();
		}
		/*if(e1.getSource()==Kucun_ruku.ruku){
			//连接数据库ruku；
		}*/
	}

}

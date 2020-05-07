package company;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import jframe.Login;
import jframe.Main;

import company.Test;

public class Testmysql {
	public static String Name;
	public static String limite;
	public Testmysql(){
	
		Name=Login.yonghu.getText();
		limite=Login.limite.getSelectedItem().toString();
		String s2=Login.passwordField.getText();
		String s3=Login.limite.getSelectedItem().toString();
	    String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动名
	    String conURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany";
	    try {
	        Class.forName(JDriver);
	    }
	    catch(ClassNotFoundException cnf_e) {  // 如果找不到驱动类
	        System.out.println("Driver Not Found: " + cnf_e);
	    }
	    try {
	        java.sql.Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
	        java.sql.Connection con1 = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
	        Statement s = (Statement) con.createStatement();  // Statement类用来提交SQL语句
	        Statement s1 = (Statement) con1.createStatement();  // Statement类用来提交SQL语句
	        ResultSet rs = s.executeQuery("select * from users ");  // 提交查询，返回的表格保存在rs中
	        boolean flag=false;
	        //查询结果存在，并且密码正确
	        while(rs.next()) {  // ResultSet指针指向下一个“行”
	        	if(rs.getString("name").equals(Name) && rs.getString("password").equals(s2)&&rs.getString("limite").equals(s3)){
	        		flag=true;
	        		Test.zhu=new Main();
	        		JOptionPane.showMessageDialog(Test.frame, Name+"登陆成功","登陆成功",1);
	        		Test.frame.dispose();//点击按钮时frame1销毁,new一个frame2
	        		Test.zhu.setVisible(true);
	        		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        		String insert = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+limite+Name+"登入系统"+"','"+limite+"')";  
	        		s1.executeUpdate(insert);
	                  s1.close();     // 释放Statement对象
	                   con1.close();   // 关闭到MySQL服务器的连接
	        		break;
	        	}
	        }
	        //用户不存在或者是密码不正确
	        if(!flag){
	        	JOptionPane.showMessageDialog(Test.frame, Name+s2+"用户名或密码错误！请重新输入","错误",2);
	        	Login.yonghu.setText("");
	        	Login.passwordField.setText("");
	        	return;
	        }
	        s.close();
	        con.close();
	    }
	    catch(SQLException sql_e) {     // 都是SQLException
	        System.out.println("testmyql  "+sql_e);//标记错误位置
	    }
	    return;
	}
}

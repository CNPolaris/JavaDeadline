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
		//String JDriver = "com.mysql.jdbc.Driver";  // MySQL�ṩ��JDBC������Ҫ��֤����CLASSPATH��ɼ�
		//String JDriver = "com.mysql.cj.jdbc.Driver"; 
	    //String conURL = "jdbc:mysql://localhost:3306/"+Test.database;  // ���ؼ�����ϵ�MySQL���ݿ�Company��URL
		//String conURL ="jdbc:mysql://localhost/company?useSSL=FALSE&serverTimezone=UTC";
	    String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//������
	    String conURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany";
	    try {
	        Class.forName(JDriver);
	    	//Class.forName(drivername);
	    }
	    catch(ClassNotFoundException cnf_e) {  // ����Ҳ���������
	        System.out.println("Driver Not Found: " + cnf_e);
	    }
	    try {
	        java.sql.Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // �������ݿ�
	        java.sql.Connection con1 = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // �������ݿ�
	    	//Connection con=(Connection) DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany","sa","123");
	    	//Connection con1=(Connection) DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany","sa","123");
	        Statement s = (Statement) con.createStatement();  // Statement�������ύSQL���
	        Statement s1 = (Statement) con1.createStatement();  // Statement�������ύSQL���

	        ResultSet rs = s.executeQuery("select * from users ");  // �ύ��ѯ�����صı��񱣴���rs��
	        boolean flag=false;
	        while(rs.next()) {  // ResultSetָ��ָ����һ�����С�
	        	if(rs.getString("name").equals(Name) && rs.getString("password").equals(s2)&&rs.getString("limite").equals(s3)){
	        		flag=true;
	        		Test.zhu=new Main();
	        		JOptionPane.showMessageDialog(Test.frame, Name+"��½�ɹ�","��½�ɹ�",1);
	        		Test.frame.dispose();//�����ťʱframe1����,newһ��frame2
	        		Test.zhu.setVisible(true);
	        		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"����ϵͳ"+"','"+limite+"')");
	        		String insert = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+limite+Name+"����ϵͳ"+"','"+limite+"')";  
	        		s1.executeUpdate(insert);
	        			
	                  s1.close();     // �ͷ�Statement����
	                   con1.close();   // �رյ�MySQL������������
	        		break;
	        	}
	        }
	        if(!flag){
	        	JOptionPane.showMessageDialog(Test.frame, Name+s2+"�û����������������������","����",2);
	        	Login.yonghu.setText("");
	        	Login.passwordField.setText("");
	        	return;
	        }
	        s.close();
	        con.close();
	    }
	    catch(SQLException sql_e) {     // ����SQLException
	        System.out.println("testmyql  "+sql_e);
	    }
	    return;
	}
}
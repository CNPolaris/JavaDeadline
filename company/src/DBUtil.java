import java.sql.*;
public class DBUtil {
	private static String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";;//������
	private static Connection connection;
	private static PreparedStatement statement;
	private static ResultSet result;
	DBUtil(){
		connection=null;
		statement=null;
		result=null;
	}
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(drivername);//��������
			connection=DriverManager.getConnection("jdbc:sqlserver://192.168.31.149:1433;DatabaseName=foodcompany","sa","123");
			//statement=connection.createStatement();
			System.out.println("����ɹ�");
			System.out.println("���ӳɹ�");
			return connection;
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ��");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}finally {
			connection.close();
		}
		return connection;
	}
	public static void check(String username,String password) {
		String checkSQL="select * from UserInfo where username=?";
		 Connection connection = null;
	     ResultSet result=null;
	     statement=null;
	     try {
	    	 connection=getConnection();
	    	 statement=connection.prepareStatement(checkSQL);
	    	 statement.setString(1,username);
	    	 result=statement.executeQuery();
	    	 if(result.next()) {
	    		 String pass=result.getString("password");
	    		 if(pass.equals(password)) {
	    			 
	    		 }
	    	 }
	    	 else {
	    		 
	    	 }
	     }catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	}
	public static void main(String args[]) {
		DBUtil dv=new DBUtil();
		try {
			Connection cn=dv.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

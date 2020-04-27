package messagejpanel;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import java.awt.FlowLayout;

import javax.swing.ScrollPaneConstants;

import company.Test;

public class Dingdan_goumai extends JPanel {

	/**
	 * Create the panel.
	 */
	DefaultTableModel tableModel;
	Vector<Vector<String>> tableValueV;
	Vector<String> columnNameV;
	JTable table;
	
	//String JDriver = "com.mysql.jdbc.Driver";  // MySQL�ṩ��JDBC������Ҫ��֤����CLASSPATH��ɼ�

    //String conURL = "jdbc:mysql://localhost/"+Test.database;  // ���ؼ�����ϵ�MySQL���ݿ�Company��URL
	 String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//������
	    String conURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany";
	public Dingdan_goumai() {
		setBackground(Color.WHITE);
		setBounds(197, 0, 637, 570);
		init();
	}

	public void init(){
		
		JScrollPane scrollPane1=new JScrollPane();
		String[] columnNames = {"������" ,"��Ʒ����","��Ʒ����","������","����Ա","ʱ��","�۸�","����" };
		columnNameV = new Vector<String>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		tableValueV = new Vector<Vector<String>>();
		
		try {
            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // �������ݿ�

            Statement s = con.createStatement();  // Statement�������ύSQL���

            ResultSet rs = s.executeQuery("select * from kucun;");  // �ύ��ѯ�����صı��񱣴���rs��

            while(rs.next()) {  // ResultSetָ��ָ����һ�����С�
            		Vector<String> rowV = new Vector<String>();
            		rowV.add(rs.getString("danhao"));
        			rowV.add(rs.getString("lei"));
        			rowV.add(rs.getString("name"));
        			rowV.add(rs.getString("jingshouren"));
        			rowV.add(rs.getString("operator"));
        			rowV.add(rs.getString("time"));
        			rowV.add(rs.getString("price"));
        			rowV.add(rs.getString("num"));
        			tableValueV.add(rowV);
            	}
			
            s.close();     // �ͷ�Statement����
            con.close();   // �رյ�MySQL������������
        }
        catch(SQLException sql_e) {     // ����SQLExceptionss
            System.out.println(sql_e);
        }
		
		tableModel = new DefaultTableModel(tableValueV,
				columnNameV);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));
		scrollPane1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		TableColumnModel tableColumnModel = table.getColumnModel();
		ListSelectionModel listSelectionModel = tableColumnModel
				.getSelectionModel();
		add(scrollPane1);
		scrollPane1.setBounds(43, 40, 552, 300);
		//table.setBounds(0, 0, 438, 250);
		//add(table);
		TableColumnModel   cm   =   table.getColumnModel(); 
		for(int i=0;i<8;i++){
			TableColumn   column  = cm.getColumn(i);//�õ���i���ж���   
			  column.setPreferredWidth(67);//�����е���ѡ��������Ϊ preferredWidth��
		}
		  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
		  r.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, r);
		
		
		
		/*JScrollPane scrollPane1=new JScrollPane();
		String[] columnNames = {"������" ,"��Ʒ����","��Ʒ����","������","����Ա","ʱ��","�۸�","����" };
		columnNameV = new Vector<String>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		tableValueV = new Vector<Vector<String>>();
		try {
            Connection con = DriverManager.getConnection(conURL, "root", "");  // �������ݿ�

            Statement s = con.createStatement();  // Statement�������ύSQL���

            ResultSet rs = s.executeQuery("select * from kucun;");  // �ύ��ѯ�����صı��񱣴���rs��

            while(rs.next()) {  // ResultSetָ��ָ����һ�����С�
            		Vector<String> rowV = new Vector<String>();
            		rowV.add(rs.getString("danhao"));
        			rowV.add(rs.getString("lei"));
        			rowV.add(rs.getString("name"));
        			rowV.add(rs.getString("jingshouren"));
        			rowV.add(rs.getString("operator"));
        			rowV.add(rs.getString("time"));
        			rowV.add(rs.getString("price"));
        			rowV.add(rs.getString("num"));
        			tableValueV.add(rowV);
            	}
			
            s.close();     // �ͷ�Statement����
            con.close();   // �رյ�MySQL������������
        }
        catch(SQLException sql_e) {     // ����SQLExceptionss
            System.out.println(sql_e);
        }
		
		tableModel = new DefaultTableModel(tableValueV,
				columnNameV);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));
		scrollPane1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		TableColumnModel tableColumnModel = table.getColumnModel();
		ListSelectionModel listSelectionModel = tableColumnModel
				.getSelectionModel();
		add(scrollPane1);
		scrollPane1.setBounds(0, 0, 552, 500);
		table.setBounds(0, 0, 438, 250);
		//add(table);
		TableColumnModel   cm   =   table.getColumnModel(); 
		for(int i=0;i<8;i++){
			TableColumn   column  = cm.getColumn(i);//�õ���i���ж���   
			  column.setPreferredWidth(58);//�����е���ѡ��������Ϊ preferredWidth��
		}
		  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
		  r.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, r);*/
	}
}
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
	
	 String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动名
	 String conURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany";//数据库url
	public Dingdan_goumai() {
		setBackground(Color.WHITE);
		setBounds(197, 0, 637, 570);
		init();
	}

	public void init(){
		
		JScrollPane scrollPane1=new JScrollPane();
		String[] columnNames = {"订单号" ,"商品类型","商品名称","经手人","操作员","时间","价格","数量" };
		columnNameV = new Vector<String>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		tableValueV = new Vector<Vector<String>>();
		
		try {
            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

            Statement s = con.createStatement();  // Statement类用来提交SQL语句

            ResultSet rs = s.executeQuery("select * from kucun;");  // 提交查询，返回的表格保存在rs中

            while(rs.next()) {  // ResultSet指针指向下一个“行”
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
			
            s.close();     // 释放Statement对象
            con.close();   // 关闭到MySQL服务器的连接
        }
        catch(SQLException sql_e) {     // 都是SQLExceptionss
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

		TableColumnModel   cm   =   table.getColumnModel(); 
		for(int i=0;i<8;i++){
			TableColumn   column  = cm.getColumn(i);//得到第i个列对象   
			  column.setPreferredWidth(67);//将此列的首选宽度设置为 preferredWidth。
		}
		  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
		  r.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, r);
	}
}

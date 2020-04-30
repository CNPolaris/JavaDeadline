package messagejpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import company.Test;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Xiaoshou_day extends JPanel {

	/**
	 * Create the panel.
	 */
	
	 String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动名
	 String conURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=foodcompany";
     int day;
     int mounth;
     int year;
     ChartPanel panel;
     String now;
     JLabel lblNewLabel;
     
	public Xiaoshou_day() {
		
		
		setBackground(Color.WHITE);
		setBounds(197, 0, 637, 570);
		setLayout(null);
		init();
	}
	public void init(){
		
			int [][]d={{31,28,31,30,31,30,31,31,30,31,30,31},{31,29,31,30,31,30,31,31,30,31,30,31}};
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date=df.format(new Date());
			
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(260, 495, 176, 28);
			add(lblNewLabel);
			
			
			getchart(date);
			add(panel);
			
			
			day=Integer.parseInt(date.substring(8, 10));
			mounth=Integer.parseInt(date.substring(5, 7));
			year=Integer.parseInt(date.substring(0, 4));
			
			
			
			JLabel lblNewLabel_1 = new JLabel(date);
			lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(260, 0, 134, 25);
			add(lblNewLabel_1);
			
			JButton button_1 = new JButton("\u540E\u4E00\u5929");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					day++;
					int y=isleapyear(year);
					if(day>d[y][mounth-1]){
						day=1;
						mounth++;
					}
					if(mounth>12){
						mounth=1;
						year++;
					}
					now=year+"-"+mounth+"-"+day/10+day%10;
					getchart(now);
					lblNewLabel_1.setText(now);
					
					if(now.equals(date)){
						button_1.setEnabled(false);
					}
				}
			});
			button_1.setBounds(357, 537, 93, 23);
			add(button_1);
			button_1.setEnabled(false);
			
			JButton button = new JButton("\u524D\u4E00\u5929");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					day--;
					int y=isleapyear(year);
					if(day==0){
						mounth--;
						day=d[y][mounth-1];
					}
					if(mounth==0){
						year--;
						mounth=12;
						
					}
					now=year+"-"+mounth+"-"+day/10+day%10;
					getchart(now);
					button_1.setEnabled(true);
					lblNewLabel_1.setText(now);
				}
			});
			button.setBounds(225, 537, 93, 23);
			add(button);
			
			
			
			
	}
	
	public int isleapyear(int y){
		if((y%4==0&&y%100!=0)||y%400==0)return 1;
		return 0;
	}
	int money;
	public void getchart(String date){
		
			if(panel!=null)remove(panel);
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 
		 try {
	            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

	            Statement s = con.createStatement();  // Statement类用来提交SQL语句

	            ResultSet rs = s.executeQuery("select * from xiaoshou_day where time like '"+date+"%'");  // 提交查询，返回的表格保存在rs中

	            money=0;
	            System.out.println(rs.getRow());
	            while(rs.next()) {  // ResultSet指针指向下一个“行”
	            	money+=Integer.parseInt(rs.getString("money"));
	            	dataset.addValue(Integer.parseInt(rs.getString("money")), "销售额", rs.getString("lei")+":"+rs.getString("name"));
	            	System.out.println(rs.getString("time"));
	            }
	            lblNewLabel.setText("本日销售金额："+money+"元");
	            s.close();     // 释放Statement对象
	            con.close();   // 关闭到MySQL服务器的连接
	        }
	        catch(SQLException sql_e) {     // 都是SQLException
	            System.out.println("xiaoshou"+sql_e);
	        }
		 
		 
		
			// 添加数据
			
			JFreeChart chart = ChartFactory.createLineChart("食品公司日销售额", // 主标题的名称
					"",// X轴的标签
					"金额",// Y轴的标签
					dataset, // 图标显示的数据集合
					PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
					true,// 是否显示子标题
					true,// 是否生成提示的标签
					false); // 是否生成URL链接
			// 处理图形上的乱码
			// 处理主标题的乱码
			chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
			// 处理子标题乱码
			chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
			// 获取图表区域对象
			CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
			// 获取X轴的对象
			CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
			// 获取Y轴的对象
			NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
			// 处理X轴上的乱码
			categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			// 处理X轴外的乱码
			categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
			// 处理Y轴上的乱码
			numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			
			// 处理Y轴外的乱码
			numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
			// 处理Y轴上显示的刻度，以10作为1格
			numberAxis.setAutoTickUnitSelection(false);
			
			// 获取绘图区域对象
			LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
					.getRenderer();
			// 在图形上显示数字
			lineAndShapeRenderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			lineAndShapeRenderer.setBaseItemLabelsVisible(true);
			lineAndShapeRenderer
					.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
			// 在图形上添加转折点（使用小矩形显示）
			Rectangle shape = new Rectangle(10, 10);
			lineAndShapeRenderer.setSeriesShape(0, shape);
			lineAndShapeRenderer.setSeriesShapesVisible(0, true);

			//在D盘目录下生成图片
			File file = new File("chart1.jpg");
			try {
				ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 使用ChartFrame对象显示图像
			
			panel = new ChartPanel(chart);
			panel.setVisible(true);
			panel.setBounds(0, 36, 637, 449);
			add(panel);
			repaint();
			
			int d=0,m=money;
			while(m/10!=0){d++;m/=10;}
			NumberTickUnit unit = new NumberTickUnit(Math.pow(10, d));//设置边距
			numberAxis.setTickUnit(unit);
	}
}

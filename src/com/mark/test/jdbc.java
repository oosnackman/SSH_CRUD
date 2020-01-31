package com.mark.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class jdbc {

	public static void main(String[] args) throws SQLException {


	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testJdbc() {
		
		if(sessionFactory!=null) {
			System.out.println("連線失敗!!!");
		}else {
			System.out.println("連線成功!!!");
		}
	}
	@Test
	public void testJdbc_jdk11() {

		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SSH_1";

	
		try {
	
			Connection con = DriverManager.getConnection(connectionUrl, "sa", "love2004");

			if (con != null && !con.isClosed()) {
				System.out.println("資料庫連線測試成功！");
				
				 Statement stmt = con.createStatement();
				 String SQL = "SELECT TOP 10 * FROM SSH_DEPARTMENT";
		          ResultSet rs = stmt.executeQuery(SQL);
		          
		          while (rs.next()) {
		                System.out.println(rs.getString("ID") + ": " + rs.getString("DEPARTMENT_NAME"));
		            }
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("找不到驅動程式類別");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJdbcjdk1_7() {

		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SSH_1";

	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl, "sa", "love2004");

			if (con != null && !con.isClosed()) {
				System.out.println("資料庫連線測試成功！");
				
				 Statement stmt = con.createStatement();
				 String SQL = "SELECT TOP 10 * FROM SSH_DEPARTMENT";
		          ResultSet rs = stmt.executeQuery(SQL);
		          
		          while (rs.next()) {
		                System.out.println(rs.getString("ID") + ": " + rs.getString("DEPARTMENT_NAME"));
		            }
				con.close();
			}

		} catch (SQLException e) {
			System.out.println("找不到驅動程式類別");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

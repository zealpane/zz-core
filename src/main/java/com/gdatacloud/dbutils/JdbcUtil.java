package com.gdatacloud.dbutils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static final String DRIVERCLASS = null;

	static {
		InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
		properties.getProperty("");
	}
	
	/**
	 * 加载驱动
	 * @throws ClassNotFoundException 
	 */
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName(DRIVERCLASS);
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://218.28.238.170:3306/lock_db?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull"
				, "root", "kzxkdzt007!");
	}
	
	/**
	 * 针对查询的释放资源
	 * @param conn
	 * @param statement
	 * @param rs
	 */
	public static void release(Connection conn, Statement statement, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement = null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}
	/**
	 * 针对增删改的释放资源
	 * @param conn
	 * @param statement
	 */
	public static void release(Connection conn, Statement statement) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement = null;
		}
	}
}

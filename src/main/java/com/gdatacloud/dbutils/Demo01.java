package com.gdatacloud.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 传统jdbc方式
	 * @throws SQLException 
	 */
	public void jdbcConnect() {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {			
			// 获取连接
			conn = JdbcUtil.getConnection();
			// 编写sql，获取执行sql的对象
			String sql = "select * from user where id = ?";
			pStatement = conn.prepareStatement(sql);
			// 传递参数并执行
			pStatement.setInt(1, 5);
			rs = pStatement.executeQuery();
			if (rs.next()) {
				// 在这内给对象赋值
				rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放资源
			JdbcUtil.release(conn, pStatement, rs);
		}
	}
}

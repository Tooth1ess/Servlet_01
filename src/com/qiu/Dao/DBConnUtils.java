package com.qiu.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 用来封装增删改查时候连接数据库的操作
 */
public class DBConnUtils {

	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test";
	private static String jdbcUser = "root";
	private static String jdbcPwd = "123456";


	/*
	 * 加载jdbc驱动，与数据库连接
	 */
	public static Connection getConn() {
		Connection conn = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 关闭所有打开的资源后断开连接
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

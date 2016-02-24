package com.qiu.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ������װ��ɾ�Ĳ�ʱ���������ݿ�Ĳ���
 */
public class DBConnUtils {

	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test";
	private static String jdbcUser = "root";
	private static String jdbcPwd = "123456";


	/*
	 * ����jdbc�����������ݿ�����
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
	 * �ر����д򿪵���Դ��Ͽ�����
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

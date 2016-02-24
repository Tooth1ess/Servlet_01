package com.qiu.Dao;

import com.qiu.module.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * �����ɾ�Ĳ����ط��������Ҷ����������ݿ���������Ϣ�����ӵ�ַ���û��������룩��
 */

public class UserDao {

	/*
	 * �������ݵ����ݿ�
	 */
	public boolean addUser(UsersInfo user) {

		boolean flag = true;
		String sql = "insert into user (name, password) values ('" + user.getName() + "','"
				+ user.getPwd() + "')";
		Connection conn = null;
		Statement stmt = null;
		conn = DBConnUtils.getConn();

		try {
				stmt = conn.createStatement();
				int i = stmt.executeUpdate(sql);
	
				if (i == 0) {
					flag = false;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnUtils.closeAll(null, stmt, conn); // �ر����ӣ����ڲ���������漰ResultSet�࣬�������rs����رգ���null���档
		}

		return flag;
	}

	/*
	 * �޸����ݵ����ݿ�
	 */

	public boolean alterUser(UsersInfo user) {

		boolean flag = true;
		String sql = "update user set password='"+user.getPwd()+"' where name='"+user.getName()+"'";
		Connection conn = null;
		Statement stmt = null;
		conn = DBConnUtils.getConn();

		try {
				stmt = conn.createStatement();
				int i = stmt.executeUpdate(sql);
	
				if (i == 0) {
					flag = false;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnUtils.closeAll(null, stmt, conn); // �ر����ӣ����ڲ���������漰ResultSet�࣬�������rs����رգ���null���档
		}

		return flag;
	}

	/*
	 * ɾ�����������ݿ�
	 */
	public boolean dropUser(int id) {

		boolean flag = true;
		String sql = "delete from user where id="+ id;
		Connection conn = null;
		Statement stmt = null;
		conn = DBConnUtils.getConn();

		try {
				stmt = conn.createStatement();
				int i = stmt.executeUpdate(sql);
	
				if (i == 0) {
					flag = false;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnUtils.closeAll(null, stmt, conn); // �ر����ӣ����ڲ���������漰ResultSet�࣬�������rs����رգ���null���档
		}
		
		return flag;
	}

	/*
	 * �鿴���������ݿ�
	 */
	public List<UsersInfo> selectUser() {

		List<UsersInfo> list = new ArrayList<UsersInfo>();
		String sql = "select *from user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DBConnUtils.getConn(); // getConn()�����Ǿ�̬�ģ�ֱ��������ý������ӡ�

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UsersInfo user = new UsersInfo();
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnUtils.closeAll(rs, stmt, conn); // �ر�����.
		}

		return list;
	}
}

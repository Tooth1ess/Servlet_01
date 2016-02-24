package com.qiu.Dao;

import com.qiu.module.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * 存放增删改查的相关方法，并且定义链接数据库的相关性信息（链接地址，用户名，密码）；
 */

public class UserDao {

	/*
	 * 增加数据到数据库
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
			DBConnUtils.closeAll(null, stmt, conn); // 关闭连接，由于插入操作不涉及ResultSet类，故其对象rs无需关闭，用null代替。
		}

		return flag;
	}

	/*
	 * 修改数据到数据库
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
			DBConnUtils.closeAll(null, stmt, conn); // 关闭连接，由于插入操作不涉及ResultSet类，故其对象rs无需关闭，用null代替。
		}

		return flag;
	}

	/*
	 * 删除数据在数据库
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
			DBConnUtils.closeAll(null, stmt, conn); // 关闭连接，由于插入操作不涉及ResultSet类，故其对象rs无需关闭，用null代替。
		}
		
		return flag;
	}

	/*
	 * 查看数据在数据库
	 */
	public List<UsersInfo> selectUser() {

		List<UsersInfo> list = new ArrayList<UsersInfo>();
		String sql = "select *from user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DBConnUtils.getConn(); // getConn()方法是静态的，直接用类调用建立连接。

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
			DBConnUtils.closeAll(rs, stmt, conn); // 关闭连接.
		}

		return list;
	}
}

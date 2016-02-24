package com.qiu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.qiu.Dao.UserDao;
import com.qiu.module.UsersInfo;

import java.util.List;

/**
 * Servlet implementation class ConnMySql
 */
public class ConnMySql extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnMySql() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		UserDao userDao = new UserDao();
		UsersInfo user = new UsersInfo();
//		List<UsersInfo> list = userDao.selectUser();
//		
//		for (UsersInfo usersInfo : list) {
//			System.out.println(usersInfo.getName());
//			System.out.println(usersInfo.getPwd());
//			out.println("name=" + usersInfo.getName());
//			out.println("password=" + usersInfo.getPwd());
//		}
		
		
		user.setName("qiu");
		user.setPwd("123456");
		boolean flag = userDao.addUser(user);
		
		if (flag) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
//		
//		boolean flag = userDao.dropUser(1);
//		
//		if (flag) {
//			System.out.println("删除成功");
//		} else {
//			System.out.println("删除失败");
//		}
//		
//		user.setName("li");
//		user.setPwd("123321");
//		boolean flag = userDao.alterUser(user);
//		if (flag) {
//			System.out.println("修改成功");
//		} else {
//			System.out.println("修改失败");
//		}

	}
}

package com.qiu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiu.Dao.UserDao;
import com.qiu.module.UsersInfo;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
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
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("name=" + new String(name.getBytes("iso-8859-1"), "utf-8") + "  password=" + pwd);

		System.out.println("name =" + new String(name.getBytes("iso-8859-1"), "utf-8"));
		System.out.println("password =" + pwd);
		
		UserDao userDao = new UserDao();
		UsersInfo user = new UsersInfo();
		
		user.setName(name);
		user.setPwd(pwd);
		boolean flag = userDao.addUser(user);
		
		if (flag) {
			System.out.println("Ìí¼Ó³É¹¦");
		} else  {
			System.out.println("Ìí¼ÓÊ§°Ü");
		}
		
		
//		boolean flag = userDao.dropUser(1);
//		
//		if (flag) {
//			System.out.println("É¾³ý³É¹¦");
//		} else {
//			System.out.println("É¾³ýÊ§°Ü");
//		}
	}

}

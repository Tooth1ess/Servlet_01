package com.qiu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qiu.Dao.GoodsInfoDao;
import com.qiu.Dao.UserDao;
import com.qiu.module.GoodsInfo;
import com.qiu.module.JsonResult;
import com.qiu.module.UsersInfo;

/**
 * Servlet implementation class ScanGoods
 */
public class ScanGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScanGoods() {
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
		
		//使用Dao类方法查看数据库数据并返回集合list
		GoodsInfoDao infoDao = new GoodsInfoDao();
		List<GoodsInfo> goodsInfos = infoDao.selectUser();
		
		//把数据库信息封装成Json格式，传给客服端。
		JsonResult result = new JsonResult();
		result.setResultCode(200); //应答时返回的请求码
		result.setGoodsData(goodsInfos);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(result));
		out.println(gson.toJson(result));

	}

}

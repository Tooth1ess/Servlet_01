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
import com.qiu.module.Person;
import com.qiu.module.Result;
import com.qiu.module.SchoolInfo;

/**
 * Servlet implementation class JsonServlet
 */
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Result result = new Result();
		result.setResult(1);
		List<Person> list = new ArrayList<Person>();
		result.setPersonData(list);
		Person person1 = new Person();
		person1.setName("qiu");
		person1.setAge(12);
		person1.setUrl("http://i1.sinaimg.cn/download/idx/2011/0603/U74P176T43D51379F941DT20110603080955.JPG");
		List<SchoolInfo> schoolInfos = new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo1 = new SchoolInfo();
		schoolInfo1.setSchoolName("民大");
		SchoolInfo schoolInfo2 = new SchoolInfo();
		schoolInfo2.setSchoolName("川大");
		schoolInfos.add(schoolInfo1);
		schoolInfos.add(schoolInfo2);
		person1.setSchoolInfo(schoolInfos);
		list.add(person1);
		
		Person person2 = new Person();
		person2.setName("li");
		person2.setAge(24);
		person2.setUrl("http://i1.sinaimg.cn/download/idx/2011/0603/U74P176T43D51379F941DT20110603080955.JPG");
		List<SchoolInfo> schoolInfos1 = new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo11 = new SchoolInfo();
		schoolInfo11.setSchoolName("兰大");
		SchoolInfo schoolInfo22 = new SchoolInfo();
		schoolInfo22.setSchoolName("理工大");
		schoolInfos1.add(schoolInfo11);
		schoolInfos1.add(schoolInfo22);
		person2.setSchoolInfo(schoolInfos1);
		list.add(person2);

		Gson gson = new Gson();

		System.out.println(gson.toJson(result));
		out.println(gson.toJson(result));
	}

}

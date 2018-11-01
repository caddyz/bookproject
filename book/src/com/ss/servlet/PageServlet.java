package com.ss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet{
	
	private static final long serialVersionUID = -6262834430789934717L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(0);
		session.removeAttribute("startV");
		session.removeAttribute("endV");
		String startV = req.getParameter("start");
		String endV = req.getParameter("end");
		System.out.println("P:"+startV+":"+endV);
		session.setAttribute("startV", startV);
		session.setAttribute("endV", endV);
//		req.setAttribute("start", startV);
//		req.setAttribute("end", endV);
		req.getRequestDispatcher("SearchServlet").forward(req, resp);
	}

	
}

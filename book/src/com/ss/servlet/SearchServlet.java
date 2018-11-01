package com.ss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ss.model.BookShow;
import com.ss.service.IFindBooksService;
import com.ss.service.impl.FindBooksServiceImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet{
	private IFindBooksService f = new FindBooksServiceImpl();
	private static final long serialVersionUID = -8968824597248762071L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se = req.getSession();
		String startPrice =(String) se.getAttribute("startV");
//		String startPrice =(String) req.getAttribute("startV");
//		String endPrice =(String) req.getAttribute("endV");
		String endPrice =(String) se.getAttribute("endV");
		System.out.println(startPrice+":"+endPrice);
//		System.out.println(startPrice+":"+endPrice);
//		Integer startNum = Integer.parseInt(startPrice.trim());
//		Integer endNum = Integer.parseInt(endPrice.trim());
//		System.out.println(startNum+endNum);
		int sNum = Integer.parseInt(startPrice);
//		System.out.println(sNum);
		int eNum = Integer.parseInt(endPrice);
//		System.out.println(eNum);
		Integer art = 3;
		//获取总页数
		Integer page = f.findConditionNum(art,sNum,eNum);
//		System.out.println(pageNum);
		req.setAttribute("page", page);
		//设置当前页
		Integer counrt = 1;
		String str = req.getParameter("num");
		if(str!=null) {
			counrt = Integer.parseInt(str);
		}
		req.setAttribute("counrt", counrt);
		String sql = "SELECT author,title,price FROM mybooks WHERE price BETWEEN ? AND ? LIMIT ?,?;";
		List<BookShow> li = f.findAllBooks(sql, BookShow.class, sNum, eNum, (counrt - 1) * art, art);
//		System.out.println(list);
		req.setAttribute("li", li);
		req.getRequestDispatcher("searchbookshow.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

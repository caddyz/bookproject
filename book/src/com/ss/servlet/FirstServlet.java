package com.ss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.model.BookShow;
import com.ss.service.IFindBooksService;
import com.ss.service.impl.FindBooksServiceImpl;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{
	private IFindBooksService fb = new FindBooksServiceImpl();
	private static final long serialVersionUID = 4935090568441474500L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置每页条数
		Integer article = 3;
		//获取总页数
		Integer pageNum = fb.findPageNum("mybooks", article);
		req.setAttribute("pageNum", pageNum);
		//设置当前页
		Integer pageNow = 1;
		String str = req.getParameter("num");
		if(str!=null) {
			pageNow = Integer.parseInt(str);
		}
		req.setAttribute("pageNow", pageNow);
		
		//获取分页数据

		String sql = "SELECT author,title,price FROM mybooks LIMIT ?,?;";
		List<BookShow> list = fb.findAllBooks(sql, BookShow.class, (pageNow - 1) * article, article);
		req.setAttribute("list", list);
		req.getRequestDispatcher("bookshow.jsp").forward(req, resp);
	}
	
}

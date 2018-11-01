package com.ss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.model.MyBook;
import com.ss.service.IFindBooksService;
import com.ss.service.impl.FindBooksServiceImpl;

@WebServlet("/BookDetailedInfoServlet")
public class BookDetailedInfoServlet extends HttpServlet{
	private IFindBooksService book = new FindBooksServiceImpl();
	private static final long serialVersionUID = 46959365913434992L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String bookName = req.getParameter("name");
		String sql = "SELECT * FROM mybooks WHERE title = '"+bookName+"';";
		List<MyBook> bookInfo = book.findAllBooks(sql, MyBook.class);
		MyBook Abook = bookInfo.get(0);
		req.setAttribute("book", Abook);
		req.getRequestDispatcher("bookInfo.jsp").forward(req, resp);
	}
	
	
}

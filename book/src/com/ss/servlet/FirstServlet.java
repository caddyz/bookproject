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
		//����ÿҳ����
		Integer article = 3;
		//��ȡ��ҳ��
		Integer pageNum = fb.findPageNum("mybooks", article);
		req.setAttribute("pageNum", pageNum);
		//���õ�ǰҳ
		Integer pageNow = 1;
		String str = req.getParameter("num");
		if(str!=null) {
			pageNow = Integer.parseInt(str);
		}
		req.setAttribute("pageNow", pageNow);
		
		//��ȡ��ҳ����

		String sql = "SELECT author,title,price FROM mybooks LIMIT ?,?;";
		List<BookShow> list = fb.findAllBooks(sql, BookShow.class, (pageNow - 1) * article, article);
		req.setAttribute("list", list);
		req.getRequestDispatcher("bookshow.jsp").forward(req, resp);
	}
	
}

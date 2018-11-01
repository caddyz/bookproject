package com.ss.test;



import java.util.List;

import org.junit.jupiter.api.Test;

import com.ss.model.BookShow;
import com.ss.model.MyBook;
import com.ss.service.IFindBooksService;
import com.ss.service.impl.FindBooksServiceImpl;



public class DemoTest {
	@Test
	public void DBTest() {
		/*GeneralGetData data = new GeneralGetData();
		String sql = "SELECT author,title,price FROM mybooks;";
//		List<MyBook> list = data.GeneralSelect(sql, MyBook.class);
		List<BookShow> list = data.GeneralSelect(sql, BookShow.class);
		System.out.println(list);*/
		IFindBooksService i = new FindBooksServiceImpl();
//		String sql = "SELECT author,title,price FROM mybooks;";
		String sql = "SELECT * FROM mybooks WHERE title = 'Oracle DBA ½Ì²Ä';";
//		Integer num = i.findPageNum("mybooks", 3);
		List<MyBook> list = i.findAllBooks(sql, MyBook.class);
		System.out.println(list);
	}
}

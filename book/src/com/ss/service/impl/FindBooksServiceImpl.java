package com.ss.service.impl;

import java.util.List;

import com.ss.dao.ICheckBooksDao;
import com.ss.dao.impl.CheckBooksDaoImpl;
import com.ss.service.IFindBooksService;

public class FindBooksServiceImpl implements IFindBooksService{

	private ICheckBooksDao bookDao = new CheckBooksDaoImpl();
	@Override
	public <E> List<E> findAllBooks(String sql, Class<E> clazz, Object... obj) {
		return bookDao.getAllBooks(sql, clazz, obj);
	}
	
	@Override
	public Integer findPageNum(String tableName,Integer article) {
		return bookDao.getPageNumber(tableName, article);
	}

	@Override
	public Integer findConditionNum(Integer article,Object...obj) {
		// TODO Auto-generated method stub
		return bookDao.getConditionNum(article,obj);
	}
}

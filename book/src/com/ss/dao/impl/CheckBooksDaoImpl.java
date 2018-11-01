package com.ss.dao.impl;

import java.util.List;

import com.ss.dao.ICheckBooksDao;
import com.ss.util.GeneralGetData;

public class CheckBooksDaoImpl implements ICheckBooksDao {

	private GeneralGetData data = new GeneralGetData();
	@Override
	public <E> List<E> getAllBooks(String sql, Class<E> clazz, Object... obj) {
		return data.GeneralSelect(sql, clazz, obj);
	}
	@Override
	public Integer getPageNumber(String tableName, Integer article) {
		return data.getPageNumber(tableName, article);
	}
	@Override
	public Integer getConditionNum(Integer article,Object...obj) {
		return data.getConditionCount(article,obj);
	}
}

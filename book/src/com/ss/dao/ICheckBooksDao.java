package com.ss.dao;

import java.util.List;

public interface ICheckBooksDao {
	<E>List<E> getAllBooks(String sql,Class<E> clazz,Object...obj);
	Integer getPageNumber(String tableName,Integer article);
	Integer getConditionNum(Integer article,Object...obj);
}

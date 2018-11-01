package com.ss.service;

import java.util.List;


public interface IFindBooksService {
	<E>List<E> findAllBooks(String sql,Class<E> clazz,Object...obj);
	Integer findPageNum(String tableName,Integer article);
	Integer findConditionNum(Integer article,Object...obj);
}

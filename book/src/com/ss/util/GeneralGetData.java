package com.ss.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneralGetData {
	public <E>List<E> GeneralSelect(String sql,Class<E> clazz,Object...obj){
		List<E> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		try {
			conn = C3p0Pools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			if(obj!=null&&obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i+1, obj[i]);
				}
			}
//			System.out.println(sql);
			set = prep.executeQuery();
			ResultSetMetaData data = set.getMetaData();
			String columnLabel = null;
			Object columnValue = null;
			while(set.next()) {
				E instance = clazz.newInstance();
				for (int i = 1; i < data.getColumnCount()+1; i++) {
					columnLabel = data.getColumnLabel(i);
					columnValue = set.getObject(columnLabel);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(instance, columnValue);
				}
				list.add(instance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			C3p0Pools.closeConn(conn, prep, set);
		}
		return list;
	}
	
	public Integer GeneralUpDate(String sql,Object...obj) {
		Integer num = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = C3p0Pools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			if(obj!=null&&obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i+1, obj[i]);
				}
			}
			num = prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Pools.closeConn(conn, prep, null);
		}
		return num;
	}
	public Integer getPageNumber(String tableName,Integer article) {
		Integer number = 0;
		String sql = "SELECT COUNT(*) FROM "+tableName+";";
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		try {
			conn = C3p0Pools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			set = prep.executeQuery();
			while(set.next()) {
				number = set.getInt(1);
			}
			if(number%article==0) {
				number = number/article;
			}else {
				number = number/article + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Pools.closeConn(conn, prep, null);
		}
		return number;
	}
	//条件查询的总条数
	public Integer getConditionCount(Integer article,Object...obj) {
		Integer number = 0;
		String sql = "SELECT COUNT(*) FROM mybooks WHERE price BETWEEN ? AND ?;";
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet set = null;
		try {
			conn = C3p0Pools.getInstance().getConnection();
			prep = conn.prepareStatement(sql);
			if(obj!=null&&obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					prep.setObject(i+1, obj[i]);
				}
			}
			set = prep.executeQuery();
			while(set.next()) {
				number = set.getInt(1);
			}
			if(number%article==0) {
				number = number/article;
			}else {
				number = number/article + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Pools.closeConn(conn, prep, null);
		}
		return number;
	}
	
}

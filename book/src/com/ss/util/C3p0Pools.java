package com.ss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Pools {
	private static C3p0Pools instance;
	private ComboPooledDataSource cds;
	private C3p0Pools() {
		cds = new ComboPooledDataSource();
	}
	public static C3p0Pools getInstance() {
		if(instance == null) {
			synchronized (C3p0Pools.class) {
				if(instance == null) {
					instance = new C3p0Pools();
				}
			}
		}
		return instance;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = cds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(Connection conn,PreparedStatement prep,ResultSet set) {
		try {
			if(set!=null) {
				set.close();
			}
			if(prep!=null) {
				prep.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

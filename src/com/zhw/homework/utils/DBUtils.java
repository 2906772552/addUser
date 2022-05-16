package com.zhw.homework.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtils {

	
	static String DriverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://192.168.132.128:3306/milk_tea_mall?characterEncoding=utf-8";
	static String userName = "root";
	static String password = "123";

	static{
		try {
			Class.forName(DriverClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败"+e.getMessage());
		}
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			System.out.println("创建连接失败"+e.getMessage());
		}
		return conn;
	}

	public static void close(ResultSet rs,Statement state,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("关闭ResultSet失败"+e.getMessage());
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				System.out.println("关闭PreparedStatement失败"+e.getMessage());
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭Connection失败"+e.getMessage());
			}
		}
	}
	
}

package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC
{

	public static void main(String[] args)
	{
		try
		{
//			加载MySql驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
//			连接数据库，获得连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			System.out.println("数据库连接成功");
//			创建执行环境
			Statement statement = conn.createStatement();
//			执行sql语句，得到结果集
			ResultSet result = statement.executeQuery("SELECT * FROM student");
			while(result.next())
			{
				System.out.print(result.getInt("id")+" ");
				System.out.print(result.getString("name")+" ");
				System.out.print(result.getInt("age")+" ");
				System.out.println(result.getString("gender"));
				System.out.println(result.getTime("birthday"));
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.print("驱动加载失败");
			System.out.println("数据库连接失败");
		}

	}

}

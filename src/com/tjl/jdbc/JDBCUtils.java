package com.tjl.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils
{

private static String driver;
private static String url;
private static String username;
private static String password;

//    静态语句
	static {
//		JDBCUtils.class获取对象
//		getClassLoader()类加载器
//      getResourceAsStream("db.properties")加载资源文件放到输入流
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        
        
//      创建properties对象
        Properties p = new Properties();
//        加载流文件
        try
		{
			p.load(is);
	        driver = p.getProperty("driver");
	        url = p.getProperty("url");
	        username = p.getProperty("username");
	        password = p.getProperty("password");
//	      加载MySQL驱动
	        Class.forName(driver);
	        System.out.println("驱动加载成功");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
//        获得连接对象的方法
       public static Connection getConnection( ){
    	try
		{
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e)
		{
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}   
    	return null;
       }
//     释放资源的方法   
        public static void close(Connection conn,Statement statement,ResultSet result){
		try
		{
			if(result != null) {
				result.close();
				result = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
			if(statement != null) {
				statement.close();
				statement = null;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		}
        
        
        
        
        
        
        
        
        
        
        
        


}
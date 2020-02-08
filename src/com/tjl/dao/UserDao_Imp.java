package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class UserDao_Imp implements UserDao
{

	private static final String SQL_USER_LOGIN = "SELECT type FROM dl WHERE uname=? AND upass=? ";
	private static final String SQL_USER_INSERT = "INSERT INTO dl VALUES(id,?,?,2)";
	private static final String SQL_USER_DELETE = "DELETE FROM dl WHERE uname=?";
	private static final String SQL_USER_UPDATE = "UPDATE dl SET upass=? WHERE uname=?";
	private static final String SQL_USER_SELECT = "SELECT * FROM dl WHERE uname=?;";

	@Override
	public int login(User user)
	{
		//连接数据库,创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try
		{
//			创建预编译环境
			prepareStatement = conn.prepareStatement(SQL_USER_LOGIN);
//			设置sql语句中的参数
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
//			执行语句
			result = prepareStatement.executeQuery();
			while(result.next()) {
//			确定权限
				int type = result.getInt("type");
			    return type;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, prepareStatement, result);
		}
		
		return -1;
	}

	@Override
	public boolean insert(User user)
	{
		//连接数据库,创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//			创建预编译环境
			PreparedStatement prepareStatement = null;
			try
			{
				prepareStatement = conn.prepareStatement(SQL_USER_INSERT);
//				设置sql语句中的参数
				prepareStatement.setString(1, user.getUname());
				prepareStatement.setString(2, user.getUpass());
				int line = prepareStatement.executeUpdate();
                return line>0?true:false;
			} catch (SQLException e)
			{		
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtils.close(conn, prepareStatement, null);
			}
		return false;
	}

	@Override
	public boolean delete(String uname)
	{
		//连接数据库,创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//			创建预编译环境
			PreparedStatement prepareStatement = null;
			try
			{
				prepareStatement = conn.prepareStatement(SQL_USER_DELETE);
//				设置sql语句中的参数
				prepareStatement.setString(1,uname);
//				执行语句
				int line = prepareStatement.executeUpdate();
				return line>0?true:false;
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtils.close(conn, prepareStatement, null);
			}
		return false;
	}

	@Override
	public boolean update(User user)
	{
		//连接数据库,创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//			创建预编译环境
			PreparedStatement prepareStatement = null;
			try
			{
				prepareStatement = conn.prepareStatement(SQL_USER_UPDATE);
//				设置sql语句中的参数
				prepareStatement.setString(1, user.getUpass());
				prepareStatement.setString(2, user.getUname());
//				执行语句
				int line = prepareStatement.executeUpdate();
				return line>0?true:false;
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtils.close(conn, prepareStatement, null);
			}
		return false;
	}

	@Override
	public User select(String uname)
	{
		//连接数据库,创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
//			创建预编译环境
			PreparedStatement prepareStatement = null;
			ResultSet result = null;
			try
			{
				prepareStatement = conn.prepareStatement(SQL_USER_SELECT);
//				设置sql语句中的参数
				prepareStatement.setString(1,uname);
//				执行语句
				result = prepareStatement.executeQuery();
				while(result.next()) {
					int id = result.getInt("id");
					uname = result.getString("uname");
					String upass = result.getString("upass");
					int type = result.getInt("type");
					return new User(id,uname,upass,type);
				}
                
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtils.close(conn, prepareStatement,result);
			}
			return null;
	}

}

package com.tjl.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.jdbc.JDBCUtils;

public class JDBCUtilsTest
{
	/**数据库连接的测试
	 * @throws Exception
	 */
	@Test
	public void jdbcConnectionTest() throws Exception
{
	Connection conn = JDBCUtils.getConnection();
    Statement statement = conn.createStatement();
    ResultSet result = statement.executeQuery("SELECT * FROM student");
    while(result.next()) {
		System.out.print(result.getInt("id")+" ");
		System.out.print(result.getString("name")+" ");
		System.out.print(result.getInt("age")+" ");
		System.out.println(result.getString("gender"));
		System.out.println(result.getTime("birthday"));
    }
}
	/**登录的测试
	 * @throws Exception
	 */
	@Test
	public void loginTest() throws Exception
	{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("张三","zs");
		int login = userDao_Imp.login(user);
		System.out.println(login);
	}
  
	@Test
	public void insertTest() throws Exception
	{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("哈哈","hh");
		boolean insert = userDao_Imp.insert(user);
		System.out.println(insert);
	}
	
	@Test
	public void deleteTest() throws Exception
	{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("哈哈","hh");
		boolean delete = userDao_Imp.delete(user.getUname());
		System.out.println(delete);
	}
	@Test
	public void updateTest() throws Exception
	{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("哈哈","hh");
		boolean insert = userDao_Imp.update(user);
		System.out.println(insert);
	}
	
	@Test
	public void selectTest() throws Exception
	{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("哈哈","hh");
		User user2 = userDao_Imp.select(user.getUname());
		System.out.println(user2);
	}
}

package com.tjl.controller;



import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

public class Controll
{

	public static void main(String[] args)
	{
		while(true) {
		User user = View.indexView();
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		int type = userDao_Imp.login(user);
		switch (type)
		{
		case -1:
			System.out.println("输入有误,请重新输入");
			break;
		case 1:
			System.out.println("欢迎你管理员");
			ManageServer();
			break;
		case 2:
			System.out.println("欢迎你学生");
			StudentServer();
			break;
		default:
			break;
		}
	}
	}
	private static void ManageServer()
	{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		while(true) {
		int item = View.ManagerMenuView();	
		boolean flag;
		switch (item)
		{
		case 0:
			System.exit(-1);
			break;
		case 1:
			User user = View.addMenuView();
			flag = userDao_Imp.insert(user);
			System.out.println(flag?"添加成功":"添加失败");
			break;
		case 2:
			String uname = View.delMenuView();
			flag = userDao_Imp.delete(uname);
			System.out.println(flag?"删除成功":"删除失败");
			break;
		case 3:
			User user2 = View.updateMenuView();
			flag = userDao_Imp.update(user2);
			System.out.println(flag?"修改成功":"修改失败");
			break;
		case 4:
			String name = View.selectMenuView();
			User user3 = userDao_Imp.select(name);
			View.printMenuView(user3);
			break;
		default:
			break;
		}
		}
	}

	private static void StudentServer()
	{
		while(true) {
		User user = View.StudentMenuView();
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		boolean flag = userDao_Imp.update(user);
		System.out.println(flag?"修改成功":"修改失败");
	}
	}
}

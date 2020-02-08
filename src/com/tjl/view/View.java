package com.tjl.view;

import java.awt.Window.Type;
import java.util.Scanner;

import com.tjl.bean.User;

public class View
{
	private static Scanner input =new Scanner(System.in);
	//首页视图
     public static User indexView()
	{
    	 System.out.println("**********************************************");
    	 System.out.println("*************\t学生信息管理系统\t*************");
    	 System.out.println("*************\t请根据提示操作\t***************");
    	 System.out.println("*************\t请输入用户名\t*****************");
    	 String uname = input.nextLine();
    	 System.out.println("*************\t请输入密码\t*******************");
    	 String upass = input.nextLine();
    	 System.out.println("**********************************************");
		return new User(uname,upass);
	}
     //管理员界面
     public static int ManagerMenuView()
	{
    	 System.out.println("**********************************************");
    	 System.out.println("*************\t欢迎你管理员\t*****************");
    	 System.out.println("*************\t请根据提示操作\t***************");
    	 System.out.println("*************\t0.退出\t***********************");
    	 System.out.println("*************\t1.添加学生信息\t****************");
    	 System.out.println("*************\t2.删除学生信息\t****************");
    	 System.out.println("*************\t3.修改学生信息\t****************");
    	 System.out.println("*************\t4.查询学生信息\t****************");
    	 System.out.println("*************\t请输入你的选择\t****************");    	 
    	 String type = input.nextLine();
    	 int item = Integer.parseInt(type);
         if(item<0||item>4) {
        	 System.out.println("输入错误,请重新输入");
        	 return ManagerMenuView();
         }
    	 System.out.println("**********************************************"); 
    	 return item;
		}
     
     public static User addMenuView() {
    	 System.out.println("**********************************************");
    	 System.out.println("*************\t请根据提示操作\t***************");
    	 System.out.println("***********\t请输入新添加的账号\t*************");
    	 String uname = input.nextLine();
    	 System.out.println("***********\t请输入新添加的密码\t*************");
    	 String upass = input.nextLine();
    	 System.out.println("**********************************************");
		return new User(uname,upass);
     }
     
     /**删除学生信息的菜单视图
     * @return 返回删除学生的账号
     */
    public static String delMenuView() {
    	 System.out.println("**********************************************");
    	 System.out.println("*************\t请根据提示操作\t***************");
    	 System.out.println("**********\t请输入要删除的账号\t**************");
    	 String uname = input.nextLine();
    	 System.out.println("**********************************************");
    	 return uname;
     }
     
     /**修改学生信息的菜单视图
     * @return User(uname)	旧账号uname对应的新密码upass
     */
    public static User updateMenuView() {
    	 System.out.println("**********************************************");
    	 System.out.println("*************\t请根据提示操作\t***************");
    	 System.out.println("*************\t请输入用户名\t*****************");
    	 String uname = input.nextLine();
    	 System.out.println("*************\t请输入新的密码\t*******************");
    	 String upass = input.nextLine();
    	 System.out.println("**********************************************");
    	 return new User(uname,upass);
     }
     
     /**查询学生信息的菜单视图
     * @return 返回要查询的学生账号
     */
    public static String selectMenuView() {
    	 System.out.println("**********************************************");
    	 System.out.println("*************\t请根据提示操作\t***************");
    	 System.out.println("*************\t请输入用户名\t*****************");
    	 String uname = input.nextLine();
    	 System.out.println("**********************************************");
    	 return uname;
     }
    
    public static void printMenuView(User user) {
    	System.out.println("id:"+user.getId());
    	System.out.println("uname:"+user.getUname());
    	System.out.println("upass:"+user.getUpass());
    	if(user.getType()==1) {
    	System.out.println("权限:管理员");
    	}else {
    	System.out.println("权限:学生");
    	}
    	}
    
    public static User StudentMenuView()
	{
   	 System.out.println("**********************************************");
   	 System.out.println("*************\t请根据提示操作\t***************");
   	 System.out.println("*************\t请输入用户名\t*****************");
   	 String uname = input.nextLine();
   	 System.out.println("*************\t请输入新的密码\t*******************");
   	 String upass = input.nextLine();
   	 System.out.println("**********************************************");
   	 return new User(uname,upass);
		}
}

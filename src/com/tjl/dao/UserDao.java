package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao
{

/**验证登录的方法
 * @param user需要登录的用户 uname账号 upass密码
 * @return -1表示登录失败 1表示管理员登录成功 2表示学生登录成功
 */
int login(User user); 

/**用来添加学生信息的方法
 * @param user要添加的对象 包含账号和密码
 * @return 如果添加成功返回true,否则返回false
 */
boolean insert(User user);

/**用来删除学生信息的方法
 * @param user要删除的对象 包含账号和密码
 * @return 如果删除成功返回true,否则返回false
 */
boolean delete(String uname);

/**用来修改学生信息的方法
 * @param user修改的信息 包括原账号uname,新密码upass
 * @return 如果修改成功返回true,否则返回false
 */
boolean update(User user);

/**用来查询学生信息的方法
 * @param user学生账号
 * @return查询到的学生信息 或者null, null表示查询失败
 */
User select(String uname);
} 
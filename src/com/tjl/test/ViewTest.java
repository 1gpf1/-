package com.tjl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest
{
@Test
public void indexViewTest() throws Exception
{
	User user = View.indexView();
	System.out.println(user);
}
@Test
public void ManagerMenuViewTest()throws Exception
{
	int item = View.ManagerMenuView();
	System.out.println(item);
}
}

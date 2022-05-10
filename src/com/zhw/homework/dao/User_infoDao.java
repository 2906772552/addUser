package com.zhw.homework.dao;

import com.zhw.homework.User_info.User_info;

import java.util.ArrayList;

public interface User_infoDao {

	 int addUser(User_info user_info);

	 ArrayList<User_info> User_infoList();

	 int deleteUser(Integer user_id);

	 ArrayList<User_info> SelectUser(String select);

	 User_info UserInfoById(Integer user_id);

	 int updateUser(Integer user_id,String user_nickname,String user_birthday,String user_city);

	 ArrayList<User_info> User_infoPaging(int curr,int size);

}

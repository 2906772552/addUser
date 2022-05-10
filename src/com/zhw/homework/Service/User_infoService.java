package com.zhw.homework.Service;

import com.zhw.homework.User_info.User_info;

import java.util.ArrayList;
import java.util.Map;

public interface User_infoService {
    String addUserInfo(User_info user_info);
    String deleteUser(String user_id);
}

package com.zhw.homework.Service;

import com.zhw.homework.User_info.User_info;
import com.zhw.homework.dao.User_infoDao;
import com.zhw.homework.dao.User_infoDaoImpl;
import org.apache.catalina.connector.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User_infoServiceImpl implements User_infoService{

    User_infoDao user_infoDao=new User_infoDaoImpl();

    @Override
    public String addUserInfo(User_info user_info) {
        System.out.println(user_info.getUser_account());
        if(user_info.getUser_account().equals("")){
            return "账号未填写！";
        }else if(user_info.getUser_nickname().equals("")){
            return "用户昵称未填写";
        }else if(user_info.getUser_birthday().equals("")){
            return "用户生日没有填写";
        }else if(user_info.getUser_city().equals("")){
            return "用户国家未填写";
        }else if(user_info.getUser_password().equals("")){
            return "密码未填写";
        }else if(user_info.getUser_sex().equals("")){
            return "性别未填写";
        }else {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
            try {
                Date parse = simpleDateFormat.parse(user_info.getUser_birthday());
                System.out.println(parse);
                SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("YYYY年MM月dd日");
                String format = simpleDateFormat2.format(parse);
                System.out.println(format);
                user_info.setUser_birthday(format);
            } catch (ParseException e) {
                e.printStackTrace();
                return "日期转换异常";
            }

            int i = user_infoDao.addUser(user_info);

            if(i>0){
                return "注册成功！！";
            }else {
                return "注册失败！！服务器异常请联系管理员";
            }

        }
    }

    @Override
    public String deleteUser(String user_id) {
        if(user_id!=null){
            int user_id2 = Integer.parseInt(user_id);
            System.out.println(user_id2);
            int i = user_infoDao.deleteUser(user_id2);
            if(i>0){
                return "删除成功";
            }
        }
        return "删除失败";
    }
}

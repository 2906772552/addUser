package com.zhw.homework.Servlet;

import com.zhw.homework.Service.User_infoService;
import com.zhw.homework.Service.User_infoServiceImpl;
import com.zhw.homework.User_info.User_info;
import com.zhw.homework.dao.User_infoDao;
import com.zhw.homework.dao.User_infoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class User_infoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String user_nickname= req.getParameter("user_nickname");
        String user_birthday= req.getParameter("user_birthday");
        String user_account= req.getParameter("user_account");
        String user_password= req.getParameter("user_password");
        String user_phone= req.getParameter("user_phone");
        String user_city= req.getParameter("city");
        String user_sex= req.getParameter("user_sex");

        System.out.println("账号"+user_account+"\n"+"生日"+user_birthday+"\n密码"+user_password+"\n电话"+user_phone+"\n性别"+user_sex+"\n国家"+user_city+"昵称"+user_nickname);

        User_info user_info=new User_info(user_nickname,user_birthday,user_account,user_password,user_phone,user_city,user_sex);

        User_infoService user_infoService= new User_infoServiceImpl();
        String s = user_infoService.addUserInfo(user_info);


           req.setAttribute("msg",s);
           req.getRequestDispatcher("/ZhuCeSuccess.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}

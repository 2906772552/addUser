package com.zhw.homework.Servlet;

import com.zhw.homework.User_info.User_info;
import com.zhw.homework.dao.User_infoDao;
import com.zhw.homework.dao.User_infoDaoImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SelectUserById")
public class SelectUserById extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");

        int user_id2=Integer.parseInt(user_id);
        User_infoDao user_infoDao =new User_infoDaoImpl();
        User_info user_info = user_infoDao.UserInfoById(user_id2);

        System.out.println(user_id);
        System.out.println(user_info);
        JSONObject jsonObject=JSONObject.fromObject(user_info);
        response.setCharacterEncoding("utf-8");

        PrintWriter pw=response.getWriter();

        pw.print(jsonObject);

    }
}


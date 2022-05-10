package com.zhw.homework.Servlet;

import com.zhw.homework.dao.User_infoDao;
import com.zhw.homework.dao.User_infoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class updateUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int user_id = Integer.parseInt(req.getParameter("user_id"));
        String user_nickname=req.getParameter("user_nickname");
        String user_birthday = req.getParameter("user_birthday");
        String user_city = req.getParameter("user_city");

        User_infoDao user_infoDao=new User_infoDaoImpl();
        user_infoDao.updateUser(user_id, user_nickname, user_birthday, user_city);

        req.setAttribute("list",user_infoDao.User_infoList());
        req.getRequestDispatcher("/User_infoList.jsp").forward(req,resp);
    }
}

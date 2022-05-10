package com.zhw.homework.Servlet;

import com.zhw.homework.User_info.User_info;
import com.zhw.homework.dao.User_infoDao;
import com.zhw.homework.dao.User_infoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectUser")
public class selectUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String select = req.getParameter("select");
        User_infoDao user_infoDao=new User_infoDaoImpl();
        System.out.println(select);
        ArrayList<User_info> user_infos = user_infoDao.SelectUser(select);
        System.out.println(user_infos);

        if(user_infos.size()==0){
            req.setAttribute("msg2","暂无搜索结果");
        }
        req.setAttribute("list",user_infos);
        req.getRequestDispatcher("/User_infoList.jsp").forward(req,resp);

    }
}

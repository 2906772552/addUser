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

@WebServlet("/Paging")
public class Paging extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String curr1 = req.getParameter("curr");
        String size1 = req.getParameter("size");

        int curr = Integer.parseInt(curr1);
        int size = Integer.parseInt(size1);
        req.setAttribute("curr",curr);
        curr=(curr-1)*size;

        User_infoDao user_infoDao=new User_infoDaoImpl();
        ArrayList<User_info> user_infos = user_infoDao.User_infoPaging(curr, size);

        req.setAttribute("list",user_infos);
        req.getRequestDispatcher("/User_infoList.jsp").forward(req,resp);

    }
}

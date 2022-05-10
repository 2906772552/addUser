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
import java.util.ArrayList;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet{

    User_infoService service=new User_infoServiceImpl();
    User_infoDao user_infoDao=new User_infoDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        String s = service.deleteUser(user_id);
        ArrayList<User_info> user_infos = user_infoDao.User_infoList();
        req.setAttribute("msg",s);
        req.setAttribute("list",user_infos);

       req.getRequestDispatcher("/User_infoList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

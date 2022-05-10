package com.zhw.homework.Servlet;

import com.zhw.homework.User_info.User_info;
import com.zhw.homework.dao.User_infoDao;
import com.zhw.homework.dao.User_infoDaoImpl;
import com.zhw.homework.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/login")
public class login  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String account=req.getParameter("useraccount");
        String password=req.getParameter("userpassword");
        ArrayList<User_info> list= new ArrayList();

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;


        try {
            connection= DBUtils.getConnection();
            statement=connection.createStatement();
            String sql="SELECT * FROM user_info";
            resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
              User_info user=new User_info();
                String user_account=resultSet.getString("user_account");
                String user_password=resultSet.getString("user_password");
              user.setUser_account(user_account);
              user.setUser_password(user_password);

              list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        User_infoDao user_infoDao=new User_infoDaoImpl();
        for(User_info user:list){
            if(account.equals(user.getUser_account()) && password.equals(user.getUser_password())){
                        req.setAttribute("list",user_infoDao.User_infoList());
                        req.getRequestDispatcher("/User_infoList.jsp").forward(req,resp);
                        break;
        }else{
                System.out.println("登录失败");
                req.getSession().setAttribute("msg","账号或者密码有误，请返回重写登录");
                req.getRequestDispatcher("/login_fail.jsp").forward(req,resp);
        }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doGet(req,resp);
    }
}

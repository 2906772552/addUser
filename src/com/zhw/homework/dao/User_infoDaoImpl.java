package com.zhw.homework.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zhw.homework.User_info.User_info;
import com.zhw.homework.utils.DBUtils;


public class User_infoDaoImpl implements User_infoDao {
    Connection conn =  null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    @Override
    public int addUser(User_info user_info) {
            conn = DBUtils.getConnection();
        //准备sql
        String sql = "INSERT INTO user_info(user_account,user_password,user_brithday,user_city,user_sex,user_nickname,user_phone) VALUES(?,?,?,?,?,?,?)";
        //创建预编译对象
        try {
            ps = conn.prepareStatement(sql);
            //设置占位符的值
            ps.setObject(1, user_info.getUser_account());
            ps.setObject(2, user_info.getUser_password());
            ps.setObject(3, user_info.getUser_birthday());
            ps.setObject(4, user_info.getUser_city());
            ps.setObject(5, user_info.getUser_sex());
            ps.setObject(6, user_info.getUser_nickname());
            ps.setObject(7, user_info.getUser_phone());

            //执行sql
            int rows =	ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public ArrayList<User_info> User_infoList() {
        String sql = "SELECT * FROM user_info";
        conn = DBUtils.getConnection();
        ArrayList<User_info> arr=new ArrayList<>();
        try {
            ps =conn.prepareStatement(sql);
            rs=ps.executeQuery();

            while (rs.next()){
                User_info user_info=new User_info();
                user_info.setUser_birthday(rs.getString("user_brithday"));
                user_info.setUser_city(rs.getString("user_city"));
                user_info.setUser_nickname(rs.getString("user_nickname"));
                user_info.setUser_id(rs.getInt("user_id"));

                arr.add(user_info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public int deleteUser(Integer user_id) {
        conn = DBUtils.getConnection();
        String sql = "DELETE  FROM user_info where user_id = ?";

        try {
            ps =conn.prepareStatement(sql);
            ps.setObject(1,user_id);

            int rows =	ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<User_info> SelectUser(String select) {
        String sql = "SELECT * FROM user_info where user_nickname LIKE ? or user_city like ? OR user_brithday LIKE ?";
        conn = DBUtils.getConnection();
        ArrayList<User_info> arr=new ArrayList<>();
        try {
            ps =conn.prepareStatement(sql);
            ps.setObject(1,"%"+select+"%");
            ps.setObject(2,"%"+select+"%");
            ps.setObject(3,"%"+select+"%");

            rs=ps.executeQuery();

            while (rs.next()){
                User_info user_info=new User_info();
                user_info.setUser_birthday(rs.getString("user_brithday"));
                user_info.setUser_city(rs.getString("user_city"));
                user_info.setUser_nickname(rs.getString("user_nickname"));
                user_info.setUser_id(rs.getInt("user_id"));
                arr.add(user_info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public User_info UserInfoById(Integer user_id) {
        conn = DBUtils.getConnection();
        String sql = "SELECT  * FROM user_info where user_id = ?";

        try {
            ps =conn.prepareStatement(sql);
            ps.setObject(1,user_id);
            rs=ps.executeQuery();

            User_info user_info=new User_info();
            while (rs.next()){
                String user_birthday = rs.getString("user_brithday");
                String user_city = rs.getString("user_city");
                String user_nickname = rs.getString("user_nickname");
                user_info.setUser_nickname(user_nickname);
                user_info.setUser_city(user_city);
                user_info.setUser_id(user_id);
                user_info.setUser_birthday(user_birthday);
            }
            return user_info;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(Integer user_id, String user_nickname, String user_birthday, String user_city) {
        conn = DBUtils.getConnection();
        String sql = "UPDATE user_info SET user_nickname= ?,user_city= ?,user_brithday = ? WHERE user_id= ?;";
        try {
            ps =conn.prepareStatement(sql);
            ps.setObject(1,user_nickname);
            ps.setObject(2,user_city);
            ps.setObject(3,user_birthday);
            ps.setObject(4,user_id);

            int i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public ArrayList<User_info> User_infoPaging(int curr, int size) {
        conn = DBUtils.getConnection();
        String sql = "SELECT * FROM user_info LIMIT ?,?";
        ArrayList<User_info> user_infos=new ArrayList<>();
        try {
            ps =conn.prepareStatement(sql);
            ps.setObject(1,curr);
            ps.setObject(2,size);


            rs=ps.executeQuery();
            while (rs.next()){
                User_info user_info=new User_info();
                String user_birthday = rs.getString("user_brithday");
                String user_city = rs.getString("user_city");
                String user_nickname = rs.getString("user_nickname");
                int user_id = rs.getInt("user_id");

                user_info.setUser_nickname(user_nickname);
                user_info.setUser_city(user_city);
                user_info.setUser_id(user_id);
                user_info.setUser_birthday(user_birthday);

                user_infos.add(user_info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user_infos;
    }


}

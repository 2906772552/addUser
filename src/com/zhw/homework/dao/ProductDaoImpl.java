package com.zhw.homework.dao;

import com.zhw.homework.User_info.Product_info;
import com.zhw.homework.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDaoImpl implements ProductDao {
    Connection conn =  null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public int addProduct(Product_info product_info) {
        conn = DBUtils.getConnection();
        //准备sql
        String sql = "INSERT INTO product(productName,productPrice,productNumber,productImgUrl) VALUES(?,?,?,?)";
        //创建预编译对象
        try {
            ps = conn.prepareStatement(sql);
            //设置占位符的值
            ps.setObject(1,product_info.getProductName());
            ps.setObject(2,product_info.getProductPrice());
            ps.setObject(3,product_info.getProductNumber());
            ps.setObject(4,product_info.getProductImgUrl());

            int i = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }
}

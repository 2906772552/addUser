package com.zhw.homework.Servlet;

import com.zhw.homework.User_info.Product_info;
import com.zhw.homework.dao.ProductDao;
import com.zhw.homework.dao.ProductDaoImpl;
import com.zhw.homework.utils.PicStringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");

        //创建文件上传的工厂类
        FileItemFactory fileItemFactory=new DiskFileItemFactory();

        //由文件上传工厂类船舰文件上传对象
        ServletFileUpload fileUpload=new ServletFileUpload(fileItemFactory);

        //创建实例对象
        Product_info product_info=new Product_info();

        //持久化到数据库
        ProductDao productDao=new ProductDaoImpl();

        //解析文件的上传
        try {
            List<FileItem> fileItemList = fileUpload.parseRequest(req);

            if(fileItemList != null && fileItemList.size()!=0){
                for(FileItem fileItem:fileItemList){
                    if(fileItem.isFormField()){

                        //判断是否为产品名称
                        if("productName".equals(fileItem.getFieldName())){
                            String productName = fileItem.getString("utf-8");
                            //System.out.println("商品名称为:"+productName);
                            product_info.setProductName(productName);

                        //判断是否为产品价格
                        }else if("productPrice".equals(fileItem.getFieldName())){
                            String productPrice= fileItem.getString("utf-8");
                            double price=Double.parseDouble(productPrice);
                            product_info.setProductPrice(price);
                         //System.out.println("商品的价格为："+productPrice);

                        //判断是否为产品数量
                        }else if("productNumber".equals(fileItem.getFieldName())){
                           String productNumber =fileItem.getString("utf-8");
                            int number = Integer.parseInt(productNumber);
                            product_info.setProductNumber(number);

                        }
                    }else {
                        //解析文件上传
                        String fileName=fileItem.getName();
                        System.out.println("文件名为:"+fileName);
                        //文件重命名
                      String newPicName=  PicStringUtils.getReplaceName(fileName);

                      File file=new File("C:\\Users\\悦耳\\Pictures\\Saved Pictures"+newPicName);
                      fileItem.write(file);

                      product_info.setProductImgUrl(newPicName);
                        System.out.println("图片路径为:"+newPicName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(productDao.addProduct(product_info)>0){
            req.setAttribute("msg","添加成功");
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","添加失败");
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }
    }
}

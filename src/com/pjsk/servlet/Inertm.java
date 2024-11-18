package com.pjsk.servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Session;
import com.pjsk.entity.User;
import com.pjsk.service.Userdao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name="Inertm",urlPatterns="/Inertm")

public class Inertm extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        resp.setContentType("application/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name=null;
        // 验证请求是否满足要求（post 请求 / enctype 是否以multipart打头
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        // 如果不满足要求就立即结束对该请求的处理
        if (!isMultipart) {
            return;
        }
        try {
            // FileItem 是表单中的每一个元素的封装
            // 创建一个 FileItem 的工厂类
            FileItemFactory factory = new DiskFileItemFactory();
            // 创建一个文件上传处理器（装饰设计模式）
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求
            List<FileItem> items = upload.parseRequest(req);
            upload.setFileSizeMax(1024 * 1024 * 10);
            System.out.println(items);

            for (FileItem item : items) {


                // 判断文件类型
                if (item.isFormField()) {
                    // 文本类型
                    String filename = item.getFieldName();
                    if (filename.equals("user")) {
                        name = item.getString("UTF-8");
                        System.out.println(name);
                    }
                } else {
                    // 文件类型

                    // 获取文件后缀名
                    String imgtype = item.getName().substring(item.getName().lastIndexOf("."));
                    // 给文件重新命名防止重复
                    String imgName = UUID.randomUUID() + imgtype;
                    System.out.println();
                    String path="C:\\Users\\MSI-NB\\Desktop\\PJSKPlayerCommunity\\out\\artifacts\\PJSKPlayerCommunity_war_exploded\\image\\photo\\upload";
                    // 将上传的文件保存到服务器
                    item.write(new File(path, imgName));

                    // 把服务器中的路径添加到数据库中
                    String sqlPath=null;
                    sqlPath = "upload/" + imgName;
                    System.out.println("访问路径：" + sqlPath);
                    // 将路径保存到数据库
                    User u=new User();
                    u.setUsername(name);
                    u.setProfile(sqlPath);
                    Userdao dao=new Userdao();
                    boolean flag=dao.addUser(u);
                    if(flag){
                        resp.getWriter().write("上传成功");
                        resp.sendRedirect("jump_profile.jsp");

                    }else{

                        resp.setHeader("refresh","3;upload.jsp");

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

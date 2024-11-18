package com.pjsk.servlet.Good;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.pjsk.service.GoodService;
import com.pjsk.service.impl.GoodServiceImpl;

import javax.lang.model.element.VariableElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/good_add")
public class GoodAddServlet extends HttpServlet {

    private GoodService goodService = new GoodServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //准备文件上传的目录
        //获取绝对路径
        String serverFilePath = request.getServletContext().getRealPath("image/good_photo");

        File file = new File(serverFilePath);
        if (!file.exists()) {
            file.mkdir();
        }

        int userid = Integer.parseInt(request.getParameter("userid"));

        try {
            //步骤1---创建上传组件
            SmartUpload smartUpload = new SmartUpload("utf-8");

            //步骤2---初始化上传组件
            smartUpload.initialize(getServletConfig(), request, response);

            //限定文件大小
            smartUpload.setMaxFileSize(5*1024*1024);

            //限定文件类型
            smartUpload.setAllowedFilesList("jpg,jpeg,png");

            //步骤3---上传文件到服务器的临时内存中
            smartUpload.upload();

            //步骤4---提取上传的第一个文件
            SmartFile smartFile = smartUpload.getFiles().getFile(0);

            //数据检验1---检测是否上传了文件
            if(smartFile.isMissing()){

                out.print("<scrip alert('没有选择文件，无法上传 ');history.back()</scrip>");
                return;
            }

            //获取原始的文件名
            String serverFileName = smartFile.getFileName();

            //获取文件的扩展名
            String extension = smartFile.getFileExt();

            //文件改名
            serverFileName = System.currentTimeMillis() + "." + extension;

            //步骤5---保存文件到服务器上指定的目录
            smartFile.saveAs(serverFilePath + "/" + serverFileName);


            String goodname = smartUpload.getRequest().getParameter("goodname");
            float price = Float.parseFloat(smartUpload.getRequest().getParameter("price"));
            int quantity = Integer.parseInt(smartUpload.getRequest().getParameter("quantity"));

            //商品图片文件名就是改名后的文件名
            String photo = serverFileName;

            // 调用 Service 层方法添加商品
            boolean flag = goodService.addGood(goodname, price, quantity, photo, userid);

            if(flag){
                out.print("<script>alert('商品添加成功');history.go(-2)");
            }else{
                out.print("<script>alert('商品添加失败');history.back()</script>");
            }

            out.println("<script>alert('文件上传成功');history.back()</script>");
        } catch (SmartUploadException e) {
            e.printStackTrace();
            out.println("<script>alert('文件上传失败');history.back()</script>");
        }catch (SecurityException e) {
            e.printStackTrace();
            out.println("<script>alert('只能上传jpg,jpeg,gif格式的文件，文件大小不能超过5M');history.back()</script>");
        }


    }
}

package com.pjsk.servlet.User;


import com.pjsk.service.UserService;
import com.pjsk.service.impl.UserServiceImpl;
import sun.plugin2.message.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update_message")
public class updateMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        Integer userid = Integer.parseInt(request.getParameter("userid"));
        String message=request.getParameter("message");
        HttpSession session = request.getSession();

        if(message.length()>255){
            out.print("<script>alert('留言最长为255个字符');history.back()</script>");
            return;
        }

        UserService userService = new UserServiceImpl();


        boolean flag = userService.ModifyMessage(userid,message);

        if(flag){
            session.setAttribute("targetAddress", "user_modify.jsp");
            out.print("<script>alert('留言修改成功');location='profile.jsp'</script>");
        }else{
            out.print("<script>alert('留言修改失败');history.back()</script>");
        }
    }
}

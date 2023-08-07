package cn.yunhe.servlet;


import cn.yunhe.PageBean;
import cn.yunhe.entity.Account;
import cn.yunhe.service.AccountService;
import cn.yunhe.service.impl.AccountServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    AccountService accountService=new AccountServiceImpl();
    ObjectMapper mapper= new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("findAll")){
            findAll(req,resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        //接收用户想看的代码
        String currentPage = req.getParameter("currentPage");
        //接受用户想看每页显示几条
        String pageSize = req.getParameter("pageSize");
        //调用业务
        PageBean pb=accountService.findPage(currentPage,pageSize);
        //将对象转为json
        String s = mapper.writeValueAsString(pb);
        resp.getWriter().println(s);
    }
}

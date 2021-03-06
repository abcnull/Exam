package com.example.crud.controller;

import com.example.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 石磊 on 2018/8/13.
 */
@WebServlet(name = "LoginByNameServlet",urlPatterns="/loginByName")
public class LoginByNameServlet extends HttpServlet {
    @Autowired
    CustomerService customerService;

    //在servlet中要使@Autowired 生效 需要配置一下内容
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("0");
        if( customerService.loginByName( request.getParameter("firstName") ) != null ){
            response.getWriter().write("login success");
            System.out.println("success");
        }
        else{
            response.getWriter().write("login fail");
            System.out.println("fail");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

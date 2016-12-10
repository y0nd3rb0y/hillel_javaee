package com.controller;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;


    @Override
    public void init() throws ServletException{
        AutowireCapableBeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(getServletContext())
                .getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

            response.getWriter().println("<html>"
                    + "<head><title>Servlet Authentication</title></head>"
                    + "<body>"
                    + "<form method=\"post\">"
                    + "<input type=\"text\" name=\"username\" size=\"25\">"
                    + "<input type=\"password\" name=\"password\" size=\"25\">"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Submit\">"
                    + "</form>"
                    + "</body></html>");

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter responseWriter = response.getWriter();
        responseWriter.println("<html><body>");
        if (username != null
                && username.length() > 0
                && password != null
                && password.length() > 0
                && userService.isUserAuthenticated(username, password)) {
            responseWriter.println("<h2>Hello, " + username + "!</h2>");
        } else {
                responseWriter.println("<h2>Authentication failed!</h2>");
            }
        responseWriter.println("</body></html");

    }
}

package com.lzwing.servletcomponent;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response
              .getOutputStream().print("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
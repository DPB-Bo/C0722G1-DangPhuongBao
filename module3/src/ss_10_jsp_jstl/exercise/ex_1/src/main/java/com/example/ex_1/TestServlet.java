package com.example.ex_1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("NARUTO","15/06/1999","HIHIHI", "img/naruto_1.png"));
        customerList.add(new Customer("GIN","15/06/1999","HAHAHA", "img/gin_1.jpg"));
        customerList.add(new Customer("ICHIGO","15/06/1999","HEHEHEH", "img/bleach_1.png"));
        customerList.add(new Customer("GOKU","15/06/1999","Làng Cần", "img/goku_1.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("displayCustomer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

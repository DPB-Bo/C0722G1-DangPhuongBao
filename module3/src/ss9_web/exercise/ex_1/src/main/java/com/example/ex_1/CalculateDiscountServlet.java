package com.example.ex_1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CalculateDiscountServlet", value = "/CalculateDiscountServlet")
public class CalculateDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float list_pr = Float.parseFloat(request.getParameter("list_pr"));
        float dis_per = Float.parseFloat(request.getParameter("dis_per"));
        String pro_de = request.getParameter("pro_de");

        float dis_amount = (float) (list_pr*dis_per*0.01);
        float dis_pr = list_pr-dis_amount;

        request.setAttribute("dis_amount", dis_amount);
        request.setAttribute("dis_pr", dis_pr);
        request.setAttribute("pro_de", pro_de);
        request.setAttribute("list_pr", list_pr);
        request.setAttribute("dis_per", dis_per);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

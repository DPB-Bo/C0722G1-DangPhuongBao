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
        float listPr = Float.parseFloat(request.getParameter("listPr"));
        float disPer = Float.parseFloat(request.getParameter("disPer"));
        String proDe = request.getParameter("pro_de");

        float disAmount = (float) (listPr*dis_per*0.01);
        float disPr = listPr-disAmount;

        request.setAttribute("dis_amount", disAmount);
        request.setAttribute("dis_pr", disPr);
        request.setAttribute("pro_de", proDe);
        request.setAttribute("list_pr", listPr);
        request.setAttribute("dis_per", disPer);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

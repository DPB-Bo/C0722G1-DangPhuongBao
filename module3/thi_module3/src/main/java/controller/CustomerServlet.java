package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HopistalServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showCustomer(request, response);
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.getCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/display.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "update":
                updateCustomer(request, response);
                break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
            default:
                showCustomer(request, response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerId = request.getParameter("confirmDelete");
        boolean check = customerService.removeCustomer(customerId);
        String mess = "Xoá không thành công";
        if (check) {
            mess = "Xoá thành công";
        }
        request.setAttribute("mess", mess);
        showCustomer(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerId = request.getParameter("updateCustomerId");
        String sickTypeId = request.getParameter("updateSickTypeId");
        String customerName = request.getParameter("updateCustomerName");
        String sickName= request.getParameter("updateSickName");
        String dayIn = request.getParameter("updateDayIn");
        String dayOut = request.getParameter("updateDayOut");
        String description = request.getParameter("updateDescription");
        Customer customer = new Customer(sickTypeId,customerId,sickName,customerName,dayIn,dayOut,description);
        boolean check = customerService.updateCustomer(customerId,customer);
        String mess = "Chỉnh sửa không thành công";
        if (check) {
            mess = "Chỉnh sửa thành công";
        }
        request.setAttribute("mess", mess);
        showCustomer(request,response);
    }
}

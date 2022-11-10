package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addCustomer(request, response);
                break;
            default:
                showCustomers(request, response);
                break;
        }
    }

    private void showCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.getCustomer();
        request.setAttribute("customers", customers);
        try {
            request.getRequestDispatcher("view/customer/display.jsp").forward(request, response);
        }catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addCustomer(request, response);
                break;
            default:
                showCustomers(request, response);
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("addCustomerName");
        String birthday = request.getParameter("addCustomerBirth");
        boolean gender = Boolean.parseBoolean(request.getParameter("addCustomerGender"));
        String idCard = request.getParameter("addCustomerIdCard");
        String phoneNumber = request.getParameter("addCustomerPhone");
        String email = request.getParameter("addCustomerEmail");
        String address = request.getParameter("addCustomerAddress");
        int customerTypeId = Integer.parseInt(request.getParameter("addCustomerRank"));
        Customer customer = new Customer(name, birthday, gender, idCard, phoneNumber, email, address, customerTypeId);
        boolean check = customerService.addCustomer(customer);
        String mess = "Cập nhật không thành công";
        if (check){
            mess = "Cập nhật thành công";
        }
        request.setAttribute("mess",mess);
        showCustomers(request, response);
    }

}

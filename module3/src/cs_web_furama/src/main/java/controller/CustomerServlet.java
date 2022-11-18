package controller;

import model.Customer;
import model.CustomerRank;
import service.ICustomerRankService;
import service.ICustomerService;
import service.impl.CustomerRankService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerRankService customerRankService = new CustomerRankService();
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
        List<CustomerRank> customerRanks = customerRankService.getCustomerRanks();

        request.setAttribute("customers", customers);
        request.setAttribute("customerRanks", customerRanks);
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
        int id;
        switch (action){
            case "add":
                addCustomer(request, response);
                break;
                case "update":
                    id = Integer.parseInt(request.getParameter("updateConfirm"));
                    editCustomer(request, response,id);
                    break;
                    case "delete":
                        id = Integer.parseInt(request.getParameter("deleteConfirm"));
                        deleteCustomer(request, response,id);
                        break;
                        case "search":
                            searchCustomer(request, response);
                            break;
            default:
                showCustomers(request, response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response, int id) {
        boolean check = customerService.removeCustomer(id);
        request.setAttribute("flag",1);
        showCustomers(request, response);
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
        showCustomers(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response,int customerId){
        String name = request.getParameter("updateCustomerName");
        String birthday = request.getParameter("updateCustomerBirth");
        boolean gender = Boolean.parseBoolean(request.getParameter("updateCustomerGender"));
        String idCard = request.getParameter("updateCustomerIdCard");
        String phoneNumber = request.getParameter("updateCustomerPhone");
        String email = request.getParameter("updateCustomerEmail");
        String address = request.getParameter("updateCustomerAddress");
        int customerTypeId = Integer.parseInt(request.getParameter("updateCustomerRank"));
        Customer customer = new Customer(name, birthday, gender, idCard, phoneNumber, email, address, customerTypeId);
        customerService.editCustomer(customerId,customer);
        showCustomers(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Customer> customerList = customerService.searchByNameAndAddress(name);
        request.setAttribute("customers", customerList);
        request.setAttribute("search", name);
        try {
            request.getRequestDispatcher("view/customer/display.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}

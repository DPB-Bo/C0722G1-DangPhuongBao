package controller;

import model.Product;
import service.ProductService;
import service.impl.IProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String productId = request.getParameter("productId");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteProduct(request, response, productId);
                showProduct(request, response);
                break;
            case "":
                showProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                showProduct(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                showProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                showProduct(request, response);
                break;
            case "add":
                addProduct(request, response);
                showProduct(request, response);
                break;
        }
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.getAvailable();
        request.setAttribute("products", products);
        try {
            request.getRequestDispatcher("view/product/display.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response, String id) {
        productService.delete(Integer.parseInt(id));
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String proId = request.getParameter("productId");
        String proName = request.getParameter("productName");
        Float proPrice = Float.parseFloat(request.getParameter("productPrice"));
        String proDes = request.getParameter("productDes");
        String proProducer = request.getParameter("productProducer");
        Product product = new Product(proId, proName, proPrice, proDes, proProducer, false);
        productService.update(Integer.valueOf(proId), product);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String productId = String.valueOf(productService.getAvailable().get(productService.getAvailable().size() - 1));
        String proName = request.getParameter("addProductName");
        Float proPrice = Float.parseFloat(request.getParameter("addProductPrice"));
        String proDes = request.getParameter("addProductDes");
        String proProducer = request.getParameter("addProductProducer");
        Product product = new Product(productId, proName, proPrice, proDes, proProducer, false);
        productService.create(product);
    }
}

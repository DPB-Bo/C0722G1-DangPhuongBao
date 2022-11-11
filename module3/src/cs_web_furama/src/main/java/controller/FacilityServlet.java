package controller;

import model.Facility;
import model.FacilityType;
import model.RentType;
import service.IFacilityService;
import service.IFacilityTypeService;
import service.IRentTypeService;
import service.impl.FacilityService;
import service.impl.FacilityTypeService;
import service.impl.RentTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();

    private IFacilityTypeService facilityTypeService = new FacilityTypeService();

    private IRentTypeService rentTypeService = new RentTypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addFacility(request, response);
                break;
            default:
                showFacility(request, response);
                break;
        }
    }

    private void addFacility(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFacility(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.getFacility();
        List<FacilityType> facilityTypeList = facilityTypeService.getFacilityType();
        List<RentType> rentTypeList = rentTypeService.getRentType();

        request.setAttribute("facilityList",facilityList);
        request.setAttribute("facilityTypeList",facilityTypeList);
        request.setAttribute("rentTypeList",rentTypeList);

        try {
            request.getRequestDispatcher("view/facility/display.jsp").forward(request,response);
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
        switch (action){
            case "add":
                addFacility(request, response);
                break;
            default:
                showFacility(request, response);
                break;
        }
    }
    
    
}

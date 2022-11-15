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
            default:
                showFacility(request, response);
                break;
        }
    }

    private void addFacility(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("addFacilityName");
        int area = Integer.parseInt(request.getParameter("addFacilityArea"));
        double cost = Double.parseDouble(request.getParameter("addFacilityPrice"));
        int maxUsers = Integer.parseInt(request.getParameter("addFacilityMaxUsers"));
        String standardRoom = request.getParameter("addFacilityRoomStandard");
        String description = request.getParameter("addFacilityOtherDescription");
        Double poolArea = Double.parseDouble(request.getParameter("addFacilityPoolArea"));
        Integer numberFloor = Integer.parseInt(request.getParameter("addFacilityFloors"));
        String facilityFree = request.getParameter("addFacilityFreeServices");
        int rentTypeId = Integer.parseInt(request.getParameter("addFacilityRentalType"));
        int facilityTypeId = Integer.parseInt(request.getParameter("addFacilityType"));
        boolean check = facilityService.addFacility(new Facility(name,area,cost,maxUsers,standardRoom,description,poolArea,numberFloor,facilityFree,rentTypeId,facilityTypeId));
        String mess = "Thêm mới không thành công";
        if (check) {
            mess = "Thêm mới thành công";
        }
        request.setAttribute("mess", mess);
        showFacility(request,response);
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
                case "update":
                    updateFacility(request, response);
                    break;
                    case "delete":
                        deleteFacility(request, response);
                        break;
            default:
                showFacility(request, response);
                break;
        }
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("confirmDelete"));
        boolean check = facilityService.removeFacility(id);
        String mess = "Xoá không thành công";
        if (check) {
            mess = "Xoá thành công";
        }
        request.setAttribute("mess", mess);
        showFacility(request, response);
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("editFacilityName");
        int area = Integer.parseInt(request.getParameter("editFacilityArea"));
        double cost = Double.parseDouble(request.getParameter("editFacilityPrice"));
        int maxUsers = Integer.parseInt(request.getParameter("editFacilityMaxUsers"));
        String standardRoom = request.getParameter("editFacilityRoomStandard");
        String description = request.getParameter("editFacilityOtherDescription");
        Double poolArea = Double.parseDouble(request.getParameter("editFacilityPoolArea"));
        Integer numberFloor = Integer.parseInt(request.getParameter("editFacilityFloors"));
        String facilityFree = request.getParameter("editFacilityFreeServices");
        int rentTypeId = Integer.parseInt(request.getParameter("editFacilityRentalType"));
        int facilityTypeId = Integer.parseInt(request.getParameter("editFacilityType"));
        int id = Integer.parseInt(request.getParameter("confirmUpdate"));
        boolean check = facilityService.editFacility(id,new Facility(name,area,cost,maxUsers,standardRoom,description,poolArea,numberFloor,facilityFree,rentTypeId,facilityTypeId));
        String mess = "Sửa không thành công";
        if (check) {
            mess = "Sửa thành công";
        }
        request.setAttribute("mess", mess);
        showFacility(request,response);
    }


}

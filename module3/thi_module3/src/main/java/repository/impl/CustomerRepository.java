package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private final String GET_CUSTOMER="SELECT * FROM benhnhan JOIN benhan ON benhnhan.benhan_id = benhan.benhan_id WHERE is_delete = 0;";

    private final String UPDATE_CUSTOMER="UPDATE benhnhan SET ngay_nhap_vien = ?, ngay_ra_vien = ?, ly_do = ? WHERE benhnhan_id = ? ;";
    private final String UPDATE_SICK_NAME="UPDATE benhan SET benhan_ten=? WHERE benhan_id = ?;";
    private final String DELETE_CUSTOMER="UPDATE benhnhan SET is_delete = 1 WHERE benhnhan_id = ?;";
    @Override
    public List<Customer> getCustomer() {
        List<Customer>customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String customerId = rs.getString("benhnhan_id");
                String sickTypeId = rs.getString("benhan_id");
                String customerName = rs.getString("benhnhan_ten");
                String sickTypeName = rs.getString("benhan_ten");
                String dayIn = rs.getString("ngay_nhap_vien");
                String dayOut = rs.getString("ngay_ra_vien");
                String description = rs.getString("ly_do");
                Customer customer = new Customer(customerId,sickTypeId,customerName,sickTypeName,dayIn,dayOut,description);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean updateCustomer(String id, Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement psCustomer = connection.prepareStatement(UPDATE_CUSTOMER);
            psCustomer.setDate(1, Date.valueOf(customer.getDayIn()));
            psCustomer.setDate(2, Date.valueOf(customer.getDayOut()));
            psCustomer.setString(3, customer.getDescription());
            psCustomer.setString(4, customer.getCustomerId());
            int checkCustomer = psCustomer.executeUpdate();
////            PreparedStatement psSickType = connection.prepareStatement(UPDATE_SICK_NAME);
////            psSickType.setString(1,customer.getSickTypeName());
////            psSickType.setString(2, customer.getSickTypeId());
//
//
//            int checkSick = psSickType.executeUpdate();
            return checkCustomer>0 ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeCustomer(String id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setString(1, id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

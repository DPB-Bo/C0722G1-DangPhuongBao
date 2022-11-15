package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (name, day_of_birth, gender, id_card, phone_number, email, address, customer_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String SELECT_CUSTOMER_SQL = "SELECT * FROM customer WHERE customer.is_delete = 0;";
    private final String DELETE_USERS_SQL = "UPDATE customer SET is_delete = 1 WHERE id = ?;";
    private final String UPDATE_CUSTOMER_SQL = "UPDATE CUSTOMER SET name = ? ,day_of_birth = ?, gender = ?, id_card = ?, phone_number = ?, email = ?, address = ?, customer_type_id = ? WHERE id = ?;";
    private final String SEARCH_CUSTOMER_BY_NAME = "SELECT * FROM customer WHERE is_delete =0 and (name LIKE ?  );";

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("day_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                boolean isDelete = resultSet.getBoolean("is_delete");
                Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address, customerTypeId,isDelete);
                customerList.add(customer);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerList;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, Date.valueOf(customer.getBirthday()));
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());

            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeCustomer(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editCustomer(int id, Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, Date.valueOf(customer.getBirthday()));
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            preparedStatement.setInt(9,id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> searchByNameAndAddress(String name) {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
//            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameFind = resultSet.getString("name");
                String birthday = resultSet.getString("day_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");

                customerList.add(new Customer(id, nameFind, birthday, gender, idCard, phoneNumber, email, address, customerTypeId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}

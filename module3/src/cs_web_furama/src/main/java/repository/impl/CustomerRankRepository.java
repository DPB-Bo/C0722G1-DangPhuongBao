package repository.impl;

import model.CustomerRank;
import repository.BaseRepository;
import repository.ICustomerRankRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRankRepository implements ICustomerRankRepository {
    private final String SELECT_CUSTOMER_RANK = "SELECT * FROM customer_type";
    @Override
    public List<CustomerRank> getCustomerRanks() {
        List<CustomerRank> customerRanks = new ArrayList<CustomerRank>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_RANK);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                customerRanks.add(new CustomerRank(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerRanks;
    }
}

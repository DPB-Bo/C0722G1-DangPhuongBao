package repository.impl;

import model.RentType;
import repository.BaseRepository;
import repository.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {

    private final String SELECT_RENT_TYPE="SELECT * FROM rent_type;";
    @Override
    public List<RentType> getRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_TYPE);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                rentTypeList.add(new RentType(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rentTypeList;
    }
}

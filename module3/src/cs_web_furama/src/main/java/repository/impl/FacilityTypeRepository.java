package repository.impl;

import model.FacilityType;
import repository.BaseRepository;
import repository.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    private final String SELECT_FACILITY_TYPE= "SELECT * FROM facility_type;";
    @Override
    public List<FacilityType> getFacilityType() {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACILITY_TYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                facilityTypeList.add(new FacilityType(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return facilityTypeList;
    }
}

package repository.impl;

import model.Facility;
import repository.BaseRepository;
import repository.IFacilityRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String INSERT_FACILITY_SQL =
            "INSERT INTO facility (name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors,facility_free,rent_type_id,facility_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?);";
    private static final String SELECT_FACILITY_SQL =
            "SELECT facility.*, rent_type.name AS rent_type_name, facility_type.name AS facility_type_name FROM facility JOIN rent_type ON facility.rent_type_id = rent_type.id JOIN facility_type ON facility.facility_type_id = facility_type.id WHERE facility.is_delete = 0;";

    private static final String UPDATE_FACILITY_SQL=
            "UPDATE facility SET name=?, area=?,cost=?, max_people=?, standard_room=?, description_other_convenience=?, pool_area=?, number_of_floors=?,facility_free=?,rent_type_id=?,facility_type_id=? WHERE id=? ;";
    private static final String DELETE_FACILITY_SQL="UPDATE facility SET is_delete=1 WHERE id=?";
    @Override
    public List<Facility> getFacility() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACILITY_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                Double poolArea = resultSet.getDouble("pool_area");
                Integer numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                String facilityTyeName = resultSet.getString("facility_type_name");
                facilityList.add(new Facility(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,facilityFree,rentTypeId,facilityTypeId,rentTypeName,facilityTyeName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facilityList;
    }

    @Override
    public boolean addFacility(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACILITY_SQL);
            preparedStatement.setString(1, facility.getName());
            preparedStatement.setInt(2,facility.getArea());
            preparedStatement.setDouble(3,facility.getCost());
            preparedStatement.setInt(4,facility.getMaxPeople());
            preparedStatement.setString(5,facility.getStandardRoom());
            preparedStatement.setString(6,facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7,facility.getPoolArea());
            preparedStatement.setInt(8,facility.getNumberOfFloors());
            preparedStatement.setString(9,facility.getFacilityFree());
            preparedStatement.setInt(10,facility.getRentTypeId());
            preparedStatement.setInt(11,facility.getFacilityTypeId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeFacility(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_FACILITY_SQL);
            statement.setInt(1,id);
            return statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editFacility(int id, Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FACILITY_SQL);
            preparedStatement.setString(1, facility.getName());
            preparedStatement.setInt(2,facility.getArea());
            preparedStatement.setDouble(3,facility.getCost());
            preparedStatement.setInt(4,facility.getMaxPeople());
            preparedStatement.setString(5,facility.getStandardRoom());
            preparedStatement.setString(6,facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7,facility.getPoolArea());
            preparedStatement.setInt(8,facility.getNumberOfFloors());
            preparedStatement.setString(9,facility.getFacilityFree());
            preparedStatement.setInt(10,facility.getRentTypeId());
            preparedStatement.setInt(11,facility.getFacilityTypeId());
            preparedStatement.setInt(12,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Facility> searchByName(String name) {
        return null;
    }
}

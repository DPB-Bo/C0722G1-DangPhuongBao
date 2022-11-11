package repository;

import model.CustomerRank;

import java.util.List;

public interface ICustomerRankRepository {
    List<CustomerRank> getCustomerRanks();
}

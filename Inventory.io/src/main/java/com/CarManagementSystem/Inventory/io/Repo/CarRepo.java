package com.CarManagementSystem.Inventory.io.Repo;

import com.CarManagementSystem.Inventory.io.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarRepo extends MongoRepository<Product,String> {
    Product findByCarName(String carName);

    List<Product> findByFuelType(String fuelType);

    Product findByCarModel(String carModel);

    List<Product> findByYear(Date year);
    List<Product> findByYearBetween(Date startDate, Date endDate);
}

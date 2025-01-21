package com.CarManagementSystem.Inventory.io.Service;

import com.CarManagementSystem.Inventory.io.Model.Product;
import com.CarManagementSystem.Inventory.io.Repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class CarService {


    @Autowired
    private CarRepo repo;

    public String saveCar(Product product) {
        repo.save(product);
        return "Car is added to inventory successfully";
    }

    public List<Product> saveCars(List<Product> products) {
        repo.saveAll(products);
        return products;
    }

    public List<Product> getCars() {
        return repo.findAll();
    }

    public Product getCarByName(String carName) {
        return repo.findByCarName(carName);
    }



    public List<Product> getCarsByFuelType(String fuelType) {
        return repo.findByFuelType(fuelType);
    }

    public Product getCarsByModel(String carModel) {
        return repo.findByCarModel(carModel);
    }

    public List<Product> getCarsByYear(Date startDate, Date endDate) {
        return repo.findByYearBetween(startDate, endDate);
    }


    public Product updateCarByName(String carName, Product updatedCar) {
        Product car = repo.findByCarName(carName);
        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }
        car.setCarName(updatedCar.getCarName());
        car.setCarModel(updatedCar.getCarModel());
        car.setCarColor(updatedCar.getCarColor());
        car.setFuelType(updatedCar.getFuelType());
        car.setPrice(updatedCar.getPrice());
        car.setYear(updatedCar.getYear());
        return repo.save(car);

    }

    public void deleteCarByName(String carName) {
        Product car = repo.findByCarName(carName);
        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }
        repo.delete(car);
    }

    public void deleteCarByModel(String carModel) {
        Product car = repo.findByCarModel(carModel);
        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }
        repo.delete(car);
    }
}

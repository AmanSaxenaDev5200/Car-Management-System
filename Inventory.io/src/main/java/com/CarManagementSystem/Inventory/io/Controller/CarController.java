package com.CarManagementSystem.Inventory.io.Controller;

import com.CarManagementSystem.Inventory.io.Model.Product;
import com.CarManagementSystem.Inventory.io.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    // sample testing method
    @GetMapping("/test")
    public String test(){
        String s = new String("testing the car controller");
        return s;
    }

    // Add the single car in the database
    @PostMapping("/addCar")
    public String addCar(@RequestBody Product product){
        return service.saveCar(product);
    }

    // Add more than one car in the database
    @PostMapping("/addCars")
    public ResponseEntity<List<Product>> addCars(@RequestBody List<Product> products){
        return new ResponseEntity<>(service.saveCars(products),HttpStatus.CREATED);
    }

    // method to get all the cars that are stored in inventory(database)
    @GetMapping("/getCars")
    public ResponseEntity<List<Product>> getCars(){
        return new ResponseEntity<>(service.getCars(),HttpStatus.OK);
    }

    // method to get the car by name this will work for unique car names only // Acura etc, if car have more than one car by carName this will not work
    @GetMapping("/getCar/{carName}")
    public ResponseEntity<Product> getCarByModel(@PathVariable String carName){
        Product  car = service.getCarByName(carName);
        if(car == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car,HttpStatus.OK);
    }


    // method to find all the cars by fuel type
    @GetMapping("/getCars/fuel/{fuelType}")
    public ResponseEntity<?> getCarsByFuelType(@PathVariable String fuelType) {
        List<String> validFuelTypes = new ArrayList<>(Arrays.asList("Petrol", "Diesel", "Hybrid"));
        if(!validFuelTypes.contains(fuelType)){
            return new ResponseEntity<>("Please select the valid fuel types from Petrol, Diesel or Hybrid",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.getCarsByFuelType(fuelType), HttpStatus.OK);
    }

    // method to find the car by model
    @GetMapping("/getCars/model/{carModel}")
    public ResponseEntity<?> getCarsByModel(@PathVariable String carModel){
        Product car = service.getCarsByModel(carModel);
        if(carModel.isEmpty()){
            return new ResponseEntity<>("Enter the CarModel ",HttpStatus.BAD_REQUEST);
        }

        if (car == null) {
            return new ResponseEntity<>("No car found with the given names",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    // method to find all the cars by year
    // look at the end
    @GetMapping("/getCars/year/{year}")
    public List<Product> getCarsByYear(@PathVariable String year) {
        try {
            // Convert the year string to a Date (using only year)
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            Date date = formatter.parse(year);

            // Adjust the date to start from January 1st and end at December 31st
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);  // Set to January
            calendar.set(Calendar.DAY_OF_MONTH, 1);  // Set to the first day of the month
            Date startDate = calendar.getTime();

            // Set the end date (December 31st of the same year)
            calendar.set(Calendar.MONTH, Calendar.DECEMBER); // Set to December
            calendar.set(Calendar.DAY_OF_MONTH, 31);  // Set to the last day of the month
            Date endDate = calendar.getTime();

            return service.getCarsByYear(startDate, endDate);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format", e);
        }
    }


    // Method to update car details using carName
    @PutMapping("/updateCar/{carName}")
    public ResponseEntity<?> updateCarByName(@PathVariable String carName, @RequestBody Product updatedCar) {
        if(updatedCar == null){
            return new ResponseEntity<>("Updated Car details are missing",HttpStatus.BAD_REQUEST);
        }
        Product car = service.updateCarByName(carName,updatedCar);
        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    // Method to delete the car from the inventory(database)
    @DeleteMapping("deleteCar/{carName}")
    public ResponseEntity<String> deleteCar(@PathVariable String carName){
        service.deleteCarByName(carName);
        return new ResponseEntity<>("Car is deleted from inventory",HttpStatus.OK);

    }

    // Method to delete the car by carModel
    @DeleteMapping("deleteCarM/{carModel}")
    public ResponseEntity<String> deleteCarByModel(@PathVariable String carModel){
        service.deleteCarByModel(carModel);
        return new ResponseEntity<>("Car is deleted from inventory",HttpStatus.OK);
    }





}

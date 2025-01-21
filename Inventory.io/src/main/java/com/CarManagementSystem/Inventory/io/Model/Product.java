package com.CarManagementSystem.Inventory.io.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    private String id;

    @Getter
    @Setter
    @JsonProperty("CarName")
    private String carName;
    @JsonProperty("CarModel")
    private String carModel;
    @JsonProperty("CarColor")
    private String carColor;
    @JsonProperty("FuelType")  // for mapping with mongodb atlas this is used
    private String fuelType;  // internally this one is used
    @JsonProperty("Price")
    private double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("Year")
    private Date year;

    // Getter and Setter for carName
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    // Getter and Setter for carModel
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    // Getter and Setter for carColor
    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    // Getter and Setter for fuelType
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for year
    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

}

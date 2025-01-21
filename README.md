# Car-Management-System
The Car Management System is a Spring Boot application designed to manage car inventory using a MongoDB Atlas cloud database. The application provides RESTful APIs to perform CRUD operations on car data, including functionalities like adding cars, fetching car details, updating car information, and deleting cars from the inventory.

# Features
Core Functionalities

i) Add a Single Car: Add a new car to the inventory.
ii) Add Multiple Cars: Add a list of cars to the inventory.
iii) Fetch All Cars: Retrieve all cars stored in the database.
iv) Fetch Car by Name: Retrieve a car by its unique name.
v) Fetch Cars by Fuel Type: Retrieve cars filtered by fuel type (Petrol, Diesel, Hybrid).
vi) Fetch Cars by Model: Retrieve a car by its model.
vii) Fetch Cars by Year: Retrieve cars manufactured in a specific year or within a range of years.
viii) Update Car Information: Update details of a car using its name.
ix) Delete Car by Name: Remove a car from the inventory using its name.
x) Delete Car by Model: Remove a car from the inventory using its model.

# Technologies Used

i) Spring Boot: Framework for building the RESTful APIs.
ii) MongoDB Atlas: Cloud database for storing car information.
iii) Java: Programming language for backend logic.
iv) Maven: Dependency management and build tool.
v) Lombok: Simplifies boilerplate code like getters and setters.

# Project Structure

com.CarManagementSystem.Inventory.io
├── Controller
│   └── CarController.java  // REST API endpoints
├── Model
│   └── Product.java        // Data model for cars
├── Repo
│   └── CarRepo.java        // MongoDB repository interface
├── Service
│   └── CarService.java     // Business logic for car operations
├── Application.java        // Main entry point of the application

# MongoDB Data Format

{
  "_id": "676854ebc318c319987a1808",
  "carName": "Volvo",
  "carModel": "XC90",
  "carColor": "Silver",
  "fuelType": "Hybrid",
  "price": 65000,
  "year": "2019-05-15T00:00:00.000Z",
  "_class": "com.CarManagementSystem.Inventory.io.Model.Product"
}




# API Endpoints
#Test Endpoint

i) GET /car/test
Response: "testing the car controller"

Car Management
i) Add Single Car

POST /car/addCar
Request Body: JSON object of car details.
Response: "Car is added to inventory successfully"

ii) Add Multiple Cars

POST /car/addCars
Request Body: JSON array of car details.
Response: List of added cars.

iii) Fetch All Cars

GET /car/getCars
Response: List of all cars.

iv) Fetch Car by Name

GET /car/getCar/{carName}
Response: Car details or 404 Not Found.

v) Fetch Cars by Fuel Type

GET /car/getCars/fuel/{fuelType}
Response: List of cars with the specified fuel type or 400 Bad Request.

vi )Fetch Cars by Model

GET /car/getCars/model/{carModel}
Response: Car details or 404 Not Found.

vii) Fetch Cars by Year

GET /car/getCars/year/{year}
Response: List of cars manufactured in the specified year.

viii) Update Car by Name

PUT /car/updateCar/{carName}
Request Body: JSON object of updated car details.
Response: Updated car details or 404 Not Found.

ix) Delete Car by Name

DELETE /car/deleteCar/{carName}
Response: "Car is deleted from inventory".

x) Delete Car by Model

DELETE /car/deleteCarM/{carModel}
Response: "Car is deleted from inventory".


# Running the Application

i) Clone the repository:
git clone <repository-url>

ii) Navigate to the project directory:
cd car-management-system

iii) Set up MongoDB Atlas and update the connection string in application.properties:
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<database>

iv) Run the application:
mvn spring-boot:run

v) Access the APIs at http://localhost:8080/car.


# Future Enhancements

i) Add user authentication and authorization.
ii) Implement pagination for large datasets.
iii) Integrate advanced search filters.
iv) Add support for image uploads for cars.

# Contact

For any queries or issues, feel free to reach out:
Name: Aman Saxena
Email: amansaxena5200@gmail.com

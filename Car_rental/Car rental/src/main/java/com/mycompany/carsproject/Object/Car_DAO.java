/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject.Object;

import com.mycompany.carsproject.Login.Connect_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author sonki
 */
public class Car_DAO {
    public void addCar(Car car) {
        if (!isCarIDExists(car.getCarID())) {
            String sql = "INSERT INTO car (CARID, BRAND, MODEL, car_status, LICENSE_PLATE, PRICE) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection connection = Connect_DB.connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, car.getCarID());
                preparedStatement.setString(2, car.getBrand());
                preparedStatement.setString(3, car.getModel());
                preparedStatement.setBoolean(4, car.isCarStatus());
                preparedStatement.setString(5, car.getLicensePlate());
                preparedStatement.setFloat(6, car.getPrice());

                preparedStatement.executeUpdate();
                System.out.println("Car added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("CarID already exists. Cannot add the car.");
        }
    }

    public void updateCar(Car car) {
        if (isCarIDExists(car.getCarID())) {
            String sql = "UPDATE car SET BRAND=?, MODEL=?, car_status=?, LICENSE_PLATE=?, PRICE=? WHERE CARID=?";
            try (Connection connection = Connect_DB.connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, car.getBrand());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.setBoolean(3, car.isCarStatus());
                preparedStatement.setString(4, car.getLicensePlate());
                preparedStatement.setFloat(5, car.getPrice());
                preparedStatement.setString(6, car.getCarID());

                preparedStatement.executeUpdate();
                System.out.println("Car updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("CarID does not exist. Cannot update the car.");
        }
    }

    public void deleteCar(String carID) {
        if (isCarIDExists(carID)) {
            String sql = "DELETE FROM car WHERE CARID=?";
            try (Connection connection = Connect_DB.connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, carID);

                preparedStatement.executeUpdate();
                System.out.println("Car deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("CarID does not exist. Cannot delete the car.");
        }
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM car";
        try (Connection connection = Connect_DB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("CARID"),
                        resultSet.getString("BRAND"),
                        resultSet.getString("MODEL"),
                        resultSet.getBoolean("car_status"),
                        resultSet.getString("LICENSE_PLATE"),
                        resultSet.getFloat("PRICE")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
      public boolean isCarIDExists(String carID) {
        String sql = "SELECT COUNT(*) FROM car WHERE CARID=?";
        try (Connection connection = Connect_DB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, carID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Car> getAllActiveCars() {
    List<Car> activeCars = new ArrayList<>();
    String sql = "SELECT * FROM car WHERE car_status = 1";
    try (Connection connection = Connect_DB.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            Car car = new Car(
                    resultSet.getString("CARID"),
                    resultSet.getString("BRAND"),
                    resultSet.getString("MODEL"),
                    resultSet.getBoolean("car_status"),
                    resultSet.getString("LICENSE_PLATE"),
                    resultSet.getFloat("PRICE")
            );
            activeCars.add(car);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return activeCars;
    }
    public List<Car> hienThiDoanhThu() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT CARID, BRAND, MODEL, LICENSE_PLATE, PRICE, Total_time, total_bill, total_payment FROM car";
        try (Connection connection = Connect_DB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("CARID"),
                        resultSet.getString("BRAND"),
                        resultSet.getString("MODEL"),
                   resultSet.getString("LICENSE_PLATE"),
                       resultSet.getFloat("PRICE"),
                    resultSet.getInt("Total_time"),
                    resultSet.getFloat("total_bill"),
                  resultSet.getFloat("total_payment")
                );
                cars.add(car);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return cars;
    }
  



}

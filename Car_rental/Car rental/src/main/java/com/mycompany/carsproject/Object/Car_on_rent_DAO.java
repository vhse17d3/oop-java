/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject.Object;
import com.mycompany.carsproject.Login.Connect_DB;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Car_on_rent_DAO {
    
    public void addCarOnRent(Car_on_rent carOnRent) {
    String addCarOnRentSQL = "INSERT INTO car_rented (CARID, CUSID, RENTID, RENTDATE, RETURNDATE) VALUES (?, ?, ?, ?, ?)";
    String updateCarStatusSQL = "UPDATE car SET CAR_STATUS = 0 WHERE CARID = ?";

    try (Connection connection = getConnection();
         PreparedStatement addCarOnRentStatement = connection.prepareStatement(addCarOnRentSQL);
         PreparedStatement updateCarStatusStatement = connection.prepareStatement(updateCarStatusSQL)) {

        connection.setAutoCommit(false);

        // Thêm hóa đơn mới
        addCarOnRentStatement.setString(1, carOnRent.getCarID());
        addCarOnRentStatement.setString(2, carOnRent.getCustomerID());
        addCarOnRentStatement.setString(3, carOnRent.getRentID());
        addCarOnRentStatement.setDate(4, carOnRent.getRentDate());
        addCarOnRentStatement.setDate(5, carOnRent.getReturnDate());

        int affectedRows = addCarOnRentStatement.executeUpdate();

        // Cập nhật trạng thái của car nếu thêm hóa đơn thành công
        if (affectedRows > 0) {
            updateCarStatusStatement.setString(1, carOnRent.getCarID());
            updateCarStatusStatement.executeUpdate();
        }

        connection.commit();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void AddToTemp(Car_on_rent carOnRent) {
        String addToTemp = "insert INTO tempNgayTra values ( ?, ?)";
        try (Connection connection = getConnection();
         PreparedStatement addToTempStatement = connection.prepareStatement(addToTemp))
    {
        connection.setAutoCommit(false);
        addToTempStatement.setString(1, carOnRent.getRentID());
        addToTempStatement.setDate(2, carOnRent.getTrueReturnDate());

        int affectedRows = addToTempStatement.executeUpdate();

        System.out.println(affectedRows + " updated.");

        connection.commit();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public void ReturnCarOnRent(Car_on_rent carOnRent) {
    String deleteCarOnRentSQL = "delete from car_rented where CARID = ?";
    String updateCarStatusSQL = "UPDATE car SET CAR_STATUS = 1 WHERE CARID = ?";
    String deleteFromTemp = "delete from tempNgayTra where rentid =?";

    try (Connection connection = getConnection();
         PreparedStatement deleteCarOnRentStatement = connection.prepareStatement(deleteCarOnRentSQL);
         PreparedStatement updateCarStatusStatement = connection.prepareStatement(updateCarStatusSQL);
         PreparedStatement deleteFromTempStatement = connection.prepareStatement(deleteFromTemp)) {
  
        connection.setAutoCommit(false);
        deleteCarOnRentStatement.setString(1, carOnRent.getCarID());
        deleteFromTempStatement.setString(1, carOnRent.getRentID());

        int affectedRows = deleteCarOnRentStatement.executeUpdate();
        int affectedRowsTemp = deleteFromTempStatement.executeUpdate();

        // Cập nhật trạng thái của car nếu thêm hóa đơn thành công
        if (affectedRows > 0 && affectedRowsTemp > 0) {
            updateCarStatusStatement.setString(1, carOnRent.getCarID());
            updateCarStatusStatement.executeUpdate();
        }

        connection.commit();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void updateCarOnRent(Car_on_rent car_on_rent) {
        String sql = "UPDATE car_rented SET CARID=?, CUSID=?, RENTDATE=?, RETURNDATE=? WHERE RENTID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, car_on_rent.getCarID());
            preparedStatement.setString(2, car_on_rent.getCustomerID());
            preparedStatement.setDate(3, car_on_rent.getRentDate());
            preparedStatement.setDate(4, car_on_rent.getReturnDate());
            preparedStatement.setString(5, car_on_rent.getRentID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCarOnRent(String rentID) {
        String sql = "DELETE FROM car_rented WHERE RENTID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, rentID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car_on_rent> getAllCarOnRent() {
        List<Car_on_rent> car_on_rentList = new ArrayList<>();
        String sql = "SELECT * FROM car_rented";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Car_on_rent car_on_rent = new Car_on_rent(
                        resultSet.getString("CARID"),
                        resultSet.getString("CUSID"),
                        resultSet.getString("RENTID"),
                        resultSet.getDate("RENTDATE"),
                        resultSet.getDate("RETURNDATE")
                );
                car_on_rentList.add(car_on_rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car_on_rentList;
    }
    public List<Car_on_rent> getAllCarOnRentWithFeesFromFunction() {
    List<Car_on_rent> carOnRentList = new ArrayList<>();
    String sql = "SELECT * FROM hien_thi_hoa_don()";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            Car_on_rent carOnRent = new Car_on_rent(
                    resultSet.getString("CARID"),
                    resultSet.getString("CUSID"),
                    resultSet.getString("RENTID"),
                    resultSet.getDate("RENTDATE"),
                    resultSet.getDate("RETURNDATE")
            );
            carOnRent.setPrice(resultSet.getFloat("Fees"));
            carOnRentList.add(carOnRent);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return carOnRentList;
}
    
    
    
    public List<Car_on_rent> getReturnedCarFromFunction() {
        List<Car_on_rent> carOnRentList = new ArrayList<>();
        String sql = "SELECT * FROM hien_thi_tra_xe()";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        
        while (resultSet.next()) {
            Car_on_rent carOnRent = new Car_on_rent();
            carOnRent.setCarID(resultSet.getString("CARID"));
            carOnRent.setCustomerID(resultSet.getString("CUSID"));
            carOnRent.setTrueReturnDate(resultSet.getDate("RETURNDATE"));
            carOnRent.setRentID(resultSet.getString("RENTID"));
            carOnRent.setPhat(resultSet.getFloat("TienPhat"));
            carOnRent.setDelay(resultSet.getInt("NgayDeLay"));
            carOnRent.setPrice(resultSet.getFloat("Fees"));
            carOnRentList.add(carOnRent);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return carOnRentList;
}

    private Connection getConnection() {
        try {
            return Connect_DB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }
    public void updateDoanhThu(Car car) {
    String sql = "{CALL cap_nhat_thong_tin_xe(?)}";
    
    try (Connection connection = Connect_DB.connect();
         CallableStatement callableStatement = connection.prepareCall(sql)) {
        
        callableStatement.setString(1, car.getCarID());

        callableStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void tongket() {
    String sql = "{CALL reset_car_statistics()}";

    try (Connection connection = Connect_DB.connect();
         CallableStatement callableStatement = connection.prepareCall(sql)) {

        callableStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
} 

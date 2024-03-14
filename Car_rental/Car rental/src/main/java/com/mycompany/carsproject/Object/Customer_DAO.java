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
public class Customer_DAO {
      //Thêm một khách hàng mới vào cơ sở dữ liệu.
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (CUSID, HoTen, DiaChi, SoDienThoai, Email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getCUSID());
            preparedStatement.setString(2, customer.getHoTen());
            preparedStatement.setString(3, customer.getDiaChi());
            preparedStatement.setString(4, customer.getSoDienThoai());
            preparedStatement.setString(5, customer.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cập nhật thông tin của một khách hàng trong cơ sở dữ liệu.
     * @param customer Đối tượng khách hàng cần cập nhật.
     */
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET HoTen=?, DiaChi=?, SoDienThoai=?, Email=? WHERE CUSID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getHoTen());
            preparedStatement.setString(2, customer.getDiaChi());
            preparedStatement.setString(3, customer.getSoDienThoai());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getCUSID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Xóa một khách hàng khỏi cơ sở dữ liệu dựa trên CUSID.
     * @param CUSID Mã khách hàng cần xóa.
     */
    public void deleteCustomer(String CUSID) {
        String sql = "DELETE FROM customer WHERE CUSID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, CUSID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lấy danh sách tất cả khách hàng từ cơ sở dữ liệu.
     * @return Danh sách khách hàng.
     */
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getString("CUSID"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("Email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    /**
     * Lấy một kết nối đến cơ sở dữ liệu.
     * @return Kết nối đến cơ sở dữ liệu.
     */
    private Connection getConnection() {
        // Thực hiện xử lý lấy kết nối từ DriverManager
        try {
            return Connect_DB.connect();
        } catch (SQLException e) {
            // Xử lý ngoại lệ theo nhu cầu của bạn
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }
    public List<String> getAllCustomerIDs() {
        List<String> customerIDs = new ArrayList<>();
        String sql = "SELECT CUSID FROM customer";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String customerID = resultSet.getString("CUSID");
                customerIDs.add(customerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerIDs;
    }
    
    
   
}

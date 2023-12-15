/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project_l05.Model;
import com.mycompany.oop_project_l05.Connect_DB;
import java.math.BigDecimal;
import java.sql.CallableStatement;
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
public class EmployeeDAO {
    private static final String SELECT_EMPLOYEES_QUERY = "SELECT * FROM EmployeeInfoView";
    private static final String INSERT_EMPLOYEE_QUERY = "{call AddUserAndEmployee(?, ?, ?, ?, ?, ?, ?)}";
    private static final String UPDATE_EMPLOYEE_QUERY = "{call UpdateUserAndEmployeeInfo(?, ?, ?, ?, ?, ?, ?)}";
    private static final String DELETE_EMPLOYEE_QUERY = "{call DeleteUserAndEmployee(?, ?, ?, ?, ?, ?, ?)}";
    public List<Employee> layDanhSachNhanVien() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = Connect_DB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEES_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setSalary(resultSet.getBigDecimal("salary"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
        }

        return employees;
    }
    public boolean themNhanVien(Employee employee) {
        try (Connection connection = Connect_DB.connect();
             CallableStatement cs = connection.prepareCall(INSERT_EMPLOYEE_QUERY)) {

            cs.setString(1, employee.getUsername());
            cs.setString(2, employee.getPassword());
            cs.setInt(3, employee.getEmployeeId());
            cs.setString(4, employee.getName());
            cs.setString(5, employee.getEmail());
            cs.setString(6, employee.getPhone());
            cs.setBigDecimal(7, employee.getSalary());

            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean suaNhanVien(Employee employee) {
        try (Connection connection = Connect_DB.connect();
             CallableStatement cs = connection.prepareCall(UPDATE_EMPLOYEE_QUERY)) {

            cs.setString(1, employee.getUsername());
            cs.setString(2, employee.getPassword());
            cs.setInt(3, employee.getEmployeeId());
            cs.setString(4, employee.getName());
            cs.setString(5, employee.getEmail());
            cs.setString(6, employee.getPhone());
            cs.setBigDecimal(7, employee.getSalary());

            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean xoaNhanVien(Employee employee) {
        try (Connection connection = Connect_DB.connect();
            CallableStatement cs = connection.prepareCall(DELETE_EMPLOYEE_QUERY)) {

            cs.setString(1, employee.getUsername());
            cs.setString(2, employee.getPassword());
            cs.setInt(3, employee.getEmployeeId());
            cs.setString(4, employee.getName());
            cs.setString(5, employee.getEmail());
            cs.setString(6, employee.getPhone());
            cs.setBigDecimal(7, employee.getSalary());

        return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

    Employee newEmployee = new Employee();
    newEmployee.setUsername("'john_doe'");
    newEmployee.setPassword("password123");
    newEmployee.setEmployeeId(1001);
    newEmployee.setName("John Doe");
    newEmployee.setEmail("john.doe@example.com");
    newEmployee.setPhone("123-456-7890");
    newEmployee.setSalary(new BigDecimal("50000.00"));

    boolean themNhanVienThanhCong = employeeDAO.xoaNhanVien(newEmployee);
    System.out.println("Thêm nhân viên thành công: " + themNhanVienThanhCong);

    }


}

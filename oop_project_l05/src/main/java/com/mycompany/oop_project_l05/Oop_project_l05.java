/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oop_project_l05;

import com.mycompany.oop_project_l05.Model.Employee;
import com.mycompany.oop_project_l05.Model.EmployeeDAO;
import java.math.BigDecimal;

/**
 *
 * @author sonki
 */
public class Oop_project_l05 {


     public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

    Employee newEmployee = new Employee();
    newEmployee.setUsername("newUser");
    newEmployee.setPassword("newPassword");
    newEmployee.setEmployeeId(101);
    newEmployee.setName("New Employee");
    newEmployee.setEmail("newemployee@example.com");
    newEmployee.setPhone("123456789");
    newEmployee.setSalary(new BigDecimal("50000.00"));

    boolean themNhanVienThanhCong = employeeDAO.xoaNhanVien(newEmployee);
    System.out.println("Thêm nhân viên thành công: " + themNhanVienThanhCong);

    }

}

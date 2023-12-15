/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project_l05;

/**
 *
 * @author sonki
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_DB {

    public static Connection connect() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost\\DESKTOP-1OPH999:1433;databaseName=mydatabase;encrypt=true;trustServerCertificate=true";
            String user = "admin";
            String password = "123456789";
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo nhu cầu của bạn
        }

        return conn;
    }

    // Các phương thức khác có thể được thêm vào cho các mục đích khác nhau

    public static void main(String[] args) {
        try {
            Connection connection = connect();
            
            // Thực hiện các hoạt động với đối tượng Connection ở đây
            
            // Đảm bảo đóng kết nối sau khi hoàn thành công việc
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


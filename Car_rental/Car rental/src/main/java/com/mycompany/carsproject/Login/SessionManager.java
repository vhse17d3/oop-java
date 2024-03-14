/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
/**
 *
 * @author sonki
 */
public class SessionManager {
    private static String loggedInUsername;

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }
    
    public static void logout() {
        // Clear the logged-in username
        loggedInUsername = null;
        
    }
     public static String getPasswordByUsername(String username) {
        String password = null;
        String sql = "SELECT pass FROM account WHERE username=?";
        try (Connection connection = Connect_DB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    password = resultSet.getString("pass");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}

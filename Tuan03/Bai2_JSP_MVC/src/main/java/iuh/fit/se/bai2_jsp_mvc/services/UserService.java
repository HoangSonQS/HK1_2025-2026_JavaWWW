package iuh.fit.se.bai2_jsp_mvc.services;

import iuh.fit.se.bai2_jsp_mvc.connectdb.DBConnection;
import iuh.fit.se.bai2_jsp_mvc.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, email, password, birthdate, gender) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setDate(5, Date.valueOf(user.getBirthdate()));
            statement.setString(6, user.getGender());
            statement.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT first_name, last_name, email, birthdate, gender FROM users"; // Không lấy password
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
                user.setGender(resultSet.getString("gender"));
                users.add(user);
            }
        }
        return users;
    }
}
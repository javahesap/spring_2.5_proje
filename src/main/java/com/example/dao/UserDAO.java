package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.User;

public class UserDAO extends BaseDao {

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}

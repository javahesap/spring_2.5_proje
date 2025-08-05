package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.User;
import com.example.model.UserDAO;
import com.example.model.User;
import java.sql.*;
import java.util.*;

public class UserDaoImpl implements UserDAO {

    private Connection conn;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void save(User user) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void update(User user) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE users SET username=?, password=?, email=? WHERE id=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = mapUser(rs);
            }
            rs.close();
            ps.close();
        } catch (Exception e) { e.printStackTrace(); }
        return user;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapUser(rs));
            }
            rs.close();
            ps.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = mapUser(rs);
            }
            rs.close();
            ps.close();
        } catch (Exception e) { e.printStackTrace(); }
        return user;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        return u;
    }
}


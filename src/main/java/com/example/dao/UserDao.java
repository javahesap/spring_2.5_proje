package com.example.dao;



import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.User;

import java.util.List;

import javax.sql.DataSource;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    // Spring setter injection
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Object countUsers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
    }
    
    // Tüm kullanıcıları listeleme metodu
    public List<User> getAllUsers() {
        String sql = "SELECT id, username, password, email, role FROM users";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));
            return user;
        });
    }
    
}

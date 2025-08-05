package com.example.model;



import com.example.model.User;
import java.util.List;

public interface UserDAO {
    void save(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    List<User> findAll();
    User findByUsernameAndPassword(String username, String password);
}

package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.dao.UserDAO;
import com.example.model.User;

public class UserController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDAO dao = new UserDAO();
        List<User> userList = dao.findAllUsers();
        return new ModelAndView("users", "userList", userList);
    }
}

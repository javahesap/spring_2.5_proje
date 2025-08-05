package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.dao.UserDaoImpl;
import com.example.model.User;
import com.example.model.UserDAO;
import com.example.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {

    private UserDAO userDao;

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public ModelAndView list(HttpServletRequest req, HttpServletResponse res) {
        List<User> users = userDao.findAll();
        return new ModelAndView("users", "users", users);
    }

    public ModelAndView save(HttpServletRequest req, HttpServletResponse res) {
        User u = new User();
        u.setUsername(req.getParameter("username"));
        u.setPassword(req.getParameter("password"));
        u.setEmail(req.getParameter("email"));
        userDao.save(u);
        return new ModelAndView("redirect:/user/list.htm");
    }

    public ModelAndView delete(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        userDao.delete(id);
        return new ModelAndView("redirect:/user/list.htm");
    }
}

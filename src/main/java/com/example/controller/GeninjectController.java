package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.example.dao.UserDao;
import com.example.model.User;

public class GeninjectController extends MultiActionController {

    private UserDao userDao;

    // Spring XML'den inject edilecek
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ModelAndView hnduruninj(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object count = userDao.countUsers();

        ModelAndView mav = new ModelAndView("urun");
        mav.addObject("count", count); // sayıyı modele ekledik (istenirse JSP'de gösterilir)
        return mav;
    }

    public ModelAndView hnddenemeinj(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        return new ModelAndView("deneme");
    }

    public ModelAndView hndusersinj(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userDao.getAllUsers();

        ModelAndView mav = new ModelAndView("users");
        mav.addObject("users", users);
        return mav;
    }
}

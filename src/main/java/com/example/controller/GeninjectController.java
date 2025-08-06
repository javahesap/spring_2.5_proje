package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.example.dao.UserDao;
import com.example.model.User;

public class GeninjectController extends MultiActionController {

	public ModelAndView hnduruninj(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// Spring context'i al
        WebApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        // Spring bean olarak tanımlanmış userDao'yu al
        UserDao userDao = (UserDao) context.getBean("userDao");

        // Veritabanından kullanıcı sayısını çek
        int count = (Integer) userDao.countUsers();

		
		
		

		return new ModelAndView("urun");
	}

	public ModelAndView hnddenemeinj(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("deneme");
	}
	
	
	
    public ModelAndView hndusersinj(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Spring context'i al
        WebApplicationContext context =   WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        // Spring bean olarak tanımlanmış userDao'yu al
        UserDao userDao = (UserDao) context.getBean("userDao");

        // Tüm kullanıcıları listele
        List<User> users = userDao.getAllUsers();

        // ModelAndView oluştur ve kullanıcıları modele ekle
        ModelAndView mav = new ModelAndView("users"); // urun.jsp
        mav.addObject("users", users);

        return mav;
    }
	
	
	
	

}

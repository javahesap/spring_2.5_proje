package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "1234".equals(pass)) {
            request.getSession().setAttribute("user", user);
            return new ModelAndView("redirect:/home.html");
        } else {
            return new ModelAndView("login", "error", "Hatalı giriş!");
        }
    }
}

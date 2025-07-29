package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        return new ModelAndView("formResult", "message", "Merhaba, " + name);
    }
}

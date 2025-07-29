package com.example.controller.urun;

import java.util.List;

import javax.servlet.http.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.Controller;

import com.example.dao.UrunDao;
import com.example.model.Urun;

public class UrunListeleController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		UrunDao dao = new UrunDao();
		List<Urun> urunler = dao.urunleriGetir();
		return new ModelAndView("urunListesi", "liste", urunler);
	}
}

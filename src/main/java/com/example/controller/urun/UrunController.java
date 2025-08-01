package com.example.controller.urun;

import com.example.model.Urun;
import com.example.dao.UrunDao;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrunController implements Controller {

    private UrunDao urunDao = new UrunDao();

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	String contextPath = request.getContextPath(); // /Spring2_5HelloWorld
    	String fullPath = request.getRequestURI();     // /Spring2_5HelloWorld/urun/urunler.html
    	String path = fullPath.substring(contextPath.length() + "/urun".length());
    	

        if (path.equals("/urunler.html")) {
            List<Urun> liste = urunDao.listele();
            return new ModelAndView("urunListesi", "liste", liste);
        }

        if (path.equals("/urunEkle.html")) {
            return new ModelAndView("urunEkle");
        }

        if (path.equals("/urunKaydet.html")) {
            String ad = request.getParameter("ad");
            double fiyat = Double.parseDouble(request.getParameter("fiyat"));
            Urun u = new Urun(ad, fiyat);
            urunDao.ekle(u);
            return new ModelAndView("redirect:urunler.html");
        }

        if (path.equals("/urunDuzenle.html")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Urun u = urunDao.bul(id);
            return new ModelAndView("urunDuzenle", "urun", u);
        }

        if (path.equals("/urunGuncelle.html")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String ad = request.getParameter("ad");
            double fiyat = Double.parseDouble(request.getParameter("fiyat"));
            Urun u = new Urun(id, ad, fiyat);
            urunDao.guncelle(u);
            return new ModelAndView("redirect:urunler.html");
        }

        if (path.equals("/urunSil.html")) {
            int id = Integer.parseInt(request.getParameter("id"));
            urunDao.sil(id);
            return new ModelAndView("redirect:urunler.html");
        }

        return new ModelAndView("error");
    }
}

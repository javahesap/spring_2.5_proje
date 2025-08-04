package com.example.controller;
import com.example.dao.StokDao;
import com.example.model.Stok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.*;
import java.util.*;

public class StokController extends MultiActionController {

   // private StokDao stokDao = new StokDao();
    
    @Autowired
    private StokDao stokDao;

    public ModelAndView listele(HttpServletRequest req, HttpServletResponse res) {
        List<Stok> list = stokDao.listele();
        return new ModelAndView("stokListesi", "liste", list);
    }

    public ModelAndView ekleForm(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView("stokEkle");
    }

    public ModelAndView kaydet(HttpServletRequest req, HttpServletResponse res) {
        Stok s = new Stok();
        s.setAd(req.getParameter("ad"));
        s.setMiktar(Integer.parseInt(req.getParameter("miktar")));
        s.setFiyat(Double.parseDouble(req.getParameter("fiyat")));
        stokDao.ekle(s);
        return new ModelAndView("redirect:listele.html");
    }

    public ModelAndView duzenleForm(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        Stok s = stokDao.bul(id);
        return new ModelAndView("stokDuzenle", "stok", s);
    }

    public ModelAndView guncelle(HttpServletRequest req, HttpServletResponse res) {
        Stok s = new Stok();
        s.setId(Integer.parseInt(req.getParameter("id")));
        s.setAd(req.getParameter("ad"));
        s.setMiktar(Integer.parseInt(req.getParameter("miktar")));
        s.setFiyat(Double.parseDouble(req.getParameter("fiyat")));
        stokDao.guncelle(s);
        return new ModelAndView("redirect:listele.html");
    }

    public ModelAndView sil(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        stokDao.sil(id);
        return new ModelAndView("redirect:listele.html");
    }
}

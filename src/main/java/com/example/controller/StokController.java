package com.example.controller;


import com.example.dao.StokDao;
import com.example.dao.UrunDao;
import com.example.model.Stok;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class StokController extends MultiActionController {


    private StokDao stokDao = new StokDao();

    public void setStokDao(StokDao stokDao) {
        this.stokDao = stokDao;
    }

    public ModelAndView liste(HttpServletRequest request, HttpServletResponse response) {
        List<Stok> liste = stokDao.listele();
        return new ModelAndView("liste", "liste", liste);
    }

    public ModelAndView ekleForm(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("ekle");
    }

    public ModelAndView kaydet(HttpServletRequest request, HttpServletResponse response) {
        Stok s = new Stok();
        s.setAd(request.getParameter("ad"));
        s.setMiktar(Integer.parseInt(request.getParameter("miktar")));
        s.setFiyat(Double.parseDouble(request.getParameter("fiyat")));
        stokDao.ekle(s);
        return new ModelAndView("redirect:stok.html?action=liste");
    }

    public ModelAndView duzenleForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Stok s = stokDao.bul(id);
        return new ModelAndView("guncelle", "stok", s);
    }

    public ModelAndView guncelle(HttpServletRequest request, HttpServletResponse response) {
        Stok s = new Stok();
        s.setId(Integer.parseInt(request.getParameter("id")));
        s.setAd(request.getParameter("ad"));
        s.setMiktar(Integer.parseInt(request.getParameter("miktar")));
        s.setFiyat(Double.parseDouble(request.getParameter("fiyat")));
        stokDao.guncelle(s);
        return new ModelAndView("redirect:stok.html?action=liste");
    }

    public ModelAndView sil(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        stokDao.sil(id);
        return new ModelAndView("redirect:stok.html?action=liste");
    }
}

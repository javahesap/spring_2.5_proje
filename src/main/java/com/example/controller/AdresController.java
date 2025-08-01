package com.example.controller;

import com.example.dao.AdresDao;
import com.example.model.Adres;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.*;
import java.util.*;

public class AdresController extends MultiActionController {

    private AdresDao adresDao = new AdresDao();

    public ModelAndView adreslistele(HttpServletRequest req, HttpServletResponse res) {
        List<Adres> liste = adresDao.listele();
        return new ModelAndView("adresListesi", "liste", liste);
    }

    public ModelAndView ekleForm(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView("adresEkle");
    }

    public ModelAndView kaydet(HttpServletRequest req, HttpServletResponse res) {
        Adres a = new Adres();
        a.setIl(req.getParameter("il"));
        a.setIlce(req.getParameter("ilce"));
        a.setAdresDetay(req.getParameter("adresDetay"));
        adresDao.ekle(a);
        return new ModelAndView("redirect:listele.html");
    }

    public ModelAndView duzenleForm(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        Adres a = adresDao.bul(id);
        return new ModelAndView("adresDuzenle", "adres", a);
    }

    public ModelAndView guncelle(HttpServletRequest req, HttpServletResponse res) {
        Adres a = new Adres();
        a.setId(Integer.parseInt(req.getParameter("id")));
        a.setIl(req.getParameter("il"));
        a.setIlce(req.getParameter("ilce"));
        a.setAdresDetay(req.getParameter("adresDetay"));
        adresDao.guncelle(a);
        return new ModelAndView("redirect:listele.html");
    }

    public ModelAndView sil(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        adresDao.sil(id);
        return new ModelAndView("redirect:listele.html");
    }
}

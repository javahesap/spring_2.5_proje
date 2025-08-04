package com.example.servlet;

import com.example.dao.StokDao;
import com.example.model.Stok;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class StokServlet extends HttpServlet {

    private StokDao stokDao = new StokDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "listele";

        switch (action) {
            case "ekleForm":
                req.getRequestDispatcher("/WEB-INF/views/stok/stokEkle.jsp").forward(req, res);
                break;
            case "duzenleForm":
                int id = Integer.parseInt(req.getParameter("id"));
                Stok stok = stokDao.bul(id);
                req.setAttribute("stok", stok);
                req.getRequestDispatcher("/WEB-INF/views/stok/stokDuzenle.jsp").forward(req, res);
                break;
            case "sil":
                stokDao.sil(Integer.parseInt(req.getParameter("id")));
                res.sendRedirect("stok?action=listele");
                break;
            case "listele":
                List<Stok> liste = stokDao.listele();
                req.setAttribute("liste", liste);
                req.getRequestDispatcher("/WEB-INF/views/stok/stokListesi.jsp").forward(req, res);
                break; // BU satır eksikti!
            default:
                List<Stok> liste2 = stokDao.listele();
                req.setAttribute("liste", liste2);
                req.getRequestDispatcher("/WEB-INF/views/stok/stokListesi.jsp").forward(req, res);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("kaydet".equals(action)) {
            Stok s = new Stok();
            s.setAd(req.getParameter("ad"));
            s.setMiktar(Integer.parseInt(req.getParameter("miktar")));
            s.setFiyat(Double.parseDouble(req.getParameter("fiyat")));
            stokDao.ekle(s);
        } else if ("guncelle".equals(action)) {
            Stok s = new Stok();
            s.setId(Integer.parseInt(req.getParameter("id")));
            s.setAd(req.getParameter("ad"));
            s.setMiktar(Integer.parseInt(req.getParameter("miktar")));
            s.setFiyat(Double.parseDouble(req.getParameter("fiyat")));
            stokDao.guncelle(s);
        }

        res.sendRedirect("stok?action=listele");
    }
}

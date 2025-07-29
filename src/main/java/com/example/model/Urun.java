package com.example.model;


public class Urun {
    private int id;
    private String ad;
    private double fiyat;

    // Getter - Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }
    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}

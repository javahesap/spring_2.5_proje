package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.Urun;

public class UrunDao extends BaseDao {

    // Listeleme
    public List<Urun> listele() {
        List<Urun> liste = new ArrayList<>();
        String sql = "SELECT * FROM urunler";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Urun u = new Urun();
                u.setId(rs.getInt("id"));
                u.setAd(rs.getString("ad"));
                u.setFiyat(rs.getDouble("fiyat"));
                liste.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }

    // Ekleme
    public void ekle(Urun urun) {
        String sql = "INSERT INTO urunler (ad, fiyat) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, urun.getAd());
            stmt.setDouble(2, urun.getFiyat());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Güncelleme
    public void guncelle(Urun urun) {
        String sql = "UPDATE urunler SET ad = ?, fiyat = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, urun.getAd());
            stmt.setDouble(2, urun.getFiyat());
            stmt.setInt(3, urun.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Silme
    public void sil(int id) {
        String sql = "DELETE FROM urunler WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ID'ye göre bulma
    public Urun bul(int id) {
        Urun urun = null;
        String sql = "SELECT * FROM urunler WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                urun = new Urun();
                urun.setId(rs.getInt("id"));
                urun.setAd(rs.getString("ad"));
                urun.setFiyat(rs.getDouble("fiyat"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return urun;
    }
}

package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.Urun;

public class UrunDao extends BaseDao {

    public List<Urun> urunleriGetir() {
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
}

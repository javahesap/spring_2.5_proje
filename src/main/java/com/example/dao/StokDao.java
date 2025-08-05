package com.example.dao;
import com.example.model.Stok;
import java.sql.*;
import java.util.*;

public class StokDao extends BaseDao {

    public List<Stok> listele() {
        List<Stok> list = new ArrayList<>();
        String sql = "SELECT * FROM stoklar";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Stok s = new Stok();
                s.setId(rs.getInt("id"));
                s.setAd(rs.getString("ad"));
                s.setMiktar(rs.getInt("miktar"));
                s.setFiyat(rs.getDouble("fiyat"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void ekle(Stok s) {
        String sql = "INSERT INTO stoklar (ad, miktar, fiyat) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getAd());
            ps.setInt(2, s.getMiktar());
            ps.setDouble(3, s.getFiyat());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guncelle(Stok s) {
        String sql = "UPDATE stoklar SET ad=?, miktar=?, fiyat=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getAd());
            ps.setInt(2, s.getMiktar());
            ps.setDouble(3, s.getFiyat());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sil(int id) {
        String sql = "DELETE FROM stoklar WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stok bul(int id) {
        String sql = "SELECT * FROM stoklar WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Stok s = new Stok();
                s.setId(rs.getInt("id"));
                s.setAd(rs.getString("ad"));
                s.setMiktar(rs.getInt("miktar"));
                s.setFiyat(rs.getDouble("fiyat"));
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

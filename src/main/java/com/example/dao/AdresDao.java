package com.example.dao;


import com.example.model.Adres;
import java.sql.*;
import java.util.*;

public class AdresDao extends BaseDao {

    public List<Adres> listele() {
        List<Adres> list = new ArrayList<>();
        String sql = "SELECT * FROM adresler";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Adres a = new Adres();
                a.setId(rs.getInt("id"));
                a.setIl(rs.getString("il"));
                a.setIlce(rs.getString("ilce"));
                a.setAdresDetay(rs.getString("adres_detay"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void ekle(Adres a) {
        String sql = "INSERT INTO adresler (il, ilce, adres_detay) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getIl());
            ps.setString(2, a.getIlce());
            ps.setString(3, a.getAdresDetay());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guncelle(Adres a) {
        String sql = "UPDATE adresler SET il=?, ilce=?, adres_detay=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getIl());
            ps.setString(2, a.getIlce());
            ps.setString(3, a.getAdresDetay());
            ps.setInt(4, a.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sil(int id) {
        String sql = "DELETE FROM adresler WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Adres bul(int id) {
        String sql = "SELECT * FROM adresler WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Adres a = new Adres();
                a.setId(rs.getInt("id"));
                a.setIl(rs.getString("il"));
                a.setIlce(rs.getString("ilce"));
                a.setAdresDetay(rs.getString("adres_detay"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

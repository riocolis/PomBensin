/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pombensin.config.Koneksi;

/**
 *
 * @author Nurcholis Rio
 */
public class DBPelanggan {
    public ArrayList<PelangganPom> pelanggan;
    Koneksi db;
    ResultSet rs;

    public DBPelanggan() {
        pelanggan = new ArrayList<>();
        try {
            db = new Koneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addpelanggan(PelangganPom pelangganbaru){
        try {
            String sql = "insert into pelanggan "
                    + "(nama, password)"
                    + " values (?, ?)";
            PreparedStatement prep = db.prepQuery(sql);
            prep.setString(1, pelangganbaru.nama);
            prep.setString(2, pelangganbaru.password);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addpelanggan (String nama, String password){
        PelangganPom newPelanggan = new PelangganPom();
        newPelanggan.nama = nama;
        newPelanggan.password = password;
                
        this.addpelanggan(newPelanggan);
    }
    public ArrayList<PelangganPom> getAllPelanggan(){
        try {
            String sql = "select * from pelanggan ";
            db.query(sql);
            rs = db.rs;
            while(db.rs.next())
            {
                pelanggan.add(new PelangganPom(
                rs.getInt("id_pelanggan"),
                rs.getString("nama"),
                rs.getString("password")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pelanggan;
    }
    public void deletePelanggan(String nama)
    {
        try {
            String sql ="delete from pelanggan where nama = ?";
            PreparedStatement prep = db.prepQuery(sql);
            prep.setString(1, nama);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

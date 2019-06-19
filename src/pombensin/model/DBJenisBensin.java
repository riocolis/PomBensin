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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import pombensin.config.Koneksi;

/**
 *
 * @author Nurcholis Rio
 */
public class DBJenisBensin {
    public ArrayList<JenisBensin> jenisbensin;
    Koneksi db;
    ResultSet rs;
    PreparedStatement prep;
    
    public DBJenisBensin(){
        try {
            jenisbensin = new ArrayList<>();
            db = new Koneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<JenisBensin> getAllBensincmb()
    {
        String sql = "Select * from jenisbensin";
        try {
            db.query(sql);
            rs = db.rs;
            while(rs.next()){
                jenisbensin.add(new JenisBensin(rs.getInt("id_jenisbensin"),
                rs.getString("jenisbensin"),
                rs.getInt("harga")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jenisbensin;
    }
    public void cmbSelectBensin(JComboBox String, JLabel text)
    {
        try {
            String sql ="select harga from jenisbensin where jenisbensin=?";
            prep  = db.prepQuery(sql);
            prep.setString(1,String.getSelectedItem().toString());
            rs = prep.executeQuery();
            while(rs.next())
            {
                text.setText(rs.getString("harga"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getAllBensin(){
        String sql = "select * from jenisbensin ";
        try {
            db.query(sql);
            rs=db.rs;
            while(db.rs.next())
            {
                jenisbensin.add(new JenisBensin(
                rs.getInt("id_jenisbensin"),
                rs.getString("jenisbensin"),
                rs.getInt("harga")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jenisbensin;
    }
    public void addBensin(JenisBensin bensinbaru){
        try {
            String sql ="insert into jenisbensin "
                    + "(jenisbensin,harga) "
                    + "values (?, ?)";
            PreparedStatement prep = db.prepQuery(sql);
            prep.setString(1, bensinbaru.jenisBensin);
            prep.setInt(2, bensinbaru.harga);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addBensin(String namabensin, int hargabensin)
    {
        JenisBensin newBensin = new JenisBensin();
        newBensin.jenisBensin = namabensin;
        newBensin.harga=hargabensin;
        
        this.addBensin(newBensin);
    }
    public void editBensin(JenisBensin bensinbaru)
    {
        try {
            String sql = "update jenisbensin set jenisbensin = ?, harga = ? "
                    + "where id_jenisbensin = ?";
            PreparedStatement prep = db.prepQuery(sql);
            prep.setString(1, bensinbaru.jenisBensin);
            prep.setInt(2, bensinbaru.harga);
            prep.setInt(3, bensinbaru.idJenisbensin);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBJenisBensin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

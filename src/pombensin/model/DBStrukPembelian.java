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
import javax.swing.JTextArea;
import pombensin.config.Koneksi;

/**
 *
 * @author Nurcholis Rio
 */
public class DBStrukPembelian {
    public ArrayList<StrukPembelian> ListStruk;
    Koneksi db;
    ResultSet rs;

    public DBStrukPembelian() {
        ListStruk = new ArrayList<>();
        try {
            db = new Koneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBStrukPembelian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBStrukPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addStruk(StrukPembelian Liststruk)
    {
        try {
        String sql="insert into strukpembelian"
                + "(nama,jenisbensin_id,harga,belibensin,total_liter)"
                + " values (?,?,?,?,?)";
            PreparedStatement prep = db.prepQuery(sql);
            prep.setString(1, Liststruk.nama);
            prep.setInt(2, Liststruk.jenisBensin.idJenisbensin);
            prep.setInt(3, Liststruk.liter);
            prep.setInt(4, Liststruk.totalbeli);
            prep.setDouble(5, Liststruk.totalliter);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBStrukPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void addStruk(String nama, int Bensin, int harga_liter, int beli_bensin, double totalLiter)
    {
        StrukPembelian newPembelian = new StrukPembelian();
        newPembelian.nama = nama;
        newPembelian.jenisBensin = new JenisBensin(Bensin,"",harga_liter);
        newPembelian.liter=harga_liter;
        newPembelian.totalbeli=beli_bensin;
        newPembelian.totalliter=totalLiter;
        
        this.addStruk(newPembelian);
    }
    public void printStruk(String nama, JenisBensin JBensin, int harga_liter, int Beli_Bensin, double totalLiter, JTextArea textarea)
    {
        textarea.append("\tStruk Pembelian Systems : \n"
                + "\n==================================\n"
                + "\nNama Pelanggan\t:"+nama
                + "\nJenis Bensin\t\t:"+JBensin
                + "\nHarga/Liter\t\t:"+harga_liter
                + "\nBeli Bensin\t\t:"+Beli_Bensin
                + "\nTotal Liter\t\t:"+totalLiter
                + "\n\n=================================="
                + "\n\n Terima Kasih ----- Adminstrator");
        
    }
    public ArrayList getAllStruk(){
        String sql = "select strukpembelian.*,jenisbensin.jenisbensin as nama_bensin, jenisbensin.harga as harga_bensin "
                + "from strukpembelian "
                + "join jenisbensin on (strukpembelian.jenisbensin_id = jenisbensin.id_jenisbensin)";
        try {
            db.query(sql);
            rs = db.rs;
            while(db.rs.next())
            {
                ListStruk.add(new StrukPembelian(
                rs.getInt("id"),
                rs.getString("nama"),
                new JenisBensin(rs.getInt("jenisbensin_id"),rs.getString("nama_bensin"),rs.getInt("harga_bensin")),
                rs.getInt("harga_bensin"),
                rs.getInt("belibensin"),
                rs.getDouble("total_liter")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBStrukPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListStruk;
    }
}

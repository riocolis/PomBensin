/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.model;

/**
 *
 * @author Nurcholis Rio
 */
public class StrukPembelian {
    public int id_pembelian;
    public String nama;
    public JenisBensin jenisBensin;
    public int liter;
    public int totalbeli;
    public double totalliter;

    public StrukPembelian(int id_pembelian, String nama, JenisBensin jenisBensin, int liter, int totalbeli, double totalliter) {
        this.id_pembelian = id_pembelian;
        this.nama = nama;
        this.jenisBensin = jenisBensin;
        this.liter = liter;
        this.totalbeli = totalbeli;
        this.totalliter = totalliter;
    }

    public StrukPembelian() {
    }

}
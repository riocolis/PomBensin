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
public class KalkulatorBensin {
    public int id_kalkulator;//id_kalkulator
    public String nama_pelanggan;//id_pelanggan yang melakukan transaksi
    public JenisBensin jenisbensin;//jenis bensin yang digunakaan
    public int belibensin;//membeli bensin jumlah brp
    public int jumlah;
    public double liter;//convert dari belibensin dan harga satuan 
    
    public KalkulatorBensin(int id_kalkulator, String nama_pelanggan, JenisBensin jenisbensin, int belibensin, int jumlah, double liter)
    {
        this.id_kalkulator=id_kalkulator;
        this.nama_pelanggan=nama_pelanggan;
        this.jenisbensin=jenisbensin;
        this.belibensin=belibensin;
        this.jumlah=jumlah;
        this.liter=liter;
    }
}

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
public class PelangganPom {// table pelanggan ada id pelanggan dan nama
    public int id_pelanggan;
    public String nama;
    public String password;
    public PelangganPom()
    {
        
    }
    public PelangganPom(int id_pelanggan,
            String nama,
            String password)
    {
        this.id_pelanggan=id_pelanggan;
        this.nama=nama;
        this.password=password;
    }
}

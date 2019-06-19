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
public class JenisBensin {/// tabel bensin dengan 3
    public int idJenisbensin;
    public String jenisBensin;
    public int harga;
    
    public JenisBensin(int idJenisbensin, String jenisBensin,int harga){
        this.idJenisbensin=idJenisbensin;
        this.jenisBensin=jenisBensin;
        this.harga=harga;
    }

    public JenisBensin() {
        
    }
    @Override
    public String toString() {
        return jenisBensin;
    }

}

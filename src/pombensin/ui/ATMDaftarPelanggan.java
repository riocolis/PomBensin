/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.ui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pombensin.model.DBPelanggan;
import pombensin.model.PelangganPom;

/**
 *
 * @author Nurcholis Rio
 */
public class ATMDaftarPelanggan extends AbstractTableModel {
    private DBPelanggan pelanggan;
    private String headers[]={"id","Nama Pelanggan","password"};
    public ArrayList<PelangganPom> data;

    public ATMDaftarPelanggan() {
        pelanggan = new DBPelanggan();
        data = pelanggan.getAllPelanggan();
    }

    @Override
    public String getColumnName(int column)
    {
        return headers[column];
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        PelangganPom pomPelanggan = data.get(rowIndex);
        switch(columIndex){
            case 0 : return pomPelanggan.id_pelanggan;
            case 1 : return pomPelanggan.nama;
            case 2 : return pomPelanggan.password;
            default : return "";
        }
    }
    
}

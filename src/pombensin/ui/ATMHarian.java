/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.ui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pombensin.model.DBStrukPembelian;
import pombensin.model.StrukPembelian;

/**
 *
 * @author Nurcholis Rio
 */
public class ATMHarian extends AbstractTableModel{
    
    private DBStrukPembelian struk;
    private String headers[] ={"Id_pembelian","Nama Pelanggan","Jenis Bensin","harga","Beli Bensin","Total Liter"};
    public ArrayList<StrukPembelian> data;

    public ATMHarian() {
        struk = new DBStrukPembelian();
        data = struk.getAllStruk();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        StrukPembelian struk = data.get(rowIndex);
        switch(columnIndex){
            case 0 : return struk.id_pembelian;
            case 1 : return struk.nama;
            case 2 : return struk.jenisBensin.jenisBensin;
            case 3 : return struk.jenisBensin.harga;
            case 4 : return struk.totalbeli;
            case 5 : return struk.totalliter;
            default : return "";
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.ui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pombensin.model.DBJenisBensin;
import pombensin.model.JenisBensin;

/**
 *
 * @author Nurcholis Rio
 */
public class ATMDaftarBensin extends AbstractTableModel {
    private DBJenisBensin jenis;
    private String headers[] = {"id","Nama Bensin","harga"};
    public ArrayList<JenisBensin> data;

    public ATMDaftarBensin() {
        jenis = new DBJenisBensin();
        data = jenis.getAllBensin();
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
        JenisBensin jenis2 = data.get(rowIndex);
        switch(columnIndex){
            case 0 : return jenis2.idJenisbensin;
            case 1 : return jenis2.jenisBensin;
            case 2 : return jenis2.harga;
            default : return "";
        }
    }
    
}

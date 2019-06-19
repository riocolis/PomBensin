/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import pombensin.config.Koneksi;

/**
 *
 * @author Nurcholis Rio
 */
public class DBKalkulator {
    public ArrayList<KalkulatorBensin> kalkulator;
    Koneksi db;
    ResultSet rs;

    public DBKalkulator() {
        try {
            kalkulator = new ArrayList<>();
            db = new Koneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBKalkulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBKalkulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String jumlahbensin(String text, String text2)
    {
        double liter1 = Double.parseDouble(text);
        double liter2 = Double.parseDouble(text2);
        double totalliter=liter2/liter1;
        String totalliter2 = Double.toString(totalliter);
        return totalliter2;
    }
    public void TampilTakaran(JLabel text, JTextArea jtextarea)
    {
        String jmlbensin = text.getText();
        String textloop;
        double totalbensin = 0;
        double liter1 = Double.parseDouble(jmlbensin);
        while(totalbensin != liter1 && totalbensin<liter1)
        {
            totalbensin= totalbensin+0.0001;
            jtextarea.append("Bensin = "+totalbensin+"\n");
        }
        jtextarea.append("total takaran = "+String.format("%,.2f",totalbensin)+" Liter");
    }
    
}

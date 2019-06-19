/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pombensin.config.Koneksi;
import pombensin.model.DBPelanggan;


/**
 *
 * @author Nurcholis Rio
 */
public class LoginPelanggan extends javax.swing.JFrame {
    private DBPelanggan pelanggan;
    private Koneksi conn;
    public ResultSet rs;
    /**
     * Creates new form LoginAdmin
     */
    public LoginPelanggan() {
        try {
            pelanggan = new DBPelanggan();
            conn = new Koneksi();
            this.setLocationRelativeTo(null);
            initComponents();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void masukPelanggan()
    {
        try{
            String nama = masukUser.getText();
            String input = new String(masukPassword.getPassword());
            String sql = "Select * From pelanggan Where nama = '"+nama+"' And password ='"+input+"'";
            conn.query(sql);
            rs=conn.rs;
            int baris=0;
            while(rs.next())
            {
                baris=rs.getRow();
            }
            if(baris==1)
            {
               new Dashboard().show();
               this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Nama Pelanggan dan Password Salah silahkan Coba lagi kembali");
                masukUser.setText("");
                masukPassword.setText("");
            }
            
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePelanggan = new javax.swing.JLabel();
        TitleNama = new javax.swing.JLabel();
        TitlePassword = new javax.swing.JLabel();
        masukUser = new javax.swing.JTextField();
        masukPassword = new javax.swing.JPasswordField();
        AksiMasuk = new javax.swing.JButton();
        AksiKeluar = new javax.swing.JButton();
        AksiDaftar = new javax.swing.JButton();
        AksiAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitlePelanggan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TitlePelanggan.setText("Login Pelanggan");

        TitleNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TitleNama.setText("Nama Pelanggan");

        TitlePassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TitlePassword.setText("Password");

        masukUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukUserActionPerformed(evt);
            }
        });

        AksiMasuk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AksiMasuk.setText("Masuk");
        AksiMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AksiMasukActionPerformed(evt);
            }
        });

        AksiKeluar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AksiKeluar.setText("Keluar");

        AksiDaftar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AksiDaftar.setText("Daftar");
        AksiDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AksiDaftarActionPerformed(evt);
            }
        });

        AksiAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AksiAdmin.setText("Admin");
        AksiAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AksiAdminActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("*Belum punya Akun ?");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Administrator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(TitlePelanggan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AksiAdmin)
                        .addComponent(jLabel1)
                        .addComponent(TitlePassword)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TitleNama)
                                .addComponent(AksiDaftar))
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(AksiMasuk)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AksiKeluar))
                                .addComponent(masukUser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masukPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(268, 268, 268)))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(TitlePelanggan)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleNama)
                    .addComponent(masukUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitlePassword)
                    .addComponent(masukPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AksiDaftar)
                    .addComponent(AksiMasuk)
                    .addComponent(AksiKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AksiAdmin)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void masukUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukUserActionPerformed
        System.exit(0);
    }//GEN-LAST:event_masukUserActionPerformed

    private void AksiMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AksiMasukActionPerformed
        masukPelanggan();
    }//GEN-LAST:event_AksiMasukActionPerformed

    private void AksiDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AksiDaftarActionPerformed
        new DaftarPelanggan().show();
        this.dispose();
    }//GEN-LAST:event_AksiDaftarActionPerformed

    private void AksiAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AksiAdminActionPerformed
        new LoginAdmin().show();
        this.dispose();
    }//GEN-LAST:event_AksiAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AksiAdmin;
    private javax.swing.JButton AksiDaftar;
    private javax.swing.JButton AksiKeluar;
    private javax.swing.JButton AksiMasuk;
    private javax.swing.JLabel TitleNama;
    private javax.swing.JLabel TitlePassword;
    private javax.swing.JLabel TitlePelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField masukPassword;
    private javax.swing.JTextField masukUser;
    // End of variables declaration//GEN-END:variables
}

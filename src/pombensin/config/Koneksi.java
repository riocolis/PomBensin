/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pombensin.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nurcholis Rio
 */
public class Koneksi {
    Connection conn;
    Statement stmt;
    PreparedStatement prep;
    public ResultSet rs;
    
    String host="jdbc:mysql://localhost:3306/pombensin?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username="root";
    String password="";
    
    public Koneksi() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(host, username, password);
    }
    
    public void query(String sql) throws SQLException{
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
    }
    
    public PreparedStatement prepQuery(String sql) throws SQLException{
        prep = conn.prepareStatement(sql);
        return prep;
    }
    public void query2(String sql) throws SQLException{
        rs = stmt.executeQuery(sql);
    }
}

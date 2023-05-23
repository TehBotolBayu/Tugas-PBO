package tgspbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbtugas";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public db(){
        try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);  
            stmt = conn.createStatement();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void read() {
        String sql = "SELECT * FROM akun";

        try {
            
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                    String id = rs.getString("id");
                    String nama = rs.getString("nama");
                    String e = rs.getString("email");
                    String password = rs.getString("password");
                    akun user = new akun(id, nama, e, password);
                    TgsPBO.user.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void auth(String email) {
        String sql = "SELECT * FROM akun WHERE email = '%s'";
        sql = String.format(sql, email);

        try {
            
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                    String id = rs.getString("id");
                    String nama = rs.getString("nama");
                    String e = rs.getString("email");
                    String password = rs.getString("password");
                    akun user = new akun(id, nama, e, password);
                    TgsPBO.user.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertakun(String nama, String email, String password){
        String sql = "INSERT INTO akun(nama, email, password) VALUE('%s', '%s', '%s')";
        sql = String.format(sql, nama, email, password);
        try {
            stmt.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    /*
    
    public static void updateDompet(String nama, String jenis, String idmatauang, int saldo, String iduser, String id){
        String sql = "UPDATE tbdompet SET nama='%s', jenis='%s', idmatauang='%s', saldo='%s' WHERE id='%s'";
        sql = String.format(sql, nama, jenis, idmatauang, saldo, id);  
//        String sql = "UPDATE tbdompet SET nama='%s' WHERE id='%s'";
//        sql = String.format(sql, nama, id );  
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void deleteDompet(String id){
        String sql = String.format("DELETE FROM tbdompet WHERE id='%s'", id);
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  */  

    
    
}

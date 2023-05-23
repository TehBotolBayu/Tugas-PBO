/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgspbo;

/**
 *
 * @author acer
 */
public class akun {
    private String id;
    private String nama;
    private String email;
    private String pw;

    public akun(String id, String nama, String email, String pw) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }
    
    
}

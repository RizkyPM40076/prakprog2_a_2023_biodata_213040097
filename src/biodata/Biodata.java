/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biodata;

/**
 *
 * @author LENOVO
 */
public class Biodata {

    private String id;           
    private String nama;        
    private String noTelepon;   
    private String jenisKelamin; 
    private String alamat;       
    
    // Set nilai dari id dengan parameter id
    public void setId(String id) {
        this.id = id;
    }
    
    // Dapatkan nilai dari id
    public String getId() {
        return this.id;
    } 
    
    // Set nilai dari nama dengan parameter nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // Dapatkan nilai dari nama
    public String getNama() {
        return this.nama;
    } 
    
    // Set nilai dari noTelepon dengan parameter noTelepon
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    
    // Dapatkan nilai dari noTelepon
    public String getNoTelepon() {
        return this.noTelepon;
    }
    
    // Set nilai dari jenisKelamin dengan parameter jenisKelamin
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    // Dapatkan nilai dari jenisKelamin
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    
    // Set nilai dari alamat dengan parameter alamat
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    // Dapatkan nilai dari alamat
    public String getAlamat() {
        return this.alamat;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author lenovo
 */
import java.sql.Connection;    // Mengimpor kelas Connection dari paket java.sql untuk mengelola koneksi JDBC
import java.sql.DriverManager; // Mengimpor kelas DriverManager dari paket java.sql untuk manajemen pemandu dalam JDBC

public class MySqlConnection {
    private final String DB_URL = "jdbc:mysql://localhost:3306/biodata"; // Mendefinisikan URL Database
    private final String DB_USER = "root";                                      // Mendefinisikan Username Database
    private final String DB_PASS = "";                                          // Mendefinisikan Password Database

    private static MySqlConnection instance;

    // Metode untuk mendapatkan instance MySqlConnection
    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance; 
    }

    // Metode untuk mendapatkan koneksi ke database
    public Connection getConnection() {
        Connection connection = null; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Memuat driver JDBC MySQL
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return connection; 
    }
}
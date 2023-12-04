/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import biodata.Biodata;
/**
 *
 * @author LENOVO
 */
// class untuk mengatur CRUD dari kelas biodata
public class BiodataDao {
    public int insert(Biodata biodata) {
        int result = -1;

        //untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "Insert into biodata(id, nama, no_telepon, jenis_kelamin, alamat) values (?, ?, ?, ?, ?)");

            // Set nilai dari parameter yang ada di query
            statement.setString(1, biodata.getId()); 
            statement.setString(2, biodata.getNama()); 
            statement.setString(3, biodata.getNoTelepon()); 
            statement.setString(4, biodata.getJenisKelamin()); 
            statement.setString(5, biodata.getAlamat()); 
            
            // Eksekusi query
            result = statement.executeUpdate();

            System.out.println("Insert data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Fungsi untuk mengubah data di database
    public int update(Biodata biodata) {
        int result = -1;

        //untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "update biodata set nama = ?, no_telepon = ?, jenis_kelamin = ?, alamat = ? where id = ?");

            // Set nilai dari parameter yang ada di query
            statement.setString(1, biodata.getNama()); 
            statement.setString(2, biodata.getNoTelepon()); 
            statement.setString(3, biodata.getJenisKelamin()); 
            statement.setString(4, biodata.getAlamat()); 
            statement.setString(5, biodata.getId()); 

            // Eksekusi query
            result = statement.executeUpdate();

            // Print data yang diubah di database
            System.out.println("Update data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());

        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai result
        return result;
    }

    // Fungsi untuk menghapus data di database
    public int delete(Biodata biodata) {
        // Variable result untuk menyimpan nilai dari eksekusi query apakah berhasil atau tidak
        int result = -1;

        //untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");

            statement.setString(1, biodata.getId()); // id

            result = statement.executeUpdate();

            System.out.println("Delete data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Fungsi untuk mendapatkan semua data dari database
    public List<Biodata> findAll() {
        // Membuat list untuk menyimpan semua data
        List<Biodata> list = new ArrayList<>();

         //untuk membuat koneksi ke database
        try (
                // Membuat koneksi ke database
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {

            // Membuat ResultSet untuk menyimpan hasil dari eksekusi query
            try (ResultSet resultSet = statement.executeQuery("select * from biodata")) {
                while (resultSet.next()) {
                    Biodata biodata = new Biodata();

                    // Set nilai dari object biodata
                    biodata.setId(resultSet.getString("id")); 
                    biodata.setNama(resultSet.getString("nama")); 
                    biodata.setNoTelepon(resultSet.getString("no_telepon")); 
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin")); 
                    biodata.setAlamat(resultSet.getString("alamat")); 
                    // Menambahkan biodata ke list
                    list.add(biodata);
                }
            } catch (SQLException e) {
                // Print error jika terjadi error
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai list
        return list;
    }

    // Fungsi untuk mendapatkan data dari database berdasarkan column dan value
    public Biodata select(String column, String value) {
        // Membuat object biodata untuk menyimpan data
        Biodata biodata = new Biodata();

        //untuk membuat koneksi ke database
        try (
                // Membuat koneksi ke database
                Connection connection = MySqlConnection.getInstance().getConnection();
                
                Statement statement = connection.createStatement();
            ) {
            // Membuat ResultSet untuk menyimpan hasil dari eksekusi query
            try (ResultSet resultSet = statement.executeQuery("select * from biodata where " + column+ " = '" + value + "'");) {
                while (resultSet.next()) {
                    biodata.setId(resultSet.getString("id")); 
                    biodata.setNama(resultSet.getString("nama")); 
                    biodata.setNoTelepon(resultSet.getString("no_telepon")); 
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin")); 
                    biodata.setAlamat(resultSet.getString("alamat")); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return biodata;
    }
}

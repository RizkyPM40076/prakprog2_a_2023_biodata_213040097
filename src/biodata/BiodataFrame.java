/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import javax.swing.*;
import java.util.*;
import dao.BiodataDao;
import actionlistener.HapusActionListener;
import actionlistener.SimpanActionListener;
import actionlistener.UbahActionListener;
import actionlistener.CloseWindowActionListener;
import actionlistener.SaveToFileActionListener;
/**
 *
 * @author LENOVO
 */
public class BiodataFrame extends JFrame {
    private List<Biodata> biodataList;          
    private final JTextField textFieldNama;     
    private final JTextField textFieldHP;       
    private final JRadioButton jenisLaki;       
    private final JRadioButton jenisPerempuan;  
    private final JTextArea txtOutput;          
    private final ModelTable tableModel;        
    private final JTable table;                 
    private final JButton buttonSimpanUbah;     
    private final BiodataDao biodataDao;        

    public BiodataFrame(BiodataDao biodataDao) {
        this.biodataDao = biodataDao;
        this.biodataList = this.biodataDao.findAll();
        
        // Instansiasi JLabel dengan nama labelNama yang diberikan nilai "Form Biodata:"
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        labelHeader.setBounds(0, 20, 350, 10);

        // Instansiasi JLabel dengan nama labelNama yang diberikan nilai "Nama:"
        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        // Instansiasi JTextField dengan nama textFieldNama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Instansiasi JLabel dengan nama labelTelepon yang diberikan nilai "Nomor
        JLabel labelHP = new JLabel("Nomor HP: ");
        labelHP.setBounds(15, 100, 350, 10);

        // Instansiasi JTextField dengan nama textFieldTelepon
        textFieldHP = new JTextField();
        textFieldHP.setBounds(15, 120, 350, 30);

        // Instansiasi JLabel dengan nama labelInput yang diberikan nilai "Jenis
        // Kelamin:"
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 160, 350, 10);

        // Instansiasi JRadioButton dengan nama radioButton1 dengan pesan "Laki-Laki"
        // dan selected dengan nilai true
        jenisLaki = new JRadioButton("Laki-Laki", true);
        jenisLaki.setBounds(15, 180, 350, 30);

        jenisPerempuan = new JRadioButton("Perempuan");
        jenisPerempuan.setBounds(15, 210, 350, 30);

        // Instansiasi ButtonGroup dengan nama bg
        ButtonGroup bg = new ButtonGroup();
        bg.add(jenisLaki);
        bg.add(jenisPerempuan);

        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 240, 350, 30);

        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 270, 350, 100);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 380, 100, 40);

        JButton buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(125, 380, 100, 40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(235, 380, 100, 40);

        buttonSimpanUbah = new JButton("Simpan Ubah");
        buttonSimpanUbah.setBounds(345, 380, 150, 40);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(15, 650, 100, 40);

        refresh.addActionListener(e -> {
            refreshBiodataTable();
        });

        // Instansiasi JTable dengan nama table
        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,
                440,
                500,
                200);

        tableModel = new ModelTable(biodataList);
        table.setModel(tableModel);

        JButton buttonFile = new JButton("Simpan ke File");
        buttonFile.setBounds(345, 650, 150, 40);

        // Instansiasi SimpanActionListener dengan nama simpanListener
        SimpanActionListener simpanListener = new SimpanActionListener(this,
        biodataDao);
        // Menambahkan action listener ke button
        button.addActionListener(simpanListener);

        // Instansiasi UbahActionListener dengan nama ubahListener
        UbahActionListener ubahListener = new UbahActionListener(this,
                biodataDao);
        // Menambahkan action listener ke buttonUbah
        buttonUbah.addActionListener(ubahListener);

        // Instansiasi HapusActionListener dengan nama hapusListener
        HapusActionListener hapusListener = new HapusActionListener(this,
                biodataDao);
        // Menambahkan action listener ke buttonHapus
        buttonHapus.addActionListener(hapusListener);

        // Instansiasi SaveToFileActionListener dengan nama saveToFileListener
        SaveToFileActionListener saveToFileListener = new SaveToFileActionListener(this, biodataList);
        // Menambahkan action listener ke button file
        buttonFile.addActionListener(saveToFileListener);

        // Instansiasi CloseWindowActionListener dengan nama closeWindowListener
        CloseWindowActionListener closeWindowListener = new CloseWindowActionListener(this);
        // Menambahkan window listener ke frame
        this.addWindowListener(closeWindowListener);

        // Menambahkan objek labelHeader ke frame
        this.add(labelHeader);
        // Menambahkan objek labelNama ke frame
        this.add(labelNama);
        // Menambahkan objek textFieldNama ke frame
        this.add(textFieldNama);
        // Menambahkan objek labelTelepon ke frame
        this.add(labelHP);
        // Menambahkan objek textFieldTelepon ke frame
        this.add(textFieldHP);
        // Menambahkan objek labelRadio ke frame
        this.add(labelRadio);
        // Menambahkan objek radioButton1 ke frame
        this.add(jenisLaki);
        // Menambahkan objek radioButton2 ke frame
        this.add(jenisPerempuan);
        // Menambahkan objek checkBox ke frame
        this.add(labelAlamat);
        // Menambahkan objek txtOutput ke frame
        this.add(txtOutput);
        // Menambahkan objek button ke frame
        this.add(button);
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonUbah);
        // Menambahkan objek buttonHapus ke frame
        this.add(buttonHapus);
        // Menambahkan objek buttonFile ke frame
        this.add(buttonFile);
        // Menambahkan objek scrollableTable ke frame
        this.add(scrollableTable);
        this.add(refresh);
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonSimpanUbah);

        this.setSize(550, 1000);
        this.setLayout(null);
    }

    // Method untuk mendapatkan nilai dari textFieldNama
    public String getNama() {
        return textFieldNama.getText();
    }

    // Method untuk mendapatkan textFieldNama
    public JTextField getNamaTextField() {
        return textFieldNama;
    }

    // Method untuk mendapatkan nilai dari textFieldTelepon
    public String getNoTelepon() {
        return textFieldHP.getText();
    }

    // Method untuk mendapatkan textFieldTelepon
    public JTextField getNoTeleponTextField() {
        return textFieldHP;
    }

    // Method untuk mendapatkan nilai dari radioButton1
    public JRadioButton getJenisLaki() {
        return jenisLaki;
    }

    // Method untuk mendapatkan nilai dari radioButton2
    public JRadioButton getJenisPerempuan() {
        return jenisPerempuan;
    }

    // Method untuk mendapatkan nilai dari txtOutput
    public String getAlamat() {
        return txtOutput.getText();
    }

    // Method untuk mendapatkan txtOutput
    public JTextArea getAlamatTextField() {
        return txtOutput;
    }

    // Method untuk mendapatkan tableModel
    public ModelTable getTableModel() {
        return this.tableModel;
    }

    // Method untuk mendapatkan table
    public JTable getTable() {
        return this.table;
    }

    // Method untuk mendapatkan buttonSimpanUbah
    public JButton getButtonSimpanUbah() {
        return this.buttonSimpanUbah;
    }

    // Method untuk menambahkan biodata ke tableModel
    public void addBiodata(Biodata biodata) {
        tableModel.add(biodata);
        textFieldNama.setText("");
        textFieldHP.setText("");
        txtOutput.setText("");
    }

    // Method untuk mengubah biodata ke tableModel
    public void updateBiodata(Biodata biodata) {
        tableModel.update(biodata);
        textFieldNama.setText("");
        textFieldHP.setText("");
        txtOutput.setText("");
    }

    // Method untuk menghapus biodata ke tableModel
    public void deleteBiodata(Biodata biodata) {
        tableModel.delete(biodata);
    }

    public void refreshBiodataTable() {
        this.biodataList = this.biodataDao.findAll();
        this.getTable().setModel(new ModelTable(this.biodataList));

        System.out.println("Table refreshed: ");
        if (biodataList.isEmpty()) {
            System.out.println("Table is empty");
        } else {
            for (Biodata biodata : biodataList) {
                System.out.println(biodata.getNama() + " " + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
            }
        }
        System.out.println();
    }

    // Method untuk menampilkan alert ketika nama, telepon dan alamat kosong
    public void showAlertAllEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika nama kosong
    public void showAlertNameEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika telepon kosong
    public void showAlertTelephoneEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Telepon belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika alamat kosong
    public void showAlertAddressEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Alamat belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika data berhasil ditambahkan
    public void showAlertSuccess(String message) {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Method untuk menampilkan alert ketika data gagal ditambahkan
    public void showAlertFailed(String message) {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.ERROR_MESSAGE);
    }

    // Method untuk menampilkan konfirmasi
    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(BiodataFrame.this,
                "Apakah anda yakin ingin " + message + " data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }
    
}

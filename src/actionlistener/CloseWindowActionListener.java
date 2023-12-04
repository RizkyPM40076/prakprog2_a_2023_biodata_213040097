/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import biodata.BiodataFrame;
/**
 *
 * @author LENOVO
 */
public class CloseWindowActionListener implements WindowListener {
    private final BiodataFrame biodataFrame;

    // Constructor
	public CloseWindowActionListener(BiodataFrame biodataFrame) {
		this.biodataFrame = biodataFrame;
	}

	// Override method windowClosing dari WindowAdapter
	public void windowClosing(WindowEvent e) {
		// Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
		int confirmation = JOptionPane.showConfirmDialog(this.biodataFrame,
				"Apakah anda yakin ingin keluar ?\nSemua data yang belum disimpan, tidak akan tersimpan.",
				"Form Biodata",
				JOptionPane.YES_NO_OPTION);

		if (confirmation == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else {
			this.biodataFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

	public void windowOpened(WindowEvent e) {
	}
        
	public void windowClosed(WindowEvent e) {
	}
        
	public void windowIconified(WindowEvent e) {
	}
        
	public void windowDeiconified(WindowEvent e) {
	}
        
	public void windowActivated(WindowEvent e) {
	}
        
	public void windowDeactivated(WindowEvent e) {
	}
}

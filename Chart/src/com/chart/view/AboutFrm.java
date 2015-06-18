package com.chart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;

public class AboutFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6191427806587924168L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrm frame = new AboutFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutFrm() {
		setTitle("关于");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		MyPanel2 panel = new MyPanel2();
		panel.setBounds(20, 16, 388, 221);
		getContentPane().add(panel);

	}

}

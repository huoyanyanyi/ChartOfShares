package com.chart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class PaquFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaquFrm frame = new PaquFrm();
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
	public PaquFrm() {
		setBounds(100, 100, 450, 300);

	}

}

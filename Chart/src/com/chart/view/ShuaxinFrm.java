package com.chart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ShuaxinFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShuaxinFrm frame = new ShuaxinFrm();
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
	public ShuaxinFrm() {
		setBounds(100, 100, 450, 300);

	}

}

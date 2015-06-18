package com.chart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AboutFrm extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}

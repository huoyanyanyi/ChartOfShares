package com.chart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class DataFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3282258914695899083L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataFrm frame = new DataFrm();
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
	public DataFrm() {
		setBounds(100, 100, 450, 300);

	}

}

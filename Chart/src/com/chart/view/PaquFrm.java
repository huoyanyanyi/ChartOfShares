package com.chart.view;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

public class PaquFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3635240437736341491L;
	private JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaquFrm frame = new PaquFrm();
					frame.setVisible(true);
					}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaquFrm() {
		setClosable(true);
		setTitle("获取股票数据");
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);		
		MyPanel3 panel = new MyPanel3();
		panel.setBounds(20, 16, 388, 221);
		getContentPane().add(panel);
		
		

	}

}

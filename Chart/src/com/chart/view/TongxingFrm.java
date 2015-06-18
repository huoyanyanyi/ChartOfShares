package com.chart.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Label;
import java.awt.Color;

public class TongxingFrm extends JInternalFrame {
	private String code;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3116011406453618969L;
	//private static MyPanel panel;
//	private static int MouseX;
//	private static int MouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TongxingFrm frame = new TongxingFrm();
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
	public TongxingFrm() {
		setClosable(true);
		setTitle("图形化显示");
		setIconifiable(true);
		setBounds(100, 100, 860, 600);
		getContentPane().setLayout(null);
		
		Label label = new Label("");
		label.setBackground(Color.RED);
		label.setBounds(12, 509, 814, 40);
		getContentPane().add(label);
		getContentPane().add(label);
		MyPanel panel = new MyPanel();
		panel.setBounds(12, 12, 814, 490);
		getContentPane().add(panel);
	}
	public TongxingFrm(String code){
		super();
		setClosable(true);
		setTitle("图形化显示");
		setIconifiable(true);
		setBounds(100, 100, 860, 600);
		getContentPane().setLayout(null);
		
		Label label = new Label("");
		label.setBackground(Color.RED);
		label.setBounds(6, 509, 820, 40);
		getContentPane().add(label);
		MyPanel panel = new MyPanel();
		getContentPane().add(panel);
		
		this.setCode(code);
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}
}

package com.chart.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;

public class TongxingFrm extends JInternalFrame {

	private static final long serialVersionUID = 3116011406453618969L;
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
		setTitle("图形化显示"+"("+MainView.code+")");
		setIconifiable(true);
		setBounds(100, 100, 860, 600);
		getContentPane().setLayout(null);
		
		Label label = new Label("         "+"code = "+MainView.code +"   "+"标注：黄色为五日均线，绿色为十日均线，橙色为二十日均线");
		label.setBounds(12, 509, 814, 40);
		
		
		
		getContentPane().add(label);
		getContentPane().add(label);
		MyPanel panel = new MyPanel();
		panel.setBounds(12, 12, 814, 490);
		getContentPane().add(panel);
	}



}

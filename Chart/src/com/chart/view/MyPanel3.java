package com.chart.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MyPanel3 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1781355070270302619L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		this.setBackground(new Color(60,60,60));
		
		g2d.setColor(Color.RED);
		g2d.drawPolygon(new int[]{45,23,56,89,112},new int[]{10,3,115,54,43}, 5);
		g2d.setColor(Color.BLUE);
		g2d.drawPolygon(new int[]{102,23,145,89,122},new int[]{180,146,35,54,43}, 3);
		g2d.setColor(Color.GREEN);
		g2d.drawPolygon(new int[]{105,23,35,89,10},new int[]{180,76,35,150,43}, 4);
		g2d.setColor(Color.orange);
		g2d.setFont(new Font("Arial",Font.BOLD,30));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i =0;i<10;i++){
			for(int j = 0;j<10000;j++)
				System.out.println("");
		}
		g2d.drawString("获取完成", 150, 120);
	}

	@Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		super.paintChildren(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
		super.paintBorder(g);
	}
}

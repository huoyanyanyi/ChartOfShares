package com.chart.view;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JPanel;

import com.chart.dao.DataDao;
import com.chart.modle.Data;
import com.chart.modle.Share;

public class MyPanel extends JPanel {
	private ArrayList<Data> datas;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8295940280239594066L;
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		DataDao dataDao = new DataDao();
		try {
//			datas = dataDao.initDatas(MainView.code);
			datas = dataDao.initDatas("000875");
			java.util.Iterator<Data> it = datas.iterator();	
			int numT = 0;
			g.drawLine((60-25)+5,450,(60-25)+5,440);
			while (it.hasNext()) {
				numT++;
//				Vector<String> shareVector = new Vector<String>();
				
				
				Data data = (Data)it.next();	
				Date date = data.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateT = sdf.format(data.getDate());
				double open = data.getOpen();
				double close = data.getClose();
				int Close = (int)(close*35)-700;
				int Open = (int)(open*35)-700;
				double high = data.getHigh();
				int High = (int)(high*35)-700;
				double low = data.getLow();
				int Low = (int)(low*35)-700;
				double lengthOfHL = data.getLengthOfHL();
				int LengthOfHL = (int) (lengthOfHL*40);
				double lengthOfOP = data.getLengthOfOP();
				int LengthOfOP = (int) (lengthOfOP*40);
				
				double volume = data.getVolume();	
				
				int Volume = (int)volume/100000*2;
//				System.out.println(lengthOfHL+" "+lengthOfOP+" "+yingyang+" "+volume);\
				System.out.println(Open);
				System.out.println(LengthOfHL);
				System.out.println(LengthOfOP);

				
				if (open>=close){
					g.setColor(Color.RED);
					g.fillRect((60+(numT-1)*25), Open, 10, LengthOfOP);
					
					g.fillRect((60+(numT-1)*25), 420-Volume, 10, Volume);
					
					g.drawLine((60+(numT-1)*25)+5,Low, 60+(numT-1)*25+5, High);
					g.setColor(Color.BLACK);
					if(numT%5 == 0){
						g.drawString(dateT,35+(numT-1)*25-5,470);
						g.drawLine((60+(numT-1)*25)+5,450,(60+(numT-1)*25)+5,440);
					}			
					
					if(LengthOfOP==0){
						g.setColor(Color.RED);
						g.fillRect((60+(numT-1)*25), Open, 10, 1);
					}
				}
				else{
					g.setColor(Color.BLUE);
					g.fillRect((60+(numT-1)*25), Close, 10, LengthOfOP);
					g.fillRect((60+(numT-1)*25), 420-Volume, 10, Volume);
					g.drawLine((60+(numT-1)*25)+5,Low, 60+(numT-1)*25+5, High);
					g.setColor(Color.BLACK);
					if(numT%5 == 0){
						g.drawString(dateT,35+(numT-1)*25-5,470);
						g.drawLine((60+(numT-1)*25)+5,450,(60+(numT-1)*25)+5,440);
					}
					if(LengthOfOP==0){
						g.setColor(Color.RED);
						g.fillRect((60+(numT-1)*25), Open, 10, 1);
					}
	
				}
				
				
//				g.fillRect(Open, y, LengthOf, height);
				
				if(numT == 28){
					
					//g.fillRect(44, 300, 10, 100);

					break;
				}
			}
//			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		finally{
			g.setColor(Color.BLACK);
			g.drawLine(24, 450, 24, 24);
			g.drawLine(24, 450, 780, 450);
		//	g.drawRect(0, 0, 100, 100);
		}
	

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

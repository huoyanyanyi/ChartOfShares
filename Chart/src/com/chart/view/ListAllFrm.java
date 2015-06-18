package com.chart.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.chart.dao.ShareDao;
import com.chart.modle.Data;
import com.chart.modle.Share;

public class ListAllFrm extends JInternalFrame {
	
	private static final long serialVersionUID = -6757548628717976293L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAllFrm frame = new ListAllFrm();
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
	public ListAllFrm() {
		setBounds(100, 100, 450, 300);
		setClosable(true);
		setTitle("选择股票");
		setIconifiable(true);
		setBounds(100, 100, 860, 600);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), 
				"\u4ECA\u65E5\u80A1\u7968", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(28, 18, 782, 515);
		getContentPane().add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 23, 746, 470);
		panel.add(scrollPane);
		
		ShareDao shareDao = new ShareDao();
		ArrayList<Share> shares = null;
		try {
			shares = shareDao.initALLDatas();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Code");
		defaultTableModel.addColumn("Open");
		defaultTableModel.addColumn("High");
		defaultTableModel.addColumn("Low");
		
		java.util.Iterator<Share> it = shares.iterator();	
		while (it.hasNext()) {
			Vector<String> shareVector = new Vector<String>();
			Share share = (Share)it.next();
			Data today_data = share.getToday_Data();
			shareVector.add(today_data.getCode());
			String Open = ""+today_data.getOpen();
			shareVector.add(Open);
			String Close = ""+ today_data.getClose();
			shareVector.add(Close);
			String High = ""+today_data.getHigh();
			shareVector.add(High);
			String Low = "" + today_data.getLow();
			shareVector.add(Low);			//收盘价
			defaultTableModel.addRow(shareVector);		
		}
		JTable table = new JTable(defaultTableModel){
			   /**
			 * 
			 */
			private static final long serialVersionUID = 1684561926296051242L;

			public boolean isCellEditable(int row, int column) { 
				    return false;
				   }
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setPreferredScrollableViewportSize(new Dimension(550, 30));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				MainView.code = (String) table.getValueAt(row, 0);
				System.out.println(MainView.code);
			}
		});
	}
}

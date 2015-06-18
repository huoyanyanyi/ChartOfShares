package com.chart.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.chart.dao.DataDao;
import com.chart.modle.Data;

public class DataFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3282258914695899083L;
	private ArrayList<Data> datas;
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
		setClosable(true);
		setTitle("股票"+MainView.code+"详情");
		setIconifiable(true);
		setBounds(100, 100, 860, 600);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u80A1\u7968\u5177\u4F53\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(28, 18, 782, 515);
		getContentPane().add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 23, 746, 470);
		panel.add(scrollPane);
		
		
		DataDao dataDao = new DataDao(); 
		try {
			datas = dataDao.initDatas(MainView.code);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Date");
		defaultTableModel.addColumn("Open");
		defaultTableModel.addColumn("Close");
		defaultTableModel.addColumn("High");
		defaultTableModel.addColumn("Low");
		defaultTableModel.addColumn("volume");
		defaultTableModel.addColumn("price_change");
		defaultTableModel.addColumn("p_change");
		defaultTableModel.addColumn("turnover");
		
		java.util.Iterator<Data> it = datas.iterator();	
		while (it.hasNext()) {
			Vector<String> dataVector = new Vector<String>();
			Data data = (Data)it.next();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dataVector.add(sdf.format(data.getDate()));
			dataVector.add(""+data.getOpen());
			dataVector.add(""+data.getClose());
			dataVector.add(""+data.getHigh());
			dataVector.add(""+data.getLow());
			dataVector.add(""+data.getVolume());
			dataVector.add(""+data.getPrice_change());
			dataVector.add(""+data.getP_change());
			dataVector.add(""+data.getTurnover());
			defaultTableModel.addRow(dataVector);		
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
		
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int row = table.getSelectedRow();
//				MainView.code = (String) table.getValueAt(row, 0);
//				System.out.println(MainView.code);
//			}
//		});

	}

}

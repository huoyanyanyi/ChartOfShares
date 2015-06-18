package com.chart.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class MainView extends JFrame{
	private static final long serialVersionUID = 5161973908482185238L;
	private JPanel contentPane;
	private JDesktopPane table;
	public static String code;
	public static boolean lsa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lsa = false;
					MainView frame = new MainView();
					frame.setVisible(true);
					
				//	frame.contentPane.addMouseMotionListener(new myMouseListener());
											
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public MainView() {		
		setResizable(false);
		setTitle("股票分析系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		//this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1049, 60);
		contentPane.add(menuBar);
		menuBar.setBackground(Color.GRAY);
		JButton exit = new JButton();
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				/*
				 * 0 yes 1 no 2 cancel
				 */
				// System.out.print(result);
				if (result == 0)
					MainView.this.dispose();
				// else
				// System.exit(1);
			}
		});
		exit.setIcon(new ImageIcon("icons/exit.png"));
		menuBar.add(exit);
		JButton paqu = new JButton();
		paqu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaquFrm paquFrm = new PaquFrm();	
				paquFrm.setLocation(120, 120);
				paquFrm.toFront();
				table.add(paquFrm);
				paquFrm.setVisible(true);
			}
		});
		paqu.setIcon(new ImageIcon("icons/network.png"));
		menuBar.add(paqu);
		
		
		
		
		
		JButton home = new JButton();
		home.setIcon(new ImageIcon("icons/home.png"));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lsa == false){
					lsa = true;
					ListAllFrm listAllFrm = new ListAllFrm();
					listAllFrm.setLocation(10, 10);
					listAllFrm.toFront();
					table.add(listAllFrm);
					listAllFrm.setVisible(true);
					listAllFrm.addInternalFrameListener(new InternalFrameListener() {
						
						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void internalFrameIconified(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void internalFrameDeiconified(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void internalFrameClosing(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							lsa = false;
						}
						
						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							lsa = false;
						}
						
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					
				}else{
					JOptionPane.showMessageDialog(null, "已经打开了所有股票信息窗口", null,
							JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		menuBar.add(home);
		
		JButton jbtuxing = new JButton();	
		jbtuxing.setIcon(new ImageIcon("icons/xuxian.png"));
		jbtuxing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(code != null){
				TongxingFrm tuxing = new TongxingFrm();	
				tuxing.setLocation(10, 10);
				tuxing.toFront();
				table.add(tuxing);
				tuxing.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "先选择具体的一只股票", null,
							JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
		menuBar.add(jbtuxing);

//		JButton shezhi = new JButton();
//		shezhi.setIcon(new ImageIcon("icons/reference.png"));
//		menuBar.add(shezhi);
		
//		JButton shuaxin = new JButton();
//		shuaxin.setIcon(new ImageIcon("icons/refrush.png"));
//		menuBar.add(shuaxin);
//		
//		JButton search = new JButton();
//		search.setIcon(new ImageIcon("icons/search.png"));
//		menuBar.add(search);
		
//		JButton shanxing = new JButton();
//		shanxing.setIcon(new ImageIcon("icons/shanxing.png"));
//		menuBar.add(shanxing);
		
		JButton data = new JButton();
		data.setIcon(new ImageIcon("icons/data.png"));
		data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(code != null){
					DataFrm dataFrm = new DataFrm();	
					dataFrm.setLocation(10, 10);
					dataFrm.toFront();
					table.add(dataFrm);
					dataFrm.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "先选择具体的一只股票", null,
							JOptionPane.DEFAULT_OPTION);
				}
				
			}
		});
		menuBar.add(data);
		
//		JButton zhuzhuang = new JButton();
//		zhuzhuang.setIcon(new ImageIcon("icons/zhuzhuang.png"));
//		menuBar.add(zhuzhuang);
		
		JButton about = new JButton();
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutFrm aboutFrm = new AboutFrm();	
				aboutFrm.setLocation(120, 120);
				aboutFrm.toFront();
				table.add(aboutFrm);
				aboutFrm.setVisible(true);
				
			}
		});
		about.setIcon(new ImageIcon("icons/info.png"));
		menuBar.add(about);	
		
		
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(0, 60, 1049, 618);
		contentPane.add(table);
	}
}

package com.chart.modle;

import java.util.ArrayList;
import java.util.Date;

public class Shares {
	private Date date;
	private ArrayList<Share> Shares;
	
	public Shares() {

	}
	
	public Shares(Date date, ArrayList<Share> shares) {
		super();
		this.date = date;
		Shares = shares;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Share> getShares() {
		return Shares;
	}
	public void setShares(ArrayList<Share> shares) {
		Shares = shares;
	}
	
	
}

package com.chart.modle;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.chart.dao.DataDao;

public class Share {
	private String code;
	private Data today_Data;
	private ArrayList<Data> datas;

	public Share() {
	}

	public Share(String code, Data today_Data) {
		super();
		this.code = code;
		this.today_Data = today_Data;
	}
	
	public Share(String code, Data today_Data, ArrayList<Data> datas) {
		super();
		this.code = code;
		this.today_Data = today_Data;
		this.datas = datas;
	}
	public Data getToday_Data() {
		return today_Data;
	}
	public void setToday_Data(Data today_Data) {
		this.today_Data = today_Data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<Data> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<Data> datas) {
		this.datas = datas;
	}
	
	public static void main(String[] args) {
		DataDao dataDao = new DataDao();	
		try {
			dataDao.initDatas("000875");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

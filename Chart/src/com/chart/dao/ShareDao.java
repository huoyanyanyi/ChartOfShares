package com.chart.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

import com.chart.modle.Data;
import com.chart.modle.Share;

public class ShareDao {
	
//	,code,open,high,low,close
	private BufferedReader br;
	
	public ArrayList<Share> initALLDatas() throws IOException, ParseException{
		ArrayList<Share> shares = new ArrayList<Share>();
		br = new BufferedReader(new InputStreamReader(
				new FileInputStream("zong.csv")));
		String Code;				//股票代码
		double open;				//开盘价
		double high;				//最高价
		double low;
		double close;				//收盘价
		String line;
		line = br.readLine();
		while ( (line = br.readLine()) != null ) {
			Share share = new Share();
			Data data = new Data();
			String[] info = line.split(",");
			Code = info[1].trim();								//股票代码
			data.setCode(Code);
			open = Double.parseDouble(info[2].trim());				//开盘价
			data.setOpen(open);
			high = Double.parseDouble(info[3].trim());				//最高价
			data.setHigh(high);
			low = Double.parseDouble(info[3].trim());				//最高价
			data.setLow(low);
			close = Double.parseDouble(info[4].trim());				//收盘价
			data.setClose(close);
			share.setToday_Data(data);
			shares.add(share);
		}	
		return shares;
	}
	public static void main(String[] args) {
		ShareDao sharedao = new ShareDao();
		try {
			ArrayList<Share> shares = sharedao.initALLDatas();
			java.util.Iterator<Share> it = shares.iterator();
			while (it.hasNext()) {
				Share share = (Share)it.next();
				Data today_data = share.getToday_Data();
				System.out.println(today_data.getCode()+" "+today_data.getHigh());
				
			}
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

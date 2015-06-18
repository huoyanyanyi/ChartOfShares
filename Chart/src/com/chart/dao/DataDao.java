package com.chart.dao;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.chart.modle.Data;

public class DataDao {
private BufferedReader br;

	public ArrayList<Data> initDatas(String code) throws IOException, ParseException{
		ArrayList<Data> datas = new ArrayList<Data>();
		br = new BufferedReader(new InputStreamReader(
				new FileInputStream(code+".csv")));
		String Code;				//股票代码
		Date date;				//交易日期
		double open;				//开盘价
		double high;				//最高价
		double close;				//收盘价
		double low;					//最低价
		double volume;				//成交量
		double price_change;		//价格变动
		double p_change;			//涨跌幅度
		double ma5;					//5日均价
		double ma10;				//10日均价
		double ma20;				//20日均价
		double v_ma5;				//5日均量
		double v_ma10;				//10日均量
		double v_ma20;				//20日均量
		double turnover;			//换手率	
		
		String line;
		line = br.readLine();
		int i = 0;
		while ( (line = br.readLine()) != null ) {
			i++;
			Data data = new Data();
			String[] info = line.split(",");
			Code = code;									//股票代码
			data.setCode(Code);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(info[0].trim());	
			data.setDate(date);										//交易日期
			open = Double.parseDouble(info[1].trim());				//开盘价
			data.setOpen(open);
			high = Double.parseDouble(info[2].trim());				//最高价
			data.setHigh(high);
			close = Double.parseDouble(info[3].trim());				//收盘价
			data.setClose(close);
			low = Double.parseDouble(info[4].trim());				//最低价
			data.setLow(low);
			volume = Double.parseDouble(info[5].trim());			//成交量
			data.setVolume(volume);
			price_change = Double.parseDouble(info[6].trim());		//价格变动
			data.setPrice_change(price_change);
			p_change = Double.parseDouble(info[7].trim());			//涨跌幅度
			data.setP_change(p_change);
			ma5 = Double.parseDouble(info[8].trim());				//5日均价
			data.setMa5(ma5);
			ma10 = Double.parseDouble(info[9].trim());				//10日均价
			data.setMa10(ma10);
			ma20 = Double.parseDouble(info[10].trim());				//20日均价
			data.setMa20(ma20);
			v_ma5 = Double.parseDouble(info[11].trim());			//5日均量
			data.setV_ma5(v_ma5);
			v_ma10 = Double.parseDouble(info[12].trim());			//10日均量
			data.setV_ma10(v_ma10);
			v_ma20 = Double.parseDouble(info[13].trim());			//20日均量
			data.setV_ma20(v_ma20);
			turnover = Double.parseDouble(info[14].trim());			//换手率	
			data.setTurnover(turnover);
			data.init();
			String dateT = sdf.format(data.getDate());
			System.out.println(data.getCode()+" "+dateT+" "+data.getOpen()+" "+data.getHigh()
					+" "+data.getClose()+" "+data.getLow()+" "+data.getVolume()			
					+" "+data.getPrice_change()+" "+data.getP_change()+" "+data.getMa5()
					+" "+data.getMa10()+" "+data.getMa20()+" "+data.getV_ma5()
					+" "+data.getV_ma10()+" "+data.getV_ma20()+" "+data.getTurnover()
					+" "+data.getLengthOfHL()+" "+data.getLengthOfHL());
			
			System.out.println("--"+i+"\n");
			
			datas.add(data);
		}
//			   //System.out.println(line); 
//			   String[] info = line.split(",");
//			   name = info[0].trim();
//			   age = info[1].trim();
//			   birthday = info[2].trim();
//			   System.out.print(name + "\t" + age + "\t" + birthday + "\n"); 
//			 }
		return datas;
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
package com.gtlk.action;

import java.io.File;  
import java.io.FileInputStream;
import java.io.InputStream; 

import java.util.ArrayList;  

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

import org.apache.poi.ss.usermodel.Cell;


import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.TrainMonitorInfo;
import com.gtlk.entity.TestMonitorInfo;
import com.gtlk.entity.TrainDelayInfo;
import com.gtlk.entity.TestDelayInfo;
import com.gtlk.service.prototype.TrainMonitorInfoService;
import com.gtlk.service.prototype.TestMonitorInfoService;
import com.gtlk.service.prototype.TrainDelayInfoService;
import com.gtlk.service.prototype.TestDelayInfoService;


@SuppressWarnings("serial")
public class UploadDataAction extends ActionSupport{
	private String dataType;
	private File attachFile;
	private String attachFileContentType;  
    private String attachFileFileName; 
	private TrainMonitorInfoService trainMonitorInfoService;
	private TestMonitorInfoService testMonitorInfoService;
	private TrainDelayInfoService trainDelayInfoService;
	private TestDelayInfoService testDelayInfoService;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public File getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(File attachFile) {
		this.attachFile = attachFile;
	}
	public String getAttachFileContentType() {
		return attachFileContentType;
	}
	public void setAttachFileContentType(String attachFileContentType) {
		this.attachFileContentType = attachFileContentType;
	}
	public String getAttachFileFileName() {
		return attachFileFileName;
	}
	public void setAttachFileFileName(String attachFileFileName) {
		this.attachFileFileName = attachFileFileName;
	}
	
	public TrainMonitorInfoService getTrainMonitorInfoService() {
		return trainMonitorInfoService;
	}
	public void setTrainMonitorInfoService(
			TrainMonitorInfoService trainMonitorInfoService) {
		this.trainMonitorInfoService = trainMonitorInfoService;
	}
	public TestMonitorInfoService getTestMonitorInfoService() {
		return testMonitorInfoService;
	}
	public void setTestMonitorInfoService(
			TestMonitorInfoService testMonitorInfoService) {
		this.testMonitorInfoService = testMonitorInfoService;
	}
	public TrainDelayInfoService getTrainDelayInfoService() {
		return trainDelayInfoService;
	}
	public void setTrainDelayInfoService(TrainDelayInfoService trainDelayInfoService) {
		this.trainDelayInfoService = trainDelayInfoService;
	}
	public TestDelayInfoService getTestDelayInfoService() {
		return testDelayInfoService;
	}
	public void setTestDelayInfoService(TestDelayInfoService testDelayInfoService) {
		this.testDelayInfoService = testDelayInfoService;
	}
	public String showUploadPage(){		
		return SUCCESS;
	}
	public String upload() throws Exception{
		if(dataType.equals("接口监测数据训练集")){
			saveTrainMonitorInfo(extractTrainMonitorInfo());
			return "trainmi";
		}
		else if(dataType.equals("接口监测数据测试集")){
			saveTestMonitorInfo(extractTestMonitorInfo());
			return "testmi";
		}
		else if(dataType.equals("线路时延数据训练集")){
			saveTrainDelayInfo(extractTrainDelayInfo());
			return "traindi";
		}
		else{
			saveTestDelayInfo(extractTestDelayInfo());
			return "testdi";
		}
	}

	/*从excel读取信息*/
	public ArrayList<TrainMonitorInfo> extractTrainMonitorInfo() throws Exception{
		String extension = attachFileFileName.lastIndexOf(".")==-1?"":attachFileFileName.substring(attachFileFileName.lastIndexOf(".")+1);
		System.out.println(extension);
		if("xls".equals(extension)){
		System.out.println(attachFileFileName);
		InputStream is = null;
		is = new FileInputStream(attachFile);
		HSSFWorkbook hwb = null;  
		try {  
        //得到上传的文件  
			hwb = new HSSFWorkbook(is);
		} catch (Exception e) {  
			throw new RuntimeException("获取文件失败！");  
		}  
		//获取一个表  
		HSSFSheet sheet = hwb.getSheetAt(0);
		//创建储存数据的集合  
		ArrayList<TrainMonitorInfo> t = new ArrayList<TrainMonitorInfo>();
		System.out.println(sheet.getLastRowNum());
		for (int i = 0; i <=sheet.getLastRowNum(); i++){  
			//for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++){
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
			//暂时储存一行数据
			ArrayList<String> data = new ArrayList<String>();
			for (int j = 0; j <row.getLastCellNum(); j++){ 
				HSSFCell cell = row.getCell(j);			
				cell.setCellType(Cell.CELL_TYPE_STRING);  
				data.add(cell.toString());			        
			}
			t.add(new TrainMonitorInfo(data.get(0),data.get(1),data.get(2),data.get(3),
            	data.get(4),data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),
            	data.get(10),data.get(11),data.get(12),data.get(13),data.get(14),
           		data.get(15),data.get(16),data.get(17),data.get(18),data.get(19),
            	data.get(20),data.get(21),data.get(22),data.get(23),data.get(24),
           		data.get(25),data.get(26),data.get(27),data.get(28),data.get(29),
           		data.get(30),data.get(31),data.get(32)));  
			data.clear();  
		}}
		is.close();
       return t;
       }
		else{
			System.out.println(attachFileFileName);
			InputStream is = null;
			is = new FileInputStream(attachFile);
			XSSFWorkbook xwb = null;  
			try {  
	        //得到上传的文件  
				xwb = new XSSFWorkbook(is);
			} catch (Exception e) {  
				throw new RuntimeException("获取文件失败！");  
			}  
			//获取一个表  
			XSSFSheet sheet = xwb.getSheetAt(0);
			System.out.println(xwb);
			//创建储存数据的集合  
			ArrayList<TrainMonitorInfo> t = new ArrayList<TrainMonitorInfo>();
			System.out.println(sheet.getPhysicalNumberOfRows());
			for (int i = 0; i <=sheet.getLastRowNum(); i++){  
			//for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++){
				XSSFRow row = sheet.getRow(i); 
				//暂时储存一行数据
				if (row != null) {
				ArrayList<String> data = new ArrayList<String>();
				for (int j = 0; j <row.getPhysicalNumberOfCells(); j++){   
					XSSFCell cell = row.getCell(j);			
					cell.setCellType(Cell.CELL_TYPE_STRING);  
					data.add(cell.toString());
					System.out.println("data "+j+" "+cell.toString());
				}
				
				t.add(new TrainMonitorInfo(data.get(0),data.get(1),data.get(2),data.get(3),
	            	data.get(4),data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),
	            	data.get(10),data.get(11),data.get(12),data.get(13),data.get(14),
	           		data.get(15),data.get(16),data.get(17),data.get(18),data.get(19),
	            	data.get(20),data.get(21),data.get(22),data.get(23),data.get(24),
	           		data.get(25),data.get(26),data.get(27),data.get(28),data.get(29),
	           		data.get(30),data.get(31),data.get(32)));  
				data.clear();  
			} }	
			is.close();
	       return t;				
		}
	}
	public ArrayList<TestMonitorInfo> extractTestMonitorInfo() throws Exception{
		String extension = attachFileFileName.lastIndexOf(".")==-1?"":attachFileFileName.substring(attachFileFileName.lastIndexOf(".")+1);
		System.out.println(extension);
		if("xls".equals(extension)){
		System.out.println(attachFileFileName);
		InputStream is = null;
		is = new FileInputStream(attachFile);
		HSSFWorkbook hwb = null;  
		try {  
        //得到上传的文件  
			hwb = new HSSFWorkbook(is);
		} catch (Exception e) {  
			throw new RuntimeException("获取文件失败！");  
		}  
		//获取一个表  
		HSSFSheet sheet = hwb.getSheetAt(0);
		//创建储存数据的集合  
		ArrayList<TestMonitorInfo> t = new ArrayList<TestMonitorInfo>();
		System.out.println(sheet.getLastRowNum());
		for (int i = 0; i <=sheet.getLastRowNum(); i++){  
			//for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++){
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
			//暂时储存一行数据
			ArrayList<String> data = new ArrayList<String>();
			for (int j = 0; j <row.getLastCellNum(); j++){ 
				HSSFCell cell = row.getCell(j);			
				cell.setCellType(Cell.CELL_TYPE_STRING);  
				data.add(cell.toString());			        
			}
			t.add(new TestMonitorInfo(data.get(0),data.get(1),data.get(2),data.get(3),
            	data.get(4),data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),
            	data.get(10),data.get(11),data.get(12),data.get(13),data.get(14),
           		data.get(15),data.get(16),data.get(17),data.get(18),data.get(19),
            	data.get(20),data.get(21),data.get(22),data.get(23),data.get(24),
           		data.get(25),data.get(26),data.get(27),data.get(28),data.get(29),
           		data.get(30),data.get(31)));  
			data.clear();  
		}}
		is.close();
       return t;
       }
		else{
			System.out.println(attachFileFileName);
			InputStream is = null;
			is = new FileInputStream(attachFile);
			XSSFWorkbook xwb = null;  
			try {  
	        //得到上传的文件  
				xwb = new XSSFWorkbook(is);
			} catch (Exception e) {  
				throw new RuntimeException("获取文件失败！");  
			}  
			//获取一个表  
			XSSFSheet sheet = xwb.getSheetAt(0);
			System.out.println(xwb);
			//创建储存数据的集合  
			ArrayList<TestMonitorInfo> t = new ArrayList<TestMonitorInfo>();
			System.out.println(sheet.getPhysicalNumberOfRows());
			for (int i = 0; i <=sheet.getLastRowNum(); i++){  
			//for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++){
				XSSFRow row = sheet.getRow(i); 
				//暂时储存一行数据
				if (row != null) {
				ArrayList<String> data = new ArrayList<String>();
				for (int j = 0; j <row.getPhysicalNumberOfCells(); j++){   
					XSSFCell cell = row.getCell(j);			
					cell.setCellType(Cell.CELL_TYPE_STRING);  
					data.add(cell.toString());
					System.out.println("data "+j+" "+cell.toString());
				}
				
				t.add(new TestMonitorInfo(data.get(0),data.get(1),data.get(2),data.get(3),
	            	data.get(4),data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),
	            	data.get(10),data.get(11),data.get(12),data.get(13),data.get(14),
	           		data.get(15),data.get(16),data.get(17),data.get(18),data.get(19),
	            	data.get(20),data.get(21),data.get(22),data.get(23),data.get(24),
	           		data.get(25),data.get(26),data.get(27),data.get(28),data.get(29),
	           		data.get(30),data.get(31)));  
				data.clear();  
			} }	
			is.close();
	       return t;				
		}
	}
	public ArrayList<TrainDelayInfo> extractTrainDelayInfo() throws Exception{
		String extension = attachFileFileName.lastIndexOf(".")==-1?"":attachFileFileName.substring(attachFileFileName.lastIndexOf(".")+1);
		System.out.println(extension);
		if("xls".equals(extension)){
		InputStream is = null;
		is = new FileInputStream(attachFile);
		//FileItem hh=new FileItem();
		HSSFWorkbook hwb = null;  
		try {  
        //得到上传的文件  
        //hwb = new HSSFWorkbook(item.getInputStream());  
			hwb = new HSSFWorkbook(is);
		} catch (Exception e) {  
			throw new RuntimeException("获取文件失败！");  
		}  
		//获取一个表  
		HSSFSheet sheet = hwb.getSheetAt(0);  
		//创建储存数据的集合  
		ArrayList<TrainDelayInfo> t = new ArrayList<TrainDelayInfo>();         
		//解析表中的数据，并将数据封装  
		for (int i = 1; i <= sheet.getLastRowNum(); i++){  
			HSSFRow row = sheet.getRow(i);  
			//暂时储存一行数据
			ArrayList<String> data1 = new ArrayList<String>();
			ArrayList<Double> data2 = new ArrayList<Double>();
			for (int j = 0; j < row.getLastCellNum(); j++){   
				HSSFCell cell = row.getCell(j);					  
		            // 判断当前Cell的Type  		  
		            switch (cell.getCellType()){  		  
		            // 如果当前Cell的Type为NUMERIC  		  
		            case HSSFCell.CELL_TYPE_NUMERIC:
		                  data2.add((Double)cell.getNumericCellValue());break;  		  		  
		            // 如果当前Cell的Type为STRIN  		  
		            case HSSFCell.CELL_TYPE_STRING:  		  
		               // 取得当前的Cell字符串  		  
		            	data1.add(cell.toString());break;  		  		  
		            }  		  
			}  
			t.add(new TrainDelayInfo(data1.get(0),data1.get(1),data2.get(0),data2.get(1),data2.get(2),
            	data2.get(3),data2.get(4),data2.get(5),data1.get(2)));  
			data1.clear();  
			data2.clear(); 
		}
		is.close();
       return t;
       }
		else{
			InputStream is = null;
			is = new FileInputStream(attachFile);
			//FileItem hh=new FileItem();
			XSSFWorkbook xwb = null;  
			try {  
	        //得到上传的文件  
	        //hwb = new HSSFWorkbook(item.getInputStream());  
				xwb = new XSSFWorkbook(is);
			} catch (Exception e) {  
				throw new RuntimeException("获取文件失败！");  
			}  
			//获取一个表  
			XSSFSheet sheet = xwb.getSheetAt(0);  
			//创建储存数据的集合  
			ArrayList<TrainDelayInfo> t = new ArrayList<TrainDelayInfo>();         
			//解析表中的数据，并将数据封装  
			for (int i = 1; i <= sheet.getLastRowNum(); i++){  
				XSSFRow row = sheet.getRow(i);  
				//暂时储存一行数据
				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<Double> data2 = new ArrayList<Double>();
				for (int j = 0; j < row.getLastCellNum(); j++){   
					XSSFCell cell = row.getCell(j); 					  
			            // 判断当前Cell的Type  		  
			            switch (cell.getCellType()){  		  
			            // 如果当前Cell的Type为NUMERIC  		  
			            case XSSFCell.CELL_TYPE_NUMERIC:
			                  data2.add((Double)cell.getNumericCellValue());break;  		  		  
			            // 如果当前Cell的Type为STRIN  		  
			            case XSSFCell.CELL_TYPE_STRING:  		  
			               // 取得当前的Cell字符串  		  
			            	data1.add(cell.toString());break;
			            default:break;
			            }
				}
				t.add(new TrainDelayInfo(data1.get(0),data1.get(1),data2.get(0),data2.get(1),data2.get(2),
		            	data2.get(3),data2.get(4),data2.get(5),data1.get(2)));  
				data1.clear();  
				data2.clear(); 
				}
			is.close();
	       return t;
		}
	}
	public ArrayList<TestDelayInfo> extractTestDelayInfo() throws Exception{
		String extension = attachFileFileName.lastIndexOf(".")==-1?"":attachFileFileName.substring(attachFileFileName.lastIndexOf(".")+1);
		System.out.println(extension);
		if("xls".equals(extension)){
		InputStream is = null;
		is = new FileInputStream(attachFile);
		//FileItem hh=new FileItem();
		HSSFWorkbook hwb = null;  
		try {  
        //得到上传的文件  
        //hwb = new HSSFWorkbook(item.getInputStream());  
			hwb = new HSSFWorkbook(is);
		} catch (Exception e) {  
			throw new RuntimeException("获取文件失败！");  
		}  
		//获取一个表  
		HSSFSheet sheet = hwb.getSheetAt(0);  
		//创建储存数据的集合  
		ArrayList<TestDelayInfo> t = new ArrayList<TestDelayInfo>();         
		//解析表中的数据，并将数据封装  
		for (int i = 1; i <= sheet.getLastRowNum(); i++){  
			HSSFRow row = sheet.getRow(i);  
			//暂时储存一行数据
			ArrayList<String> data1 = new ArrayList<String>();
			ArrayList<Double> data2 = new ArrayList<Double>();
			for (int j = 0; j < row.getLastCellNum(); j++){   
				HSSFCell cell = row.getCell(j);					  
		            // 判断当前Cell的Type  		  
		            switch (cell.getCellType()){  		  
		            // 如果当前Cell的Type为NUMERIC  		  
		            case HSSFCell.CELL_TYPE_NUMERIC:
		                  data2.add((Double)cell.getNumericCellValue());break;  		  		  
		            // 如果当前Cell的Type为STRIN  		  
		            case HSSFCell.CELL_TYPE_STRING:  		  
		               // 取得当前的Cell字符串  		  
		            	data1.add(cell.toString());break;  		  		  
		            }  		  
			}  
			t.add(new TestDelayInfo(data1.get(0),data1.get(1),data2.get(0),data2.get(1),data2.get(2),
            	data2.get(3),data2.get(4),data2.get(5)));  
			data1.clear();  
			data2.clear(); 
		}
		is.close();
       return t;
       }
		else{
			InputStream is = null;
			is = new FileInputStream(attachFile);
			//FileItem hh=new FileItem();
			XSSFWorkbook xwb = null;  
			try {  
	        //得到上传的文件  
	        //hwb = new HSSFWorkbook(item.getInputStream());  
				xwb = new XSSFWorkbook(is);
			} catch (Exception e) {  
				throw new RuntimeException("获取文件失败！");  
			}  
			//获取一个表  
			XSSFSheet sheet = xwb.getSheetAt(0);  
			//创建储存数据的集合  
			ArrayList<TestDelayInfo> t = new ArrayList<TestDelayInfo>();         
			//解析表中的数据，并将数据封装  
			for (int i = 1; i <= sheet.getLastRowNum(); i++){  
				XSSFRow row = sheet.getRow(i);  
				//暂时储存一行数据
				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<Double> data2 = new ArrayList<Double>();
				for (int j = 0; j < row.getLastCellNum(); j++){   
					XSSFCell cell = row.getCell(j); 					  
			            // 判断当前Cell的Type  		  
			            switch (cell.getCellType()){  		  
			            // 如果当前Cell的Type为NUMERIC  		  
			            case XSSFCell.CELL_TYPE_NUMERIC:
			                  data2.add((Double)cell.getNumericCellValue());break;  		  		  
			            // 如果当前Cell的Type为STRIN  		  
			            case XSSFCell.CELL_TYPE_STRING:  		  
			               // 取得当前的Cell字符串  		  
			            	data1.add(cell.toString());break;
			            default:break;
			            }
				}
				t.add(new TestDelayInfo(data1.get(0),data1.get(1),data2.get(0),data2.get(1),data2.get(2),
		            	data2.get(3),data2.get(4),data2.get(5)));  
				data1.clear();  
				data2.clear(); 
				}
			is.close();
	       return t;
		}
	}
	/*  service将entity存入数据库   */
	public void saveTrainMonitorInfo(ArrayList<TrainMonitorInfo> t){
		System.out.println(t.size());
		for(int i=0;i<t.size();i++)
			trainMonitorInfoService.save(t.get(i));
	}
	public void saveTestMonitorInfo(ArrayList<TestMonitorInfo> t){
		for(int i=0;i<t.size();i++)
			testMonitorInfoService.save(t.get(i));
	}
	public void saveTrainDelayInfo(ArrayList<TrainDelayInfo> t){
		for(int i=0;i<t.size();i++)
			trainDelayInfoService.save(t.get(i));
	}
	public void saveTestDelayInfo(ArrayList<TestDelayInfo> t){
		for(int i=0;i<t.size();i++)
			testDelayInfoService.save(t.get(i));
	}
	
}

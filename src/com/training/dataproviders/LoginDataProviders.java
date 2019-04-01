package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RealEstateBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputs1")
	public Object [][] getDBData1() {

		List<RealEstateBean> list = new ELearningDAO().getRealEstateUsers(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RealEstateBean temp : list){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getUserName();// Get the user name for User name text box	from DB			
			
			obj[1]=temp.getEmail();// Get the email for Email text box from DB	
			
			obj[2]=temp.getFirstName();// Get the First Name for First Name text box from DB	
			
			obj[3]=temp.getLastName();// Get the Last Name forLast Name text box from DB	
			
			obj[4]=temp.getWebsite();// Get the Web site for Web site text box from DB	
			
			obj[5]=temp.getPassword(); // Get the password for Password text box from DB	
			
			obj[6]=temp.getRole();// Get the Role for Role list box from DB	
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="./resources/RETC_Test_Data_Complex_TC.xlsx"; 
		String sheetname="RETD_009";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="./resources/RETC_Test_Data_Complex_TC.xlsx"; 
		String sheetname="RETD_010";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="./resources/RETC_Test_Data_Complex_TC.xlsx"; 
		String sheetname="RETD_011";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("./resources/RETC_Test_Data_Complex_TC.xlsx", "userData_RETC_076"); 
	}
}

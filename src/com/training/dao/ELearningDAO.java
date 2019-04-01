package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.RealEstateBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public List<RealEstateBean> getRealEstateUsers(){
		String sql = properties.getProperty("get.users"); //Fetch the query from sql.properties file
		
		GetConnection gc  = new GetConnection(); 
		List<RealEstateBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql);//Connect to DB and prepare the SQL query  
			list = new ArrayList<RealEstateBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); //Execute the SQL query and get the result set in DB
			
			while(gc.rs1.next()) {
			
				RealEstateBean temp = new RealEstateBean();
				temp.setUserName(gc.rs1.getString(1));// Set the user name for User name text box			
				temp.setEmail(gc.rs1.getString(2));// Set the email for Email text box
				temp.setFirstName(gc.rs1.getString(3));// Set the First Name for First Name text box
				temp.setLastName(gc.rs1.getString(4));// Set the Last Name forLast Name text box
				temp.setWebsite(gc.rs1.getString(5));// Set the Web site for Web site text box
				temp.setPassword(gc.rs1.getString(6));// Set the password for Password text box
				temp.setRole(gc.rs1.getString(7));// Set the Role for Role list box

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	public static void main(String[] args) {
		new ELearningDAO().getRealEstateUsers().forEach(System.out :: println);
	}
	
	
}

package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.AppManager;

public class TestBase {
	
	protected static AppManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app=new AppManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

	@DataProvider
	  public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++){
			GroupData group = new GroupData();
			group.setGroupname(generateRandomString());
			group.setHeader(generateRandomString());
		    group.setFooter(generateRandomString());
		    list.add(new Object[]{group});
		}
		return list.iterator();
	}
	  
		@DataProvider
		  public Iterator<Object[]> randomValidContactGenerator() {
			Random select = new Random();
			List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 5; i++){
				ContactData contact = new ContactData();
				contact.setFirstName(generateRandomString());
				contact.setLastName(generateRandomString());
				contact.setAddress(generateRandomString());
				contact.setHomePhone(generateRandomString());
				contact.setMobilePhone(generateRandomString());
				contact.setWorkPhone(generateRandomString());
				contact.setEmail(generateRandomString());
				contact.setSecondEmail(generateRandomString());
				contact.setDay(generateRandomNumberString(select.nextInt(32)));
				contact.setMonth(getMonthByNumber(select.nextInt(13)));
				contact.setYear(generateRandomNumberString(select.nextInt(2015)));
				contact.setSecondaryAddress(generateRandomString());
				contact.setSecondaryPhone(generateRandomString());
				list.add(new Object[]{contact});
			}
			return list.iterator();
		}

		  private String getMonthByNumber(int number){
			  switch (number) {
			  
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";

			default:
				return "-";
			}
		  }
		  
		  private String generateRandomNumberString(int number){
			  if (number == 0){
				  return "-";
			  }
			  return String.valueOf(number);
		  }
		  

	
	  public String generateRandomString() {
		  Random	rnd = new Random();
		  if (rnd.nextInt(3) == 0){
				return "";
			}	else {
				return "test" + rnd.nextInt();
			}
	  }
	  
}

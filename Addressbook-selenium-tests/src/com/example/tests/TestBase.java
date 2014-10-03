package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.AppManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

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
		  return wrapGroupDataForDataProvider(generateRandomGroups(5)).iterator();
	}
	  
		private List<Object[]> wrapGroupDataForDataProvider(List<GroupData> groups) {
			List<Object[]> list = new ArrayList<Object[]>();
			for (GroupData group : groups) {
				list.add(new Object[]{group});
			}
		return list;
	}

		@DataProvider
		  public Iterator<Object[]> randomValidContactGenerator() {
			  return wrapContactDataForDataProvider(generateRandomContacts(5)).iterator();
		}

		private List<Object[]> wrapContactDataForDataProvider(List<ContactData> contacts) {
			List<Object[]> list = new ArrayList<Object[]>();
			for (ContactData contact : contacts) {
				list.add(new Object[]{contact});
			}
			return list;
		}

		 
		  
	  
}

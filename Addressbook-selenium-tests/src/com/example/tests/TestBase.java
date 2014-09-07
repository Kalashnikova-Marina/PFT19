package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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

}

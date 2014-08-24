package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.example.fw.AppManager;


public class TestBase {
	
	protected AppManager app;

	@BeforeClass
	public void setUp() throws Exception {
		app=new AppManager();
	  }

	@AfterClass
	public void tearDown() throws Exception {
		app.stop();
	  }

}

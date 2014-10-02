package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppManager {

	public WebDriver driver;
	public String baseUrl;
	
	private NaviHelper naviHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public AppManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	public void stop() {
		driver.quit();
	}
	
	public NaviHelper navigateTo (){
		if (naviHelper == null) {
			naviHelper = new NaviHelper(this);
		}
		return naviHelper;
	}
	
	public GroupHelper getGroupHelper (){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper (){
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

}

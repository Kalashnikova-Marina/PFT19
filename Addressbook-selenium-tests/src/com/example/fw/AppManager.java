package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AppManager {

	public WebDriver driver;
	public String baseUrl;
	
	private NaviHelper naviHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	
	public AppManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();
		} else if ("chrome".equals(browser)) {
			driver = new ChromeDriver();
		} else {
			throw new Error("Usupported browser: " + browser);
		}
		baseUrl = properties.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
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

package com.example.fw;

import org.openqa.selenium.By;

public class NaviHelper extends HelperBase {

	public NaviHelper(AppManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (! onMainPage()) {
	//		driver.get(manager.baseUrl + "/addressbookv4.1.4/");	
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;
	}

	public void groupPage() {
		if (! onGroupsPage()) {
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size() > 0){
			return true;
		} else {
			return false;
		}
	}

}

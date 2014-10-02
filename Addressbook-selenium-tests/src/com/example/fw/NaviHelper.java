package com.example.fw;

import org.openqa.selenium.By;

public class NaviHelper extends HelperBase {

	public NaviHelper(AppManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (! onMainPage()){
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return	driver.findElements(By.id("maintable")).size() > 0;
	}

	public void groupPage() {
		if (! onGroupPage()) {
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupPage() {
		if (driver.getCurrentUrl().contains("/groups.php")
				&& driver.findElements(By.name("new")).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}

package com.example.fw;

import org.openqa.selenium.By;

public class NaviHelper extends HelperBase {

	public NaviHelper(AppManager manager) {
		super(manager);
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void openGroupPage() {
		click(By.linkText("groups"));
	}

}

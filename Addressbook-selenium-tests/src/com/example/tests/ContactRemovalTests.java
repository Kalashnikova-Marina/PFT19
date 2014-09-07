package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteContact(){
		app.getNaviHelper().openMainPage();
		app.getContactHelper().openEditContactPage(2);
		app.getContactHelper().deleteContact();
		app.getContactHelper().backToHomePage();
	}

}

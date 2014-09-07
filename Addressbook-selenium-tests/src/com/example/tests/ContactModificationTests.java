package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifyContactFromMainPage(){
		app.getNaviHelper().openMainPage();
		app.getContactHelper().openEditContactPage(2);
		ContactData contact = new ContactData();
		contact.setFirstName("Free");
		contact.setLastName("Andrey");
		app.getContactHelper().enterContactData(contact);
		app.getContactHelper().submitContactModification();		
		app.getContactHelper().backToHomePage();
	}

	@Test
	public void modifyContactFromDetails(){
		app.getNaviHelper().openMainPage();
		app.getContactHelper().openDetailsContactPage(2);
		app.getContactHelper().initCintactModification();
		ContactData contact = new ContactData();
		contact.setFirstName("Petr");
		contact.setLastName("Petrov");
		contact.setDay("12");
		app.getContactHelper().enterContactData(contact);
		app.getContactHelper().submitContactModification();		
		app.getContactHelper().backToHomePage();
	}
	
}
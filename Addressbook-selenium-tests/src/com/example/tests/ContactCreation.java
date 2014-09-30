package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;;

public class ContactCreation extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void createContactWithValidData(ContactData contact) throws Exception {
		app.navigateTo().mainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().openNewContactPage();		
		app.getContactHelper().enterContactData(contact, CREATION);		
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().backToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare old and new states
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}
}
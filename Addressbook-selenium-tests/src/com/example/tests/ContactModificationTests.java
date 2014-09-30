package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactFromMainPage(ContactData contact) {
		app.navigateTo().mainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().openEditContactPage(index);
		app.getContactHelper().enterContactData(contact, MODIFICATION);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().backToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare old and new states
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactFromDetails(ContactData contact) {
		app.navigateTo().mainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().openDetailsContactPage(index);
		app.getContactHelper().initCintactModification();
		app.getContactHelper().enterContactData(contact, MODIFICATION);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().backToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare old and new states
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

}
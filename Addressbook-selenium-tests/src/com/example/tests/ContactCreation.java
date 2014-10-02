package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreation extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void createContactWithValidData(ContactData contact) throws Exception {

		// save old state
		SortedListOf<ContactData> oldList = new SortedListOf<>(app.getContactHelper().getContacts());

		// actions
		app.getContactHelper().createContact(contact);

		// save new state
		SortedListOf<ContactData> newList = new SortedListOf<>(app.getContactHelper().getContacts());

		// compare old and new states
		assertThat(newList, equalTo(oldList.withAdded(contact)));
	}
}
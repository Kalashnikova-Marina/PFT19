package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreation extends TestBase {
	
	@DataProvider
	  public Iterator<Object[]> contactsFromCsvFile() throws IOException {
		  return wrapContactDataForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	  
	@DataProvider
	  public Iterator<Object[]> contactsFromXmlFile() throws IOException {
		  return wrapContactDataForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromXmlFile")
	public void createContactWithValidData(ContactData contact) throws Exception {

		// save old state
		SortedListOf<ContactData> oldList = new SortedListOf<>(app.getContactHelper().getContacts());

		// actions
		app.getContactHelper().createContact(contact);

		// save new state
		SortedListOf<ContactData> newList = new SortedListOf<>(app.getContactHelper().getContactsFromUi());

		// compare old and new states
		assertThat(newList, equalTo(oldList.withAdded(contact)));
	}
}
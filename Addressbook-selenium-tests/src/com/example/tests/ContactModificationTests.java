package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactFromMainPage(ContactData contact) {
		
		// save old state
		SortedListOf<ContactData> oldList = new SortedListOf<>(app.getContactHelper().getContacts());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().modifyContactFromMainPage(contact, index);

		// save new state
		SortedListOf<ContactData> newList = new SortedListOf<>(app.getContactHelper().getContactsFromUi());

		// compare old and new states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactFromDetails(ContactData contact) {
		
		// save old state
		SortedListOf<ContactData> oldList = new SortedListOf<>(app.getContactHelper().getContacts());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().modifyContactFromDetails(contact, index);

		// save new state
		SortedListOf<ContactData> newList = new SortedListOf<>(app.getContactHelper().getContactsFromUi());
		
		// compare old and new states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
	
}
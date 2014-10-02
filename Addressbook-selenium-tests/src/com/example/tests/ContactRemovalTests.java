package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteContact() {

		// save old state
		List<ContactData> oldList = new ArrayList<>(app.getContactHelper().getContacts());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().deleteContact(index);

		// save new state
		List<ContactData> newList = new ArrayList<>(app.getContactHelper().getContacts());

		// compare old and new states
		oldList.remove(index);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

}

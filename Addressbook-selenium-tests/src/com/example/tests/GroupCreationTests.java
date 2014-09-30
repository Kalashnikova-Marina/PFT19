package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void createGroupWithValidData(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// compare old and new states
		oldList.add(group);
		assertEquals(newList, oldList);
	}

}

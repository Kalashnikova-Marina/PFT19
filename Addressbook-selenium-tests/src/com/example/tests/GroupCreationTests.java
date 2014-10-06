package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
public class GroupCreationTests extends TestBase {

	@DataProvider
	  public Iterator<Object[]> groupsFromCsvFile() throws IOException {
		  return wrapGroupDataForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}

	 @DataProvider
	 public Iterator<Object[]> groupsFromXmlFile() throws IOException {
		  return wrapGroupDataForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromXmlFile")
	public void createGroupWithValidData(GroupData group) throws Exception {

		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// compare old and new states
		assertThat(newList, equalTo(oldList.withAdded(group)));
	}

}

package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {

	public GroupHelper(AppManager manager) {
		super(manager);
	}

	private SortedListOf<GroupData> cachedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildDBCache();
		}
		return cachedGroups;

	}

	private void rebuildDBCache() {
		cachedGroups = new SortedListOf<GroupData>();
		HibernateHelper hibernateHelper = new HibernateHelper(this.manager);
		cachedGroups.addAll(hibernateHelper.listGroups());
	}
	
	public SortedListOf <GroupData> getGroupsFromUI() {
		SortedListOf <GroupData> uiGroups = new SortedListOf<GroupData>();

		manager.navigateTo().groupPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname = title.substring("Select (".length(), title.length() - ")".length());
			uiGroups.add(new GroupData().withName(groupname));
		}
		return uiGroups;
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		openGroupCreationPage();
		fillGroupFields(group);
		saveNewGroup();
		backToGroupPage();
		rebuildDBCache();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupPage();
		initGroupModofication(index);
		fillGroupFields(group);
		submitGroupModification();
		backToGroupPage();
		rebuildDBCache();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		backToGroupPage();
		rebuildDBCache();
		return this;
	}

	// -------------------------------------------------------------------------------------

	public GroupHelper openGroupCreationPage() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupFields(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper saveNewGroup() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper backToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
	}

	public GroupHelper initGroupModofication(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
	}

}

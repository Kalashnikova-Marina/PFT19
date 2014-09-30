package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(AppManager manager) {
		super(manager);
	}

	private List<GroupData> cachedGroups;
	
	public List<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
		
	}
	
	private void rebuildCache() {
		cachedGroups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.setGroupname(title.substring("Select (".length(), title.length() - ")".length()));
			cachedGroups.add(group);
		}
	}

	public void openGroupCreationPage() {
		click(By.name("new"));
	}

	public void fillGroupFields(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
	}

	public void saveNewGroup() {
		click(By.name("submit"));
		cachedGroups = null;
	}

	public void backToGroupPage() {
		click(By.linkText("group page"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void initGroupModofication(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		
	}

	public void submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
	}

}

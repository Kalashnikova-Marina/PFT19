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
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.setGroupname(title.substring("Select (".length(), title.length() - ")".length()));
			groups.add(group);
		}
		return groups;
	}

}

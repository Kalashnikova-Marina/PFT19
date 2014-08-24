package com.example.fw;

import org.openqa.selenium.By;

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
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void initGroupModofication(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		
	}

	public void submitGroupModofication() {
		click(By.name("update"));
	}

}

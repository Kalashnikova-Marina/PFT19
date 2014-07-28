package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends BaseActions {
	
  @Test
  public void createNonEmptyGroup() throws Exception {
	openMainPage();
    openGroupPage();
    openGroupCreationPage();
    GroupData group = new GroupData();
    group.setGroupname("new group");
    group.setHeader("header");
    group.setFooter("footer");
	fillGroupFields(group);
    saveNewGroup();
    backToGroupPage();
  }
  
  @Test
  public void createEmptyGroup() throws Exception {
	openMainPage();
    openGroupPage();
    openGroupCreationPage();
    GroupData group = new GroupData("", "", "");
	fillGroupFields(group);
    saveNewGroup();
    backToGroupPage();
  }
}

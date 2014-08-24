package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void createNonEmptyGroup() throws Exception {
	app.getNaviHelper().openMainPage();
    app.getNaviHelper().openGroupPage();
    app.getGroupHelper().openGroupCreationPage();
    GroupData group = new GroupData();
    group.setGroupname("new group");
    group.setHeader("header");
    group.setFooter("footer");
	app.getGroupHelper().fillGroupFields(group);
    app.getGroupHelper().saveNewGroup();
    app.getGroupHelper().backToGroupPage();
  }
  
  @Test
  public void createEmptyGroup() throws Exception {
	app.getNaviHelper().openMainPage();
    app.getNaviHelper().openGroupPage();
    app.getGroupHelper().openGroupCreationPage();
    GroupData group = new GroupData();
    group.setGroupname("");
    group.setHeader("");
    group.setFooter("");
	app.getGroupHelper().fillGroupFields(group);
    app.getGroupHelper().saveNewGroup();
    app.getGroupHelper().backToGroupPage();
  }
}

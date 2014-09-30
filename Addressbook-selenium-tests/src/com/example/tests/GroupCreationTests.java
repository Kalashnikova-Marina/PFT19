package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  
  @Test(dataProvider = "randomValidGroupGenerator")
  public void createGroupWithValidData(GroupData group) throws Exception {
	app.getNaviHelper().openMainPage();
    app.getNaviHelper().openGroupPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    
    app.getGroupHelper().openGroupCreationPage();
	app.getGroupHelper().fillGroupFields(group);
    app.getGroupHelper().saveNewGroup();
    app.getGroupHelper().backToGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare old and new states
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

}

package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
		
	@Test
	public void modifyGroup(){
		app.getNaviHelper().openMainPage();
	    app.getNaviHelper().openGroupPage();
		app.getGroupHelper().initGroupModofication(1);
		GroupData group = new GroupData();
		group.setGroupname("hustle");
		app.getGroupHelper().fillGroupFields(group);
		app.getGroupHelper().submitGroupModofication();
		app.getGroupHelper().backToGroupPage();
	}
}

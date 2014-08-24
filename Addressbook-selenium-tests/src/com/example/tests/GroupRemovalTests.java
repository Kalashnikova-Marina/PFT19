package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteGroup(){
		app.getNaviHelper().openMainPage();
	    app.getNaviHelper().openGroupPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().backToGroupPage();
	}

}

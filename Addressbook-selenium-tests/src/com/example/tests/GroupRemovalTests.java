package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteGroup(){
		app.getNaviHelper().openMainPage();
	    app.getNaviHelper().openGroupPage();
	   
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random ();
	    int index = rnd.nextInt(oldList.size()-1);
	   
	    //actions
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().backToGroupPage();
		
		//save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare old and new states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}

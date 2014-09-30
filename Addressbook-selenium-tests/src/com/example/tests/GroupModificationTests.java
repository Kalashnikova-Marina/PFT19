package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
		
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifyGroup(GroupData group){
	    //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random ();
	    int index = rnd.nextInt(oldList.size()-1);

	    //actions	    
		app.getGroupHelper().modifyGroup(index, group);
			
		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare old and new states
	    oldList.remove(index);
	    oldList.add(group);
	    assertEquals(newList, oldList);
	}
}

package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import static com.example.fw.ContactHelper.MODIFICATION;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase{

	@Test (dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
	    //save old state
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	   
	    //actions
	    app.getContactHelper().modifyContact(index, contact);
	
		//save new state 
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states  
	    assertThat (newList, equalTo(oldList.without(index).withAdded(contact)));	    	    
	}
}

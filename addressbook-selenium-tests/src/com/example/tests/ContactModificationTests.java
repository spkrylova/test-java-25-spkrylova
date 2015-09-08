package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	   
	    //actions
		app.getContactHelper().initContactModification(0);
	    ContactData contact = new ContactData();
	    contact.firstname = "new firstname";
	    
		app.getContactHelper().fillAddNewContactPage(contact);
		app.getContactHelper().submitContactModication();
		app.getNavigationHelper().goToMainPage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    app.getContactHelper().fillFirstAndLastName(contact);
	    
	    oldList.remove(0);
	    oldList.add (contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals (newList, oldList);	
		
	    	    
	}

	
	
}

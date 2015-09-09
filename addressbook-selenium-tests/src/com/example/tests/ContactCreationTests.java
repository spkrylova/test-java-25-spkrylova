package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	

  @Test (dataProvider = "randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact)  throws Exception {
    app.getNavigationHelper().openMainPage ();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
   
    //actions
    app.getNavigationHelper().gotoAddNewContactPage();
	app.getContactHelper().fillAddNewContactPage(contact);
	app.getContactHelper().submitContactCreation();
	app.getNavigationHelper().goToMainPage();
	
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    app.getContactHelper().fillFirstAndLastName(contact);
    oldList.add (contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals (newList, oldList);
 }
  
  //@Test
public void testEmptyContactCreation()  throws Exception {
	app.getNavigationHelper().openMainPage ();
	
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
   
    //actions
	app.getNavigationHelper().gotoAddNewContactPage();
    ContactData contact = new ContactData();
    contact.firstname = "";
    contact.lastname = "";
    app.getContactHelper().fillAddNewContactPage(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToMainPage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    app.getContactHelper().fillFirstAndLastName(contact);
    oldList.add (contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals (newList, oldList);
  }
}

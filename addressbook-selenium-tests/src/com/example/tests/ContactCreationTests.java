package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
  @Test
public void testNonEmptyContactCreation()  throws Exception {
    app.getNavigationHelper().openMainPage ();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
   
    //actions
    app.getNavigationHelper().gotoAddNewContactPage();
    ContactData contact = new ContactData();
    contact.firstname = "John";
    contact.lastname = "Smith";
    contact.mobile = "+1 987654321";
    contact.bday_day = "13";
    contact.bday_month = "February";
    contact.bday_year = "1960";
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
  
  @Test
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

package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;
public class ContactCreationTests extends TestBase{
	

  @Test (dataProvider = "randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact)  throws Exception {
    app.navigateTo().mainPage ();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
   
    //actions
    app.navigateTo().gotoAddNewContactPage();
	app.getContactHelper().fillAddNewContactPage(contact, true);
	app.getContactHelper().submitContactCreation();
	app.navigateTo().goToMainPage();
	
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
	app.navigateTo().mainPage ();
	
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
   
    //actions
	app.navigateTo().gotoAddNewContactPage();
    ContactData contact = new ContactData();
    contact.firstname = "";
    contact.lastname = "";
    app.getContactHelper().fillAddNewContactPage(contact, ContactHelper.CREATION);
    app.getContactHelper().submitContactCreation();
    app.navigateTo().goToMainPage();
    
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

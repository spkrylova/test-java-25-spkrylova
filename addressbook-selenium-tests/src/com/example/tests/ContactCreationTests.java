package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
  @Test
public void testNonEmptyContactCreation()  throws Exception {
    openMainPage ();
    gotoAddNewPage();
    ContactData contact = new ContactData();
    contact.firstname = "John";
    contact.lastname = "Smith";
    contact.mobile = "+1 987654321";
    contact.bday_day = "13";
    contact.bday_month = "February";
    contact.bday_year = "1960";
	fillAddNewPage(contact);
    submitContactCreation();
 }
  
  @Test
public void testEmptyContactCreation()  throws Exception {
    openMainPage ();
    gotoAddNewPage();
    ContactData contact = new ContactData();
	fillAddNewPage(contact);
    submitContactCreation();
  }
}

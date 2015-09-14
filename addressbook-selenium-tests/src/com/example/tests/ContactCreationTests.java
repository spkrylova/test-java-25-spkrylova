package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;
public class ContactCreationTests extends TestBase{
	

  @Test (dataProvider = "randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact)  throws Exception {
    
    //save old state
    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
   
    //actions
    app.getContactHelper().createContact (contact);
	
    //save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
 }
  
}

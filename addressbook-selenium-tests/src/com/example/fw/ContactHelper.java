package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;



public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}


	public void fillAddNewContactPage(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("mobile"), contact.mobile);
		if (contact.bday_day != null) {
			selectByText(By.name("bday"), contact.bday_day);	
		}
		if (contact.bday_month !=null) {
	   	    selectByText(By.name("bmonth"), contact.bday_month);			
		}

	    type(By.name("byear"), contact.bday_year);
	}

	public void fillFirstAndLastName(ContactData contact) {
		if (contact.firstname != null) {
			if (contact.lastname != null) {
				contact.first_and_last_name = contact.firstname + " " + contact.lastname;
			}
			else {
				contact.first_and_last_name = contact.firstname + " ";				
			}
			
		} else {
			if (contact.lastname != null) {
				contact.first_and_last_name =" " + contact.lastname;
			} else {
				contact.first_and_last_name =" ";

			}

		}
		return;
	}    
	
	public void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void editContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
	}
	
	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		
		
		
	}

	public void initContactModification(int index) {
		//selectContactByIndex(index);
		editContact(index);
		
	}

	public void submitContactModication() {
		click(By.name("update"));
	}


	
	private List<WebElement> getContactRows() {
		List<WebElement> contactRows = driver.findElements(By.xpath ("//tr"));
		contactRows.remove(0);
		int i = contactRows.size();
		contactRows.remove(i-1);
		return contactRows;
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> contactRows =  getContactRows();
		for (WebElement row: contactRows) {
	        ContactData contact = new ContactData();
	        contact.firstname = row.findElement(By.xpath(".//td[3]")).getText();
	        contact.lastname  = row.findElement(By.xpath(".//td[2]")).getText();
		    fillFirstAndLastName(contact);
		    contacts.add (contact);
		}
		
		return contacts;
	}
}

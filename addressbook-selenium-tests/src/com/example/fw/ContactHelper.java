package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;


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


	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkBoxes = driver.findElements(By.name ("selected[]"));
		for (WebElement checkBox : checkBoxes) {
			ContactData contact = new ContactData();
			String title = checkBox.getAttribute("title");
			contact.first_and_last_name =title.substring("Select (".length(), title.length()-")".length());			
			contacts.add(contact);
		}
		
		return contacts;
	}
}

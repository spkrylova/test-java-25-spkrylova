package com.example.fw;

import org.openqa.selenium.By;
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
	    selectByText(By.name("bday"), contact.bday_day);
	    selectByText(By.name("bmonth"), contact.bday_month);
	    type(By.name("byear"), contact.bday_year);
	}



}

package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;


public class ContactHelper extends HelperBase{
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}


public ContactHelper createContact(ContactData contact) {
	manager.navigateTo().gotoAddNewContactPage();
    fillAddNewContactPage(contact, CREATION);
    submitContactCreation();
    returnToMainPage();
    cachedContacts = null;
    return this;
	
}

public ContactHelper removeContact (int index) {
	editContact(index);
    deleteContact();
    returnToMainPage();
    cachedContacts = null;
	return this;
}


public ContactHelper modifyContact(int index, ContactData contact) {
	 initContactModification(index);  
     fillAddNewContactPage(contact, MODIFICATION);
     submitContactModication();
     returnToMainPage();
     cachedContacts = null;
 	 return this;
	
}

//-----------------------------------------------------------------

	public ContactHelper fillAddNewContactPage(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("mobile"), contact.getMobile());
		if (contact.getBday_day() != null) {
			selectByText(By.name("bday"),contact.getBday_day());	
		}
		if (contact.getBday_month() !=null) {
	   	    selectByText(By.name("bmonth"), contact.getBday_month());			
		}

	    type(By.name("byear"), contact.getBday_year());
	    if (formType == CREATION) {
	    	
	    } else {
	    	
	    }
	    return this;
	}
	
	public void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public ContactHelper editContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		return this;
	}
	
	public ContactHelper deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactModification(int index) {
        manager.navigateTo().goToMainPage();
		editContact(index);
		return this;
		
	}

	public ContactHelper submitContactModication() {
		click(By.name("update"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToMainPage() {
	    click (By.linkText("home page"));
		return this;
	    
	}
	
	private List<WebElement> getContactRows() {
		List<WebElement> contactRows = driver.findElements(By.xpath ("//tr"));
		contactRows.remove(0);
		int i = contactRows.size();
		contactRows.remove(i-1);
		return contactRows;
	}


	private SortedListOf<ContactData> cachedContacts;
	
	public  SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();			
		}
		return cachedContacts;
	}

	
	private void rebuildCache() {	
				cachedContacts = new SortedListOf<ContactData>();				
				manager.navigateTo().goToMainPage();
				List<WebElement> contactRows =  getContactRows();
				for (WebElement row: contactRows) {
			        ContactData contact = new ContactData();
			        contact
			              .withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
			              .withLastName( row.findElement(By.xpath(".//td[2]")).getText());
					cachedContacts.add(contact);

				}		
				
			}

}

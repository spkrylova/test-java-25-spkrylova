package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{
	
	@DataProvider	
	public Iterator<Object[]>	contactsFromFile() throws IOException {
		return wrapContactsForDataProvider (loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		//return wrapContactsForDataProvider (loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}

	private List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]>  list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		} 
		return list;
	}

	@Test (dataProvider = "contactsFromFile")
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

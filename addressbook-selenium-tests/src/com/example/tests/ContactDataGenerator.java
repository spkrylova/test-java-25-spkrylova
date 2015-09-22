package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.example.tests.TestBase.generateRandomString;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify 3 parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File (args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);	
		}

		List<ContactData> Contacts = generateRandomContacts(amount);
		if (format.equals("csv")) {
			saveContactsToCsvFile(Contacts, file);
		} else if (format.equals("xml")) {
			saveContactsToXmlFile(Contacts, file);
		} else {
			System.out.println("Unknown format " + format);
			return;
		} 
	}

	private static void saveContactsToXmlFile(List<ContactData> Contacts, File file) throws IOException {
		XStream xstream = new XStream ();
		xstream.alias("Contact", ContactData.class);
		String xml = xstream.toXML(Contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}

	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream ();
		xstream.alias("Contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);	
	}

	private static void saveContactsToCsvFile(List<ContactData> Contacts, File file) throws IOException  {
		FileWriter writer = new FileWriter(file);
		for (ContactData Contact : Contacts) {
			writer.write(Contact.getLastname() + "," + Contact.getFirstname() + "," + Contact.getMobile() + ",|" + "\n");
		}
		writer.close();

	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData>  list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData Contact = new ContactData()
					.withLastName(part[0])
					.withFirstName(part[1])
					.withMobile(part[2]);	
			list.add(Contact);
			line = bufferedReader.readLine();
		}

		bufferedReader.close();
		return list;	

	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData>  list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData Contact = new ContactData()
					.withLastName(generateRandomString())
					.withFirstName(generateRandomString())
					.withMobile(generateRandomString());
			list.add(Contact);			
		}
		return list;
	}


}

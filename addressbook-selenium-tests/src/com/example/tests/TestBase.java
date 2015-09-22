package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
    
	protected ApplicationManager app;
		
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager ();

	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop ();

	  }	

	  @DataProvider	
	  public Iterator<Object[]>	randomValidGroupGenerator() {
		  return wrapGrpupsForDataProvider (generateRandomGroups(5)).iterator();
	  }
	  
	  public static List<Object[]> wrapGrpupsForDataProvider(List<GroupData> groups) {
			List<Object[]>  list = new ArrayList<Object[]>();
			for (GroupData group : groups) {
				list.add(new Object[]{group});
			} 
		return list;
	}


		@DataProvider	
		  public Iterator<Object[]>	randomValidContactGenerator() {
			  List<Object[]>  list = new ArrayList<Object[]>();
			  for (int i = 0; i < 5; i++) {
				  ContactData contact = new ContactData();
				  contact
				       .withFirstName(generateRandomString())
				        .withLastName(generateRandomString())
				        .withMobile(generateRandomString());			
				  list.add(new Object[]{contact});			
			}
			  return list.iterator();
	 }
	  
	  public static String generateRandomString (){
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			 return "";			
		} else {
			return  "test" + rnd.nextInt();

		}
	  }
	
}

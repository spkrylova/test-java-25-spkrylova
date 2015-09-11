package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
	    
	    driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	    driver.findElement(By.linkText("home")).click();   
	}

	public void groupsPage() {
		click(By.linkText("groups"));
		//returnToGroupsPage();
	}
	
	public void gotoAddNewContactPage() {
		click(By.linkText("add new"));
	}
	
	public void goToMainPage() {
		click(By.linkText("home"));
	}	

}

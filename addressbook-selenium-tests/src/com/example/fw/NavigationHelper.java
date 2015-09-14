package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
	    driver.findElement(By.linkText("home")).click();   
	}

	public void groupsPage() {
	   if (! onGroupsPage()){	
		click(By.linkText("groups"));
	   }
	}
	
	public void gotoAddNewContactPage() {
		if (! onAddNewContactPage() ) {
			click(By.linkText("add new"));	
		}

	}
	
	public void goToMainPage() {
		if (! onMainPage()) {
			click(By.linkText("home"));			
		}

	}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;

	}

	private boolean onGroupsPage() {
		return (driver.getCurrentUrl().contains("/group.php") && (driver.findElements(By.name("new")).size() >0));
	}	
	
	
	private boolean onAddNewContactPage() {
		return (driver.getCurrentUrl().equals("http://localhost/addressbookv4.1.4/edit.php"));
	}
}

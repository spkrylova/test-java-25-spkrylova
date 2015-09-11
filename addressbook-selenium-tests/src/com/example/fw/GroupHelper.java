package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		return this;
	}
	
	public List<GroupData> getGroups() {		
		List<GroupData> groups = new ArrayList<GroupData>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkBoxes = driver.findElements(By.name ("selected[]"));
		for (WebElement checkBox : checkBoxes) {
			
			String title = checkBox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()-")".length());
			GroupData group = new GroupData().withName(name);
			groups.add(group);
		}
		
		return groups;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		 return this;
		
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
	    initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
		return this;
	}
//-----------------------------------------------------------------
	
	public GroupHelper initGroupCreation() {
	    click(By.name("new"));
	    return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	  type(By.name("group_name"), group.getName());
	  type(By.name("group_header"), group.getHeader());
	  type(By.name("group_footer"), group.getFooter());
	  return this;
	}

	public GroupHelper returnToGroupsPage() {
		click (By.linkText("groups"));
		return this;
	    
	}

	public GroupHelper submitGroupCreation() {
	    click(By.name("submit"));
	    return this;
	}

	public void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
			}

	public GroupHelper initGroupModification(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;		
		
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}







	
	

}

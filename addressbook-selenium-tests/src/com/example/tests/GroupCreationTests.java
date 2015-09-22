package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@DataProvider	
	public Iterator<Object[]>	groupsFromFile() throws IOException {
		//return wrapGroupsForDataProvider (loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
		return wrapGroupsForDataProvider (loadGroupsFromCsvFile(new File("groups.txt"))).iterator();

	}

	private List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]>  list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		} 
		return list;
	}

	@Test (dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		//actions
		app.getGroupHelper().createGroup(group);

		//save new state
		SortedListOf <GroupData> newList = app.getGroupHelper().getGroups();

		//compare states
		assertThat(newList, equalTo(oldList.withAdded(group)));

	}
}

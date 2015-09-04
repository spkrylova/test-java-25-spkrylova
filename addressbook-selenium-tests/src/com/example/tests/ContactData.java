package com.example.tests;

public class ContactData {
	public String lastname;
	public String firstname;
	public String mobile;
	public String bday_day;
	public String bday_month;
	public String bday_year;
	
	public ContactData() {

		
	}

	public ContactData(String lastname, String firstname, String mobile, String bday_day, String bday_month,
			String bday_year) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.mobile = mobile;
		this.bday_day = bday_day;
		this.bday_month = bday_month;
		this.bday_year = bday_year;
	}
}
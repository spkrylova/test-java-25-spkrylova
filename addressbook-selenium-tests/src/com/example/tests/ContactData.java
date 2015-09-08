package com.example.tests;

public class ContactData implements Comparable <ContactData>{
	public String lastname;
	public String firstname;
	public String mobile;
	public String bday_day;
	public String bday_month;
	public String bday_year;
	public String first_and_last_name;
	
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

	@Override
	public int compareTo(ContactData other) {
		return this.first_and_last_name.toLowerCase().compareTo (other.first_and_last_name.toLowerCase());

	}

	@Override
	public String toString() {
		return "ContactData [first_and_last_name=" + first_and_last_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((first_and_last_name == null) ? 0 : first_and_last_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (first_and_last_name == null) {
			if (other.first_and_last_name != null)
				return false;
		} else if (!first_and_last_name.equals(other.first_and_last_name))
			return false;
		return true;
	}
	
	
}
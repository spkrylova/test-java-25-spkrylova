package com.example.tests;

public class ContactData implements Comparable <ContactData>{
	private String lastname;
	private String firstname;
	private String mobile;
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
	


	@Override
	public int compareTo(ContactData other) {
		int result;
		result = this.lastname.toLowerCase().compareTo (other.lastname.toLowerCase());
		if (result == 0) {
			result = this.firstname.toLowerCase().compareTo (other.firstname.toLowerCase());
		}
		
		return result;

	}
	
	
	

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + " lastname="+lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		//result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	
	public ContactData withFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getMobile() {
		return mobile;
	}

	public String getBday_day() {
		return bday_day;
	}

	public String getBday_month() {
		return bday_month;
	}

	public String getBday_year() {
		return bday_year;
	}


	
}
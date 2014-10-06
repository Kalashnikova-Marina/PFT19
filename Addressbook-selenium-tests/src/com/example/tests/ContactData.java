package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String secondEmail;
	private String year;
	private String secondaryAddress;
	private String secondaryPhone;
	private String day;
	private String month;
	private String group;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public ContactData setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public ContactData setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public ContactData setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public ContactData setHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public ContactData setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public ContactData setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ContactData setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public ContactData setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
		return this;
	}

	public String getYear() {
		return year;
	}

	public ContactData setYear(String year) {
		this.year = year;
		return this;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public ContactData setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
		return this;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public ContactData setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
		return this;
	}

	public String getDay() {
		return day;
	}

	public ContactData setDay(String day) {
		this.day = day;
		return this;
	}

	public String getMonth() {
		return month;
	}

	public ContactData setMonth(String month) {
		this.month = month;
		return this;
	}

	public String getGroup() {
		return group;
	}

	public ContactData setGroup(String group) {
		this.group = group;
		return this;
	}

	

	@Override
	public String toString() {
		return "ContactData [ lastName=" + lastName + ", firstName=" + firstName + ", address=" + address
				+ ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone + ", workPhone=" + workPhone + ", email="
				+ email + ", secondEmail=" + secondEmail + ", year=" + year + ", secondaryAddress=" + secondaryAddress
				+ ", secondaryPhone=" + secondaryPhone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		//result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.toString().toLowerCase().compareTo(other.toString().toLowerCase());
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
		return this;
	}

	public ContactData withDay(String day) {
		this.day = day;
		return this;
	}

	public ContactData withMonth(String month) {
		this.month = month;
		return this;
	}

	public ContactData withYear(String year) {
		this.year = year;
		return this;
	}

	public ContactData withSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
		return this;
	}

	public ContactData withSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
		return this;
	}
	
}
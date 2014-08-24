package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(AppManager manager) {
		super(manager);
	}

	public void openNewContactPage() {
		click(By.linkText("add new"));
	}

	public void enterContactData(ContactData contact) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHomePhone());
		type(By.name("mobile"), contact.getMobilePhone());
		type(By.name("work"), contact.getWorkPhone());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getSecondEmail());
		selectByText(By.name("bday"), contact.getDay());
		selectByText(By.name("bmonth"), contact.getMonth());
		type(By.name("byear"), contact.getYear());
		// selectByText(By.name("new_group"), contact.getGroup());
		type(By.name("address2"), contact.getSecondaryAddress());
		type(By.name("phone2"), contact.getSecondaryPhone());
		}

	

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void backToHomePage() {
		click(By.linkText("home page"));
	}

}

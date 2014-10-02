package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(AppManager manager) {
		super(manager);
	}

	private List<ContactData> cachedContacts;

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		openNewContactPage();
		enterContactData(contact, CREATION);
		submitContactCreation();
		backToHomePage();
		return this;
	}
	
	public ContactHelper modifyContactFromMainPage(ContactData contact, int index) {
		manager.navigateTo().mainPage();
		openEditContactPage(index);
		enterContactData(contact, MODIFICATION);
		submitContactModification();
		backToHomePage();
		return this;
		}
	
	public ContactHelper modifyContactFromDetails(ContactData contact, int index) {
		manager.navigateTo().mainPage();
		openDetailsContactPage(index);
		initCintactModification();
		enterContactData(contact, MODIFICATION);
		submitContactModification();
		backToHomePage();
		return this;
	}

	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		openEditContactPage(index);
		pressDeleteButton();
		backToHomePage();
		return this;
	}
	
	public List<ContactData> getContacts() {
		
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new ArrayList<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");

			// as title consist of first and last name separated with space
			String firstLastName = title.substring("Select (".length(), title.length() - ")".length());
			String[] names = firstLastName.split(" ");

			switch (names.length) {
			case 2:// first name and last name are field
				contact.setFirstName(names[0]);
				contact.setLastName(names[1]);
				cachedContacts.add(contact);
				break;
			case 0:// first name and last name are empty
				contact.setFirstName("");
				contact.setLastName("");
				cachedContacts.add(contact);
				break;
			case 1:// if one of names is empty, we define the empty name and fill values
				if (firstLastName.indexOf(" ") == 0) {
					contact.setLastName(names[0]);
					contact.setFirstName("");
				} else {
					contact.setFirstName(names[0]);
					contact.setLastName("");
				}
				cachedContacts.add(contact);
				break;
			default:
				break;
			}
		}
		
	}

// --------------------------------------------------------------------------------------
	
	public ContactHelper openNewContactPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper enterContactData(ContactData contact, boolean formType) {
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
//		if (formType == CREATION) {
//		selectByText(By.name("new_group"), contact.getGroup());
//		} else {
//			if (driver.findElements(By.name("new_group")).size() != 0) {
//				throw new Error("Group selector exists in contact modification form");
//			}
//		}
		type(By.name("address2"), contact.getSecondaryAddress());
		type(By.name("phone2"), contact.getSecondaryPhone());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper backToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper openEditContactPage(int index) {
		click(By.xpath("//tr[" + (index+2) + "]/td[7]/a/img"));
		return this;
	}

	public ContactHelper pressDeleteButton() {
		click(By.xpath("//form[2]/input[2]"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("//form[1]/input[11]"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper openDetailsContactPage(int index) {
		click(By.xpath("//tr[" + (index+2) + "]/td[6]/a/img"));
		return this;
	}

	public ContactHelper initCintactModification() {
		click(By.name("modifiy"));
		return this;
	}



	
}

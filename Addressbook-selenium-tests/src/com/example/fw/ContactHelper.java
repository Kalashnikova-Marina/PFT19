package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(AppManager manager) {
		super(manager);
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		openNewContactPage();
		enterContactData(contact, CREATION);
		submitContactCreation();
		backToHomePage();
    	rebuildDBCache();
		return this;
	}
	
	public ContactHelper modifyContactFromMainPage(ContactData contact, int index) {
		manager.navigateTo().mainPage();
		openEditContactPage(index);
		enterContactData(contact, MODIFICATION);
		submitContactModification();
		backToHomePage();
    	rebuildDBCache();
		return this;
		}
	
	public ContactHelper modifyContactFromDetails(ContactData contact, int index) {
		manager.navigateTo().mainPage();
		openDetailsContactPage(index);
		initCintactModification();
		enterContactData(contact, MODIFICATION);
		submitContactModification();
		backToHomePage();
    	rebuildDBCache();
		return this;
	}

	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		openEditContactPage(index);
		pressDeleteButton();
		backToHomePage();
    	rebuildDBCache();
		return this;
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		
		if (cachedContacts == null) {
			rebuildDBCache();
		}
		return cachedContacts;
	}

	private void rebuildDBCache() {
		cachedContacts = new SortedListOf<ContactData>();
		HibernateHelper hibernateHelper = new HibernateHelper(this.manager);
		cachedContacts.addAll(hibernateHelper.listContacts());
	}
	
	public SortedListOf<ContactData> getContactsFromUi() {
		SortedListOf<ContactData> uiContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();		
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
		    ContactData contact = new ContactData()
		        .setFirstName(row.findElement(By.xpath(".//td[3]")).getText())
		        .setLastName(row.findElement(By.xpath(".//td[2]")).getText());
		    uiContacts.add(contact);
		}
		return uiContacts;
	}

// --------------------------------------------------------------------------------------
	
	private List<WebElement> getContactRows() {
		WebElement table = driver.findElement(By.id("maintable"));
		if (table == null){
			return new ArrayList<>();
		}
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		
		if(tableRows.size()>1){
			tableRows.remove(0);
			tableRows.remove(tableRows.size()-1);
		}
		return tableRows;
	}

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

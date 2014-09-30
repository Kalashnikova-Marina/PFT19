package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(AppManager manager) {
		super(manager);
	}

	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
		
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}

	
	private void rebuildCache() {
		cachedContacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");

			// �.�. title �������� firstname � lastName, ����������� ��������,
			// ��� ���������� �� ��������, ������ ��� �������� ���������� �
			// ������ ��������
			String firstLastName = title.substring("Select (".length(), title.length() - ")".length());
			String[] names = firstLastName.split(" ");

			switch (names.length) {
			case 2:// � ������, ����� ������� ��� �����, ����������� ��������
				contact.setFirstName(names[0]);
				contact.setLastName(names[1]);
				cachedContacts.add(contact);
				break;
			case 0:// � ������, ��� ����� - ������
				contact.setFirstName("");
				contact.setLastName("");
				cachedContacts.add(contact);
				break;
			case 1:// � ������, ����� ���� ��� �����, � ������ - ���, ����������
					// ����� �� ���� �� ����� � ������ � ������ ��������
				if (firstLastName.indexOf(" ") == 0) {
					contact.setLastName(names[0]);
					contact.setFirstName("");
				} else {
					contact.setFirstName(names[0]);
					contact.setLastName("");
				}
				cachedContacts.add(contact);
				break;
			default:// ������, ����� ��� ����� �������� ������� ��������
					// ������� ������� � ���������. ��� ����� ����������� ���
					// ������������ �������� ������ ��������� ��� ����������
					// ������������.
				break;
			}
		}
		
	}


	public void openNewContactPage() {
		click(By.linkText("add new"));
	}

	public void enterContactData(ContactData contact, boolean hasGroupSelector) {
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
		if (hasGroupSelector) {
		// selectByText(By.name("new_group"), contact.getGroup());
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.getSecondaryAddress());
		type(By.name("phone2"), contact.getSecondaryPhone());
	}

	public void submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
	}

	public void backToHomePage() {
		click(By.linkText("home page"));
	}

	public void openEditContactPage(int index) {
		click(By.xpath("//tr[" + (index+2) + "]/td[7]/a/img"));
	}

	public void deleteContact() {
		click(By.xpath("//form[2]/input[2]"));
		cachedContacts = null;
	}

	public void submitContactModification() {
		click(By.xpath("//form[1]/input[11]"));
		cachedContacts = null;
	}

	public void openDetailsContactPage(int index) {
		click(By.xpath("//tr[" + (index+2) + "]/td[6]/a/img"));
	}

	public void initCintactModification() {
		click(By.name("modifiy"));
	}

	
}

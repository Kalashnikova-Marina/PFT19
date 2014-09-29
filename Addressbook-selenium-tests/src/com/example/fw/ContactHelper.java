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

	public void openEditContactPage(int index) {
		click(By.xpath("//tr[" + (index+2) + "]/td[7]/a/img"));
	}

	public void deleteContact() {
		click(By.xpath("//form[2]/input[2]"));
	}

	public void submitContactModification() {
		click(By.xpath("//form[1]/input[11]"));
	}

	public void openDetailsContactPage(int index) {
		click(By.xpath("//tr[" + (index+2) + "]/td[6]/a/img"));
	}

	public void initCintactModification() {
		click(By.name("modifiy"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");

			// т.к. title содержит firstname и lastName, разделенные пробелом,
			// нам необходимо их выделить, прежде чем заносить информацию в
			// данные контакта
			String firstLastName = title.substring("Select (".length(), title.length() - ")".length());
			String[] names = firstLastName.split(" ");

			switch (names.length) {
			case 2:// в случае, когда введены оба имени, разделенные пробелом
				contact.setFirstName(names[0]);
				contact.setLastName(names[1]);
				contacts.add(contact);
				break;
			case 0:// в случае, оба имени - пустые
				contact.setFirstName("");
				contact.setLastName("");
				contacts.add(contact);
				break;
			case 1:// в случае, когда одно имя пусто, а другое - нет, определяем
					// какое из имен не пусто и вносим в данные контакта
				if (firstLastName.indexOf(" ") == 0) {
					contact.setLastName(names[0]);
					contact.setFirstName("");
				} else {
					contact.setFirstName(names[0]);
					contact.setLastName("");
				}
				contacts.add(contact);
				break;
			default:// случай, когда оба имени содержат пробелы является
					// слишком сложным в обработке. Это будет учитываться при
					// формировании исходных данных контактов для проведения
					// тестирования.
				break;
			}
		}
		return contacts;
	}

}

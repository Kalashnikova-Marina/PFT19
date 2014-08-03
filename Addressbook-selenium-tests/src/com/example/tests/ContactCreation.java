package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreation extends BaseActions{

  @Test
  public void testContactCreation() throws Exception {
	openMainPage();
    openNewContactPage();
    ContactData contact = new ContactData();
    contact.setFirstName("Ivan");
    contact.setLastName("Ivanov");
    contact.setAddress("Russia, Ivanov, Lenina st. 135");
    contact.setHomePhone("1234567890");
    contact.setMobilePhone("+79008001111");
    contact.setWorkPhone("+79002222222");
    contact.setEmail("myemail@t.r");
    contact.setSecondEmail("additionalemail@t.r");
    contact.setDay("3");
    contact.setMonth("August");
    contact.setYear("2014");
    contact.setGroup("new group");
    contact.setSecondaryAddress("Morozova st. 246");
    contact.setSecondaryPhone("+09876543210");
	enterContactData(contact);
    submitContactCreation();
    backToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    openNewContactPage();
    ContactData contact = new ContactData();
    contact.setFirstName("");
    contact.setLastName("");
    contact.setAddress("");
    contact.setHomePhone("");
    contact.setMobilePhone("");
    contact.setWorkPhone("");
    contact.setEmail("");
    contact.setSecondEmail("");
    contact.setDay("-");
    contact.setMonth("-");
    contact.setYear("");
    contact.setGroup("[none]");
    contact.setSecondaryAddress("");
    contact.setSecondaryPhone("");
	enterContactData(contact);
    submitContactCreation();
    backToHomePage();
  }

}
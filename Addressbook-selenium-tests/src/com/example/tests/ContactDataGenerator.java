package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + ","
					+ contact.getHomePhone() + "," + contact.getMobilePhone() + "," + contact.getWorkPhone() + ","
					+ contact.getEmail() + "," + contact.getSecondEmail() + "," + contact.getDay() + ","
					+ contact.getMonth() + "," + contact.getYear() + "," + contact.getSecondaryAddress() + ","
					+ contact.getSecondaryPhone() + ",!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		Random select = new Random();
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
				.withFirstName(generateRandomString())
				.withLastName(generateRandomString())
				.withAddress(generateRandomString())
				.withHomePhone(generateRandomString())
				.withMobilePhone(generateRandomString())
				.withWorkPhone(generateRandomString())
				.withEmail(generateRandomString())
				.withSecondEmail(generateRandomString())
				.withDay(generateRandomNumberString(select.nextInt(32)))
				.withMonth(getMonthByNumber(select.nextInt(13)))
				.withYear(generateRandomNumberString(select.nextInt(2015)))
				.withSecondaryAddress(generateRandomString())
				.withSecondaryPhone(generateRandomString());
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	public static String generateRandomNumberString(int number) {
		if (number == 0) {
			return "-";
		}
		return String.valueOf(number);
	}

	public static String getMonthByNumber(int number) {
		switch (number) {

		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";

		default:
			return "-";
		}
	}

}

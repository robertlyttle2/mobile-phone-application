package com.robertlyttle;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList = new ArrayList<>();

    public void printContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Your contact list is empty.");
        }

        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i).getName()
                    + ": " + contactList.get(i).getPhoneNumber());
        }
    }

    public void addContact(String name, String mobileNumber) {
        if (findContact(name) >= 0) {
            System.out.println("Contact already exists");
        }

        contactList.add(new Contact(name, mobileNumber));
    }

    public void removeContact(String name) {
        int index = findContact(name);
        contactList.remove(index);
    }

    public void updateContact(String name, String number) {
        int index = findContact(name);

        if (findContact(name) >= 0) {
            Contact contactToUpdate = new Contact(name, number);
            contactList.set(index, contactToUpdate);
        } else {
            System.out.println("Contact not found");
        }
    }

    public int findContact(String name) {
        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                return contactList.indexOf(contact);
            }
        }
        return -1;
    }
}

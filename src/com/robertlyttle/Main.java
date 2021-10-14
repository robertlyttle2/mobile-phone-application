package com.robertlyttle;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.

        printMenu();
        int userChoice = 0;
        while(userChoice != 6) {
            System.out.print("\nEnter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1 -> printMenu();
                case 2 -> printContactList();
                case 3 -> addNewContact();
                case 4 -> updateExistingContact();
                case 5 -> deleteContact();
                case 6 -> searchForContact();
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Print menu options");
        System.out.println("2. Print contact list");
        System.out.println("3. Add new contact");
        System.out.println("4. Update existing contact");
        System.out.println("5. Delete contact");
        System.out.println("6. Search for a contact");
        System.out.println("7. Quit");
    }

    private static void printContactList() {
        mobilePhone.printContacts();
    }

    private static void addNewContact() {
        System.out.println("\nAdd new contact");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        mobilePhone.addContact(name, phoneNumber);
    }

    private static void updateExistingContact() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        mobilePhone.updateContact(name, phoneNumber);
    }

    private static void deleteContact() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }

    private static void searchForContact() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        int found = mobilePhone.findContact(name);
        if (found >= 0) {
            System.out.println("Contact found.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

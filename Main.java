import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    String firstName, lastName, city, state, email;
    long phone;
    int zip;

    public Contact(String firstName, String lastName, String city, String state, String email, long phone, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", zip=" + zip +
                '}';
    }
}

public class AddressBook {
    List<Contact> adBook = new ArrayList<>();

    public void display() {
        if (adBook.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : adBook) {
                System.out.println(contact);
            }
        }
    }

    // USE CASE 1: Create a new contact
    public void createContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First name");
        String firstName = sc.next();
        System.out.println("Enter Last name");
        String lastName = sc.next();
        System.out.println("Enter City");
        String city = sc.next();
        System.out.println("Enter State");
        String state = sc.next();
        System.out.println("Enter Email ID");
        String email = sc.next();
        System.out.println("Enter Phone number");
        long phone = sc.nextLong();
        System.out.println("Enter ZipCode");
        int zip = sc.nextInt();

        Contact c1 = new Contact(firstName, lastName, city, state, email, phone, zip);
        adBook.add(c1);
        System.out.println("Contact added successfully.");
    }

    // USE CASE 2: Edit an existing contact
    public void editContact(String firstName, String lastName) {
        for (Contact contact : adBook) {
            if (contact.firstName.equalsIgnoreCase(firstName) && contact.lastName.equalsIgnoreCase(lastName)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter updated City");
                contact.city = sc.next();
                System.out.println("Enter updated State");
                contact.state = sc.next();
                System.out.println("Enter updated Email");
                contact.email = sc.next();
                System.out.println("Enter updated Phone");
                contact.phone = sc.nextLong();
                System.out.println("Enter updated Zip");
                contact.zip = sc.nextInt();
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Address Book!");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create a new contact");
            System.out.println("2. Display existing contacts");
            System.out.println("3. Edit a contact");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addressBook.createContact();
                case 2 -> addressBook.display();
                case 3 -> {
                    System.out.print("Enter the first name of the contact to edit: ");
                    String firstName = sc.next();
                    System.out.print("Enter the last name of the contact to edit: ");
                    String lastName = sc.next();
                    addressBook.editContact(firstName, lastName);
                }
                case 0 -> {
                    System.out.println("Thank you for using Address Book!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

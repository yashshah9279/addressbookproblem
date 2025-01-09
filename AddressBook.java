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

    // USE CASE 3: Edit an existing contact
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

    // USE CASE 4: Delete a contact
    public void deleteContact(String firstName, String lastName) {
        Contact toDelete = null;
        for (Contact contact : adBook) {
            if (contact.firstName.equalsIgnoreCase(firstName) && contact.lastName.equalsIgnoreCase(lastName)) {
                toDelete = contact;
                break;
            }
        }
        if (toDelete != null) {
            adBook.remove(toDelete);
            System.out.println("Contact named " + firstName + " " + lastName + " deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // USE CASE 5: Add multiple contacts
    public void createMultipleContacts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of contacts to add:");
        int numContacts = sc.nextInt();
        for (int i = 0; i < numContacts; i++) {
            System.out.println("Adding contact " + (i + 1) + ":");
            createContact();
        }
        System.out.println(numContacts + " contacts have been added.");
    }
}

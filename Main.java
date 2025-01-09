import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initializing the Address Book System
        AddressBookSystem system = new AddressBookSystem();
        Scanner sc = new Scanner(System.in);
        AddressBook currentAddressBook = null;

        System.out.println("Welcome to the Address Book System!");

        while (true) {
            System.out.println(
                    "\nMenu:" +
                    "\n1. Create a new Address Book" +
                    "\n2. Select an Address Book" +
                    "\n3. Add a contact to the selected Address Book" +
                    "\n4. Display contacts in the selected Address Book" +
                    "\n5. Add multiple contacts to the selected Address Book" +
                    "\n0. Exit"
            );
            System.out.print("Enter your choice: ");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> {
                    System.out.print("Enter the name of the new Address Book: ");
                    String name = sc.next();
                    system.addAddressBook(name);
                    System.out.println("Address Book '" + name + "' created successfully.");
                }
                case 2 -> {
                    system.displayAddressBooks();
                    System.out.print("Enter the name of the Address Book to select: ");
                    String name = sc.next();
                    currentAddressBook = system.getAddressBook(name);
                    if (currentAddressBook != null) {
                        System.out.println("Address Book '" + name + "' selected.");
                    } else {
                        System.out.println("No Address Book found with the name '" + name + "'.");
                    }
                }
                case 3 -> {
                    if (currentAddressBook != null) {
                        currentAddressBook.createContact();
                    } else {
                        System.out.println("No Address Book is currently selected. Please select or create one first.");
                    }
                }
                case 4 -> {
                    if (currentAddressBook != null) {
                        currentAddressBook.display();
                    } else {
                        System.out.println("No Address Book is currently selected. Please select or create one first.");
                    }
                }
                case 5 -> {
                    if (currentAddressBook != null) {
                        currentAddressBook.createMultipleContacts();
                    } else {
                        System.out.println("No Address Book is currently selected. Please select or create one first.");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting the Address Book System. Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }
}

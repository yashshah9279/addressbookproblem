import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Address Book!");

        while (true) {
            System.out.println(
                    "\nMenu:" +
                    "\n1. Create a new contact" +
                    "\n2. Display existing contacts" +
                    "\n3. Edit an existing contact" +
                    "\n4. Delete an existing contact" +
                    "\n5. Add multiple contacts" +
                    "\n0. Exit"
            );
            System.out.print("Enter your choice: ");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> addressBook.createContact();
                case 2 -> addressBook.display();
                case 3 -> {
                    System.out.print("Enter the first name of the contact to edit: ");
                    String firstName = sc.next();
                    System.out.print("Enter the last name of the contact to edit: ");
                    String lastName = sc.next();
                    addressBook.editContact(firstName, lastName);
                }
                case 4 -> {
                    System.out.print("Enter the first name of the contact to delete: ");
                    String firstName = sc.next();
                    System.out.print("Enter the last name of the contact to delete: ");
                    String lastName = sc.next();
                    addressBook.deleteContact(firstName, lastName);
                }
                case 5 -> addressBook.createMultipleContacts();
                case 0 -> {
                    System.out.println("Thank you for using Address Book!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
